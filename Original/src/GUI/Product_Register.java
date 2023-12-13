package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import GUI.C_Component.MyJT;
import GUI.C_Component.MyKA_Num;
import JDBC.ItemDAO;
import JDBC.ItemDTO;
import JDBC.UserDAO;
import JDBC.UserDTO;

public class Product_Register extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private MyJT PdName_text;
	private JLabel LentDate_text;
	private MyJT Model_text;
	private MyJT Deposit_text;
	private MyJT LentalFee_text;
	private JLabel Phone_text;
	private JTextArea Description_text;
	private JComboBox Category_combox;
	private RoundButton Register_btn, Cancel_btn;
	private JCheckBox SafeNumber_Check;
	private JLabel depositLabel;

	private LocalDate date;
	private String phoneNum;

	public Product_Register() {
		// 패널 크기 및 배경색
		getContentPane().setBackground(new Color(250, 250, 250));
		setBounds(Main_frame.mainFrame.getX() + 118, Main_frame.mainFrame.getY() + 100, 823, 669);
		setTitle("상품등록");
		getContentPane().setLayout(null);

		UserDAO userDAO = new UserDAO();
		UserDTO userData = userDAO.userSelect(UserDAO.user_cur);

		String tmp = "0" + Integer.toString(userData.getTel());
		phoneNum = tmp.substring(0, 3) + "-" + tmp.substring(3, 7) + "-" + tmp.substring(7, 11);

		// 라벨

		JLabel PdName_Label = new JLabel("품 목 명");
		PdName_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PdName_Label.setBounds(40, 30, 90, 32);
		getContentPane().add(PdName_Label);

		JLabel Lentdate_Label = new JLabel("렌트기한");
		Lentdate_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Lentdate_Label.setBounds(40, 80, 90, 32);
		getContentPane().add(Lentdate_Label);

		JLabel Deposit_Label = new JLabel("보 증 금");
		Deposit_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Deposit_Label.setBounds(393, 130, 90, 32);
		getContentPane().add(Deposit_Label);

		JLabel Description_Label = new JLabel("설     명");
		Description_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Description_Label.setBounds(40, 230, 90, 32);
		getContentPane().add(Description_Label);

		JLabel Modelname_Label = new JLabel("모 델 명");
		Modelname_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Modelname_Label.setBounds(393, 80, 90, 32);
		getContentPane().add(Modelname_Label);

		JLabel Percent_Label = new JLabel("%");
		Percent_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		Percent_Label.setBounds(590, 130, 25, 32);
		getContentPane().add(Percent_Label);

		JLabel LentalFee_Label = new JLabel("대여료(1일)");
		LentalFee_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		LentalFee_Label.setBounds(40, 130, 90, 32);
		getContentPane().add(LentalFee_Label);

		JLabel Phone_Label = new JLabel("전화번호");
		Phone_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Phone_Label.setBounds(450, 180, 90, 32);
		getContentPane().add(Phone_Label);

		// 텍스트 필드
		Description_text = new JTextArea();
		Description_text.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Description_text.setBackground(new Color(255, 255, 255));
		Description_text.setBounds(40, 265, 725, 271);
		getContentPane().add(Description_text);

		PdName_text = new MyJT();
		PdName_text.setBounds(120, 30, 520, 32);
		getContentPane().add(PdName_text);

		LentDate_text = new JLabel();
		LentDate_text.setBackground(Color.white);
		LentDate_text.setOpaque(true);
		LentDate_text.setHorizontalAlignment(SwingConstants.CENTER);
		LentDate_text.setBorder(new LineBorder(Color.lightGray));
		LentDate_text.setBounds(120, 80, 193, 32);
		getContentPane().add(LentDate_text);

		Model_text = new MyJT();
		Model_text.setColumns(10);
		Model_text.setBounds(471, 80, 294, 32);
		getContentPane().add(Model_text);

		Deposit_text = new MyJT();
		Deposit_text.setHorizontalAlignment(SwingConstants.TRAILING);
		Deposit_text.setBounds(469, 130, 116, 32);
		((PlainDocument) Deposit_text.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
				currentText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

				try {
					int value = Integer.parseInt(currentText);
					if (value <= 100) {
						super.replace(fb, offset, length, text, attrs);
					}
				} catch (NumberFormatException e) {
					// Ignore non-integer input
				}
			}
		});
		Deposit_text.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (Deposit_text.getText().equals(""))
					Deposit_text.isTyped = false;
				update_deposit();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				Deposit_text.isTyped = true;
				update_deposit();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		getContentPane().add(Deposit_text);

		LentalFee_text = new MyJT();
		LentalFee_text.setHorizontalAlignment(SwingConstants.TRAILING);
		LentalFee_text.addKeyListener(new MyKA_Num(20));
		LentalFee_text.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (LentalFee_Label.getText().equals(""))
					LentalFee_text.isTyped = false;
				update_deposit();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				LentalFee_text.isTyped = true;
				update_deposit();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		LentalFee_text.setBounds(120, 130, 237, 32);
		getContentPane().add(LentalFee_text);

		Phone_text = new JLabel();
		Phone_text.setText(phoneNum);
		Phone_text.setHorizontalAlignment(SwingConstants.CENTER);
		Phone_text.setBorder(new LineBorder(Color.LIGHT_GRAY));
		Phone_text.setBackground(Color.white);
		Phone_text.setOpaque(true);
		Phone_text.setBounds(516, 180, 171, 32);
		getContentPane().add(Phone_text);

		// 콤보박스
		Category_combox = new JComboBox();
		Category_combox.setBounds(652, 30, 113, 32);
		Category_combox.setModel(new DefaultComboBoxModel(new String[] { "카테고리", "전자기기", "가구/인테리어", "유아용품", "뷰티",
				"패션잡화", "가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타" }));
		getContentPane().add(Category_combox);

		SafeNumber_Check = new JCheckBox("안심번호");
		SafeNumber_Check.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		SafeNumber_Check.setBackground(Color.WHITE);
		SafeNumber_Check.setBounds(695, 180, 80, 32);
		SafeNumber_Check.setOpaque(false);
		SafeNumber_Check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (SafeNumber_Check.isSelected()) {
					Phone_text.setText("010-XXXX-XXXX");
				} else {
					Phone_text.setText(phoneNum);
				}
			}
		});
		getContentPane().add(SafeNumber_Check);

		Register_btn = new RoundButton("등록");
		Register_btn.setForeground(new Color(255, 255, 255));
		// Register_btn.setBackground(new Color(41, 76, 121));
		Register_btn.setColorNormal(new Color(41, 76, 121));
		Register_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));

		Register_btn.setBounds(555, 571, 83, 42);
		Register_btn.addActionListener(this);
		getContentPane().add(Register_btn);

		Cancel_btn = new RoundButton("취소", Color.black);
		Cancel_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Cancel_btn.setBounds(677, 571, 83, 42);
		Cancel_btn.addActionListener(this);
		getContentPane().add(Cancel_btn);

		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(617, 130, 30, 32);
		getContentPane().add(lblNewLabel);

		depositLabel = new JLabel("0 ");
		depositLabel.setBackground(new Color(255, 255, 255));
		depositLabel.setBorder(new LineBorder(Color.lightGray));
		depositLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		depositLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		depositLabel.setBounds(652, 130, 113, 32);
		getContentPane().add(depositLabel);

		dateChooser dc = new dateChooser(325, 80, 32, 32);
		dc.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					java.util.Date d = dc.getDate();
					if (d != null) {
						date = LocalDate.ofInstant(d.toInstant(), ZoneId.systemDefault());
						LentDate_text.setText(date.toString());
						dc.setDate(null);
					}
				}
			}
		});
		getContentPane().add(dc);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Cancel_btn) {
			int result = JOptionPane.showConfirmDialog(null, "나가시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (result == JOptionPane.YES_OPTION)
				dispose();
		} else if (e.getSource() == Register_btn) {
			int result = check();

			if (result == 0) {
				insert();

				JOptionPane.showMessageDialog(null, "물품 등록이 완료되었습니다!", "상품등록", JOptionPane.DEFAULT_OPTION);
				ListPanel lp = (ListPanel) Main_frame.P2;
				lp.refresh();
				dispose();

			}

		}
	}

	// 인식 못하는 문제 해결 필요
	void update_deposit() {
		if (Deposit_text.isTyped && LentalFee_text.isTyped) {
			int per = Integer.parseInt(Deposit_text.getText());
			int fee = Integer.parseInt(LentalFee_text.getText());
			depositLabel.setText(Integer.toString((int) (fee / 100.0 * per)) + " ");
		} else {
			depositLabel.setText("0 ");
		}
	}

	int check() {
		int result = 0;
		String warn = "아래 항목들이 부족합니다.\n";

		if (Category_combox.getSelectedItem().toString().equals("카테고리")) {
			result++;
			warn += "-카테고리\n";
		}

		if (PdName_text.getText().equals("")) {
			result++;
			warn += "-물품명\n";
		}
		if (LentDate_text.getText().equals("")) {
			result++;
			warn += "-렌트기한\n";
		}

		if (Model_text.getText().equals("")) {
			result++;
			warn += "-모델명\n";
		}

		if (LentalFee_text.getText().equals("")) {
			result++;
			warn += "-대여료\n";
		}

		if (Deposit_text.getText().equals("")) {
			result++;
			warn += "-보증금\n";
		}

		if (result != 0) {
			JOptionPane.showMessageDialog(null, warn, "경고", JOptionPane.WARNING_MESSAGE);
		}
		return result;
	}

	void insert() {
		int result = 0;
		ItemDAO itemDAO = new ItemDAO();
		ItemDTO itemDTO = new ItemDTO();

		itemDTO.setCategory(Category_combox.getSelectedItem().toString());
		itemDTO.setItemname(PdName_text.getText());
		itemDTO.setRentdate(date.toString());
		itemDTO.setModelname(Model_text.getText());
		itemDTO.setRentalfee(Integer.parseInt(LentalFee_text.getText()));
		// 끝에 공백 삭제
		itemDTO.setDeposit(Integer.parseInt(depositLabel.getText().substring(0, depositLabel.getText().length() - 1)));
		itemDTO.setExplanation(Description_text.getText());
		itemDTO.setPerson(UserDAO.user_cur);
		itemDTO.setSafeTEL(SafeNumber_Check.isSelected());

		// DB 연결 없이
		result = itemDAO.insertItem(itemDTO);

	}

}
