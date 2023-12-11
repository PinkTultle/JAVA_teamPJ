package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import GUI.C_Component.MyJT;
import GUI.C_Component.MyJT_TEL;
import GUI.C_Component.MyKA_Num;
import GUI.C_Component.MyPT;
import JDBC.UserDAO;
import JDBC.UserDTO;

// 주석 및 추가 작업 필요

public class RegisterGUI extends JDialog implements ActionListener {

	final private JFrame LoginGUI;
	UserDTO userDTO;
	UserDAO userDAO;

	private boolean Id_check, Num_check, address_check;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT textField;
	private MyPT textField_1;
	private MyJT textField_2;
	private MyJT textField_3;
	private MyJT textField_4;
	private MyJT textField_5;
	private MyJT textField_6;

	private JLabel gol;
	private JComboBox<String> email;

	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	private JToggleButton btnNewButton;
	private JToggleButton btnNewButton_1;
	private ButtonGroup BG = new ButtonGroup();

	private BorderFactory bf;
	private JTextField removefirstfocus;

	private MyJT_TEL textField_TEL[] = new MyJT_TEL[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @param loginGUI2
	 */
	public RegisterGUI(JFrame loginGUI) {
		this.LoginGUI = loginGUI;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		KeyAdapter KA = new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				JTextField jt = (JTextField) k.getSource();
				if ("1234567890".indexOf(k.getKeyChar()) == -1) { // 숫자로 입력 제한
					k.consume();
				}
				if (jt.getText().length() == 3 && "1234567890".indexOf(k.getKeyChar()) != -1) { // 포커스 이동
					if (k.getSource() == textField_TEL[0]) {
						textField_TEL[1].requestFocus();
					} else {
						removefirstfocus.requestFocus();
					}
				}
				if (jt.getText().length() > 3) { // 글자 수 제한
					k.consume();
				}
			}
		};

