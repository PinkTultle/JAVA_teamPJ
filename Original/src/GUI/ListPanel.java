package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.MyJT;
import GUI.C_Component.itemSlot_list;

public class ListPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();
	private static MyJT textField;
	private JButton btnNewButton;
	private RoundButton btnNewButton_1;
	private bt_next btnNewButton_2;
	private bt_next btnNewButton_3;
	private static itemSlot_list is;
	private static JLabel lblNewLabel_1;
	private JLabel[] tableHeader = new JLabel[6];
	private static JComboBox<String> comboBox;
	private static JComboBox<String> comboBox_1;

	/**
	 * Create the frame.
	 */
	public ListPanel() { // 콤보 박스에 이벤트 추가 필요

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1050, 720);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "전자기기", "가구/인테리어", "유아용품", "뷰티", "패션잡화",
				"가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타", "요청" }));
		comboBox.setBounds(62, 46, 110, 35);
		comboBox.addActionListener(this);
		add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "전체", "대여가능", "승인대기", "대여중" }));
		comboBox_1.setBounds(184, 46, 110, 35);
		comboBox_1.addActionListener(this);
		add(comboBox_1);

		textField = new MyJT("검색어를 입력하세요");
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField.setBounds(316, 46, 200, 35);
		add(textField);
		textField.setColumns(10);

		btnNewButton = new search_bt(); // 검색 아이콘 추가 필요
		btnNewButton.setBounds(528, 46, 33, 35);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		btnNewButton_1 = new RoundButton("상품 등록");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_1.setColorNormal(new Color(41, 76, 121));
		btnNewButton_1.setBounds(880, 70, 100, 35);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		is = new itemSlot_list(57, 150, 920, 480, 12);
		is.getViewport().setBackground(new Color(243, 246, 249));
		add(is);

		JLabel lblNewLabel = new JLabel("page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(484, 648, 66, 15);
		add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(487, 665, 60, 15);
		lblNewLabel_1.setText("1");
		add(lblNewLabel_1);

		btnNewButton_3 = new bt_next(888, 640, 50, 50, true);
		btnNewButton_3.addActionListener(this);
		add(btnNewButton_3);

		btnNewButton_2 = new bt_next(766, 640, 50, 50, false);
		btnNewButton_2.addActionListener(this);
		add(btnNewButton_2);

		is.setPage(null, null, null);

		int[] xLoc = { 67, 180, 415, 652, 770, 880 };
		String[] headerText = { "물품코드", "카테고리", "물품명", "등록자", "렌트 기한", "처리 상태" };
		Font hFont = new Font("맑은 고딕", Font.PLAIN, 16);

		for (int i = 0; i < 6; i++) {
			tableHeader[i] = new JLabel(headerText[i]);
			tableHeader[i].setBounds(xLoc[i], 114, 86, 40);
			tableHeader[i].setHorizontalAlignment(SwingConstants.CENTER);
			tableHeader[i].setFont(hFont);
			add(tableHeader[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) { // 검색 동작
			// textField : 검색어 텍스트 필드 객체
			search(comboBox.getSelectedItem().toString(), textField.getText(), comboBox_1.getSelectedItem().toString());
			if (textField.isTyped) { // textField 의 입력 확인
			}
		} else if (e.getSource() == btnNewButton_1) { // 상품 등록하기 동작
			new Product_Register();
		} else if (e.getSource() == btnNewButton_2) { // 이전 페이지 동작
			lblNewLabel_1.setText(String.valueOf(is.prevPage()));
		} else if (e.getSource() == btnNewButton_3) { // 다음 페이지 동작
			lblNewLabel_1.setText(String.valueOf(is.nextPage()));
		} else if (e.getSource() == comboBox) { // 카테고리 콤보박스 동작
		} else if (e.getSource() == comboBox_1) { // 처리상태 콤보박스 동작
		}
	}

	public static void clear() {
		comboBox.setSelectedItem("전체");
		comboBox_1.setSelectedItem("전체");
		textField.setText(textField.init);
		is.changePage(1);
		lblNewLabel_1.setText("1");
	}

	public static void searchCategory(String category) {
		// 입력된 카테고리로 설정
		clear();
		comboBox.setSelectedItem(category);
		search(category, null, null);
	}

	public static void serachItemName(String itemName) {
		// 입력된 카테고리로 설정
		clear();
		textField.setText(itemName);
		search(null, itemName, null);
	}

	public static void search(String category, String itemName, String status) {
		if (category == null || category.equals("전체"))
			category = null;
		if (itemName == null || itemName.equals("검색어를 입력하세요"))
			itemName = null;
		if (status == null || status.equals("전체"))
			status = null;
		is.setPage(category, itemName, status);
	}

	public void refresh() {
		clear();
		searchCategory("전체");
		repaint();
	}
}
