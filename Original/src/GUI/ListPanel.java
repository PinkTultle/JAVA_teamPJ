package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GUI.C_Component.MyFL;
import GUI.C_Component.MyJT;
import GUI.C_Component.itemSlot_list;
import JDBC.ItemDAO;
import JDBC.ItemDTO;

public class ListPanel extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT textField;
	private JButton btnNewButton;
	private RoundButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private itemSlot_list is;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;

	private int maxPage = 10; // 최대 페이지 수 | 테스트용 값 10 : 후에 최대 페이지 값을 받는 동작 필요
	private int nowPage = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPanel frame = new ListPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListPanel() { // 콤보 박스에 이벤트 추가 필요
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 900);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 23, 1034, 700);

		contentPane.add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "전자기기", "가구/인테리어", "유아용품", "뷰티/패션잡화",
				"가전/생활/주방", "스포츠/레저", "취미/게임/도서", "동물용품", "렌트 원해요" }));
		comboBox.setBounds(62, 46, 110, 35);
		comboBox.addActionListener(this);
		panel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "전체", "대여가능", "예약중", "대여중" }));
		comboBox_1.setBounds(184, 46, 110, 35);
		comboBox_1.addActionListener(this);
		panel.add(comboBox_1);

		textField = new MyJT("검색어를 입력하세요");
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField.addFocusListener(new MyFL());
		textField.setBounds(316, 46, 200, 35);
		panel.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("검색"); // 검색 아이콘 추가 필요
		btnNewButton.setBounds(528, 46, 33, 35);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);

		btnNewButton_1 = new RoundButton("상품 등록하기");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_1.setColorNormal(new Color(41, 76, 121));
		btnNewButton_1.setBounds(842, 31, 154, 45);
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);

		is = new itemSlot_list(57, 110, 920, 520);
		panel.add(is);

		JLabel lblNewLabel = new JLabel("page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(484, 648, 66, 15);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(487, 665, 60, 15);
		lblNewLabel_1.setText(String.valueOf(nowPage));
		panel.add(lblNewLabel_1);

		btnNewButton_3 = new JButton("다음 페이지");
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_3.setBounds(888, 650, 110, 23);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(14, 180, 252));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(null);
		panel.add(btnNewButton_3);

		btnNewButton_2 = new JButton("이전 페이지");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2.setBounds(766, 650, 110, 23);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(14, 180, 252));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(null);
		panel.add(btnNewButton_2);
		
		/*// 데이터 입력 테스트용 코드
		Vector<String[]> vector = new Vector<String[]>();
		for (int i = 0; i < 10; i++) {
			vector.addElement(new String[] { String.valueOf(i + 1), "asdf", "asdf", "asdf", "asdf", "asdf" });
		}*/
		is.setPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) { // 검색 동작
			// textField : 검색어 텍스트 필드 객체
			System.out.println(((JButton) (e.getSource())).getText());
			if (textField.isTyped) { // textField 의 입력 확인
				System.out.println(textField.getText());
			}
		} else if (e.getSource() == btnNewButton_1) { // 상품 등록하기 동작
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == btnNewButton_2) { // 이전 페이지 동작
			if (nowPage != 1) { // 1 페이지가 아닐 경우
				System.out.println(((JButton) (e.getSource())).getText());
				lblNewLabel_1.setText(String.valueOf(--nowPage));
				// 물품 목록 수정 필요
			}
		} else if (e.getSource() == btnNewButton_3) { // 다음 페이지 동작
			if (nowPage != maxPage) {
				System.out.println(((JButton) (e.getSource())).getText());
				lblNewLabel_1.setText(String.valueOf(++nowPage));
				// 물품 목록 수정 필요
			}
		} else if (e.getSource() == comboBox) { // 카테고리 콤보박스 동작
			System.out.println(((JComboBox) (e.getSource())).getSelectedItem().toString());
		} else if (e.getSource() == comboBox_1) { // 처리상태 콤보박스 동작
			System.out.println(((JComboBox) (e.getSource())).getSelectedItem().toString());
		}
	}
}