		Font slotFont = new Font("맑은 고딕", Font.PLAIN, 15);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 34));
		lblNewLabel.setBounds(375, 10, 298, 66);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(292, 73, 470, 474);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 25, true));
		panel_1.setBounds(10, 10, 450, 454);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(12, 10, 426, 434);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		textField = new MyJT("아이디");
		textField.setFont(slotFont);
		textField.setBounds(28, 10, 282, 38);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new MyPT("비밀번호");
		textField_1.setFont(slotFont);
		textField_1.setColumns(10);
		textField_1.setBounds(28, 58, 360, 38);
		panel_2.add(textField_1);

		textField_2 = new MyJT("별명");
		textField_2.setFont(slotFont);
		textField_2.setColumns(10);
		textField_2.setBounds(28, 106, 360, 38);
		panel_2.add(textField_2);

		textField_3 = new MyJT("이름");
		textField_3.setFont(slotFont);
		textField_3.setColumns(10);
		textField_3.setBounds(28, 154, 360, 38);
		panel_2.add(textField_3);

		textField_4 = new MyJT("생년월일 8자리");
		textField_4.setFont(slotFont);
		textField_4.setColumns(10);
		textField_4.setBounds(28, 202, 184, 38);

		textField_4.addKeyListener(new MyKA_Num(8));

		panel_2.add(textField_4);

		textField_5 = new MyJT("주소");
		textField_5.setFont(slotFont);
		textField_5.setText("주소");
		textField_5.setColumns(10);
		textField_5.setBounds(28, 250, 282, 38);
		// textField_5.addFocusListener(FL);
		// textField_5.setEditable(false);
		panel_2.add(textField_5);

		textField_6 = new MyJT("이메일");
		textField_6.setFont(slotFont);
		textField_6.setText("이메일");
		textField_6.setColumns(10);
		textField_6.setBounds(28, 346, 140, 38);
		panel_2.add(textField_6);

		gol = new JLabel("@");
		// gol.setFont(slotFont);
		gol.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		gol.setBounds(textField_6.getX() + 155, textField_6.getY() - 10, 50, 50);
		panel_2.add(gol);

		String[] item = new String[] { "선택", "naver.com", "daum.net", "gmail.com", "직접입력", "" };
		ComboBoxModel_register<String> cmr = new ComboBoxModel_register<String>(item);
		cmr.setInvisibleItem("");
		email = new JComboBox<String>();
		email.setFont(slotFont);
		email.setModel(cmr);
		email.setBounds(gol.getX() + gol.getWidth() - 5, textField_6.getY(), textField_6.getWidth() + 20,
				textField_6.getHeight());
		email.addActionListener(this);
		email.setSelectedIndex(0);
		panel_2.add(email);

		btnNewButton = new JToggleButton("남자", true); // 아무것도 체크 안할경우 에러방지
		btnNewButton.setFont(slotFont);
		btnNewButton.setBounds(224, 202, 76, 38);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(btnNewButton);
		panel_2.add(btnNewButton);

		btnNewButton_1 = new JToggleButton("여자");
		btnNewButton_1.setFont(slotFont);
		btnNewButton_1.setBounds(312, 202, 76, 38);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(btnNewButton_1);
		panel_2.add(btnNewButton_1);

		btnNewButton_2 = new JButton("검색");
		btnNewButton_2.setFont(slotFont);
		btnNewButton_2.setBounds(322, 250, 66, 38);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_2.addActionListener(this);
		panel_2.add(btnNewButton_2);

		btnNewButton_3 = new JButton("인증");
		btnNewButton_3.setFont(slotFont);
		btnNewButton_3.setBounds(322, 298, 66, 38);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_3.addActionListener(this);
		panel_2.add(btnNewButton_3);

		btnNewButton_4 = new JButton("가입");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setBorder(bf.createEmptyBorder());
		btnNewButton_4.setBackground(new Color(31, 66, 121));
		btnNewButton_4.setBounds(332, 395, 75, 30);
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setEnabled(false); // 아이디 중복 검색 하면 활성화 됨(기본 비활성화)
		panel_2.add(btnNewButton_4);

		btnNewButton_5 = new JButton("중복");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(322, 10, 66, 38);
		btnNewButton_5.addActionListener(this);
		panel_2.add(btnNewButton_5);

		JTextField textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setFont(slotFont);
		textField_8.setBounds(28, 298, 60, 38);
		textField_8.setText("010");
		textField_8.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(textField_8);

		textField_TEL[0] = new MyJT_TEL("");
		textField_TEL[0].setFont(slotFont);
		textField_TEL[0].setColumns(10);
		textField_TEL[0].setBounds(117, 298, 82, 38);
		textField_TEL[0].addKeyListener(KA);
		panel_2.add(textField_TEL[0]);

		textField_TEL[1] = new MyJT_TEL("");
		textField_TEL[1].setFont(slotFont);
		textField_TEL[1].setColumns(10);
		textField_TEL[1].setBounds(228, 298, 82, 38);
		textField_TEL[1].addKeyListener(KA);
		panel_2.add(textField_TEL[1]);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setFont(slotFont);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(93, 312, 19, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(slotFont);
		lblNewLabel_1_1.setBounds(204, 312, 19, 15);
		panel_2.add(lblNewLabel_1_1);

		removefirstfocus = new JTextField();
		removefirstfocus.setBounds(-200, 10, 116, 21);
		panel_2.add(removefirstfocus);
		removefirstfocus.setColumns(10);

		setVisible(true);

		userDTO = new UserDTO();
	}

	// 아이디 중복 검사 메서드
	private void Duplicate() {

		if (textField.getText() == null || textField.getText().equals("아이디")) {
			JOptionPane.showConfirmDialog(this, "아이디를 입력하십시오!", "아이디 중복", JOptionPane.DEFAULT_OPTION,
					JOptionPane.ERROR_MESSAGE);
			return;

		} else {

			userDAO = new UserDAO();

			try {
				int n = userDAO.userIdCheck(textField.getText());

				if (n == 0) { // 같은 아이디가 없을경우
					int dlog = JOptionPane.showConfirmDialog(this,
							"아이디 " + textField.getText() + "를 사용 하시겠습니까?\n결정 후에는 변경할 수 없습니다!", "사용 확인",
							JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

					if (dlog == 2)
						return;
					if (dlog == 0) {
						textField.setEditable(false);
						btnNewButton_5.setEnabled(false);
						Id_check = true;
					}

				} else { // 같은 아이디가 있을경우
					JOptionPane.showConfirmDialog(this, "이미 존재하는 아이디입니다", "경고", JOptionPane.DEFAULT_OPTION,
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (SQLException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}

	}

	private void Join() {

		String id = null, pw = null, name = null, address = null, email_1 = null, gender = null, nick = null;
		int birth = 0, tel = 0;

		userDAO = new UserDAO();

		try {

			// 조건 확인 버튼 4개 통과 여부 검색
			// 버튼 클릭하여 통과하지 않고넘어간 경우 예외처리 발생
			if (Id_check == false)
				throw new Exception("ID");
			if (address_check == false)
				throw new Exception("주소 검색을");
			if (Num_check == false)
				throw new Exception("전화번호를 인증");
			if (email.getSelectedItem().toString().equals("선택") || email.getSelectedItem().toString().equals(null))
				throw new Exception("선택한 email 주소를 확인");

			// 그외 텍스트 필드에서 잘못된 값이 입력된 경우 예외 처리
			if (textField_2.getText().equals(null))
				throw new Exception("별명");
			if (textField_3.getText().equals(null))
				throw new Exception("이름");
			if (textField_4.getText().equals(null))
				throw new Exception("생년월일");
			if (textField_6.getText().equals(null))
				throw new Exception("email ID");
			if (textField_6.getText().equals(null))
				throw new Exception("email ID");

			id = textField.getText();
			pw = new String(textField_1.getPassword());
			if (pw.equals(null))
				throw new Exception("password");

			nick = textField_2.getText();
			name = textField_3.getText();
			birth = Integer.parseInt(textField_4.getText());
			address = textField_5.getText();
			email_1 = textField_6.getText() + "@" + email.getSelectedItem().toString();
			tel = Integer.parseInt(textField_TEL[0].getText() + textField_TEL[1].getText());

			if (btnNewButton.isSelected()) {
				gender = "남자";
			} else if (btnNewButton_1.isSelected()) {
				gender = "여자";
			}

		} catch (Exception e) {
			int mode = 0;

			switch (e.getMessage().toString()) {
			case "password":
			case "별명":
			case "이름":
			case "생년월일":
			case "email ID":
				mode = 1;
				break;
			case "주소 검색을":
			case "전화번호를 인증":
			case "email 주소를 선택":
			case "ID":
				mode = 0;
				break;
			default:
				mode = 2;
				break;

			}

			if (mode == 0) {
				JOptionPane.showConfirmDialog(null, /*"입력한 " +*/ e.getMessage().toString() + "해 주십시요!!", "경고",
						JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
			if (mode == 1) {
				JOptionPane.showConfirmDialog(null, e.getMessage().toString() + "를 입력해 주십시요!!", "경고",
						JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
			}
			if (mode == 2) {
				JOptionPane.showConfirmDialog(null, "필요한 값을 모두 입력해주십시오!!!", "경고", JOptionPane.DEFAULT_OPTION,
						JOptionPane.ERROR_MESSAGE);
			}

			return;
		}

		userDTO = new UserDTO(id, pw, nick, name, birth, gender, tel, address, email_1, 0);

		try {
			int n = userDAO.userInsert(userDTO);
			if (n >= 1) {
				new popup_JDialog("알림", "회원가입 되었습니다!");
				LoginGUI.setVisible(true);
				dispose();

			} else if (n == 0) {
				new popup_JDialog("회원가입 실패", "잠시후 다시시도해 주십시요");
			} else if (n == -1) {
				// System.out.println("아이디 중복");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private boolean satisfaction() {
		if (Id_check == true && Num_check == true && address_check == true) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnNewButton_5) { // 중복 버튼 동작
			Duplicate();
		}

		if (e.getSource() == btnNewButton_2) { // 검색 버튼
			if (!textField_5.getText().equals("주소")) {
				address_check = true;
				new popup_JDialog("주소확인", "확인되었습니다");
				textField_5.setEditable(false);
				btnNewButton_2.setEnabled(false);
			} else {
				address_check = false;
				new popup_JDialog("주소확인", "다시 입력해주세요");
			}
		}

		if (e.getSource() == btnNewButton_3) { // 인증 버튼 동작
			if ((textField_TEL[0].getText().length() == 4) && (textField_TEL[1].getText().length() == 4)) {
				Num_check = true;
				new popup_JDialog("번호확인", "확인되었습니다");
				textField_TEL[0].setEditable(false);
				textField_TEL[1].setEditable(false);
				btnNewButton_3.setEnabled(false);
			} else {
				Num_check = false;
				new popup_JDialog("번호확인", "다시 입력해주세요");
			}
		}

		if (e.getSource() == btnNewButton_4) { // 가입 버튼 동작
			Join();

		}

		if (e.getSource() == email) {

			if (email.getSelectedItem().toString().equals("직접입력")) {
				email.setEditable(true);
				email.setSelectedItem("");
			} else {
				email.setEditable(false);
			}
		}

		if (satisfaction()) {
			btnNewButton_4.setEnabled(true);
		}

	}

	private static class ComboBoxModel_register<E> extends DefaultComboBoxModel<E> {
		private Object[] visibleItems = null;

		ComboBoxModel_register(E[] items) {
			super();
			this.visibleItems = items;
		}

		@Override
		public int getSize() {
			return visibleItems.length;
		}

		@Override
		public E getElementAt(int index) {
			return (E) visibleItems[index];
		}

		// 특정 아이템을 제외하고 모델을 갱신
		public void setInvisibleItem(E item) {
			Object[] newArray = new Object[visibleItems.length - 1];
			int newIndex = 0;
			for (Object currentItem : visibleItems) {
				if (!currentItem.equals(item)) {
					newArray[newIndex++] = currentItem;
				}
			}
			visibleItems = newArray;
			fireContentsChanged(this, 0, getSize() - 1);
		}
	}

	// textField : 아이디 입력 JTextField
	// textField_1 : 패스워드 입력 JPasswordField
	// textField_2 : 별명 입력 JTextField
	// textField_3 : 이름 입력 JTextField
	// textField_4 : 생일 입력 JTextField
	// textField_5 : 주소 입력 JTextField
	// textField_6 : 이메일 입력 JTextField
	// textField_TEL[] : 전화번호 입력 4자리 JTextField
}
