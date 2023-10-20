package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

// 주석 및 추가 작업 필요
public class RegisterGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT textField;
	private MyPT textField_1;
	private MyJT textField_2;
	private MyJT textField_3;
	private MyJT textField_4;
	private MyJT textField_5;
	private MyJT textField_6;

	private JButton btnNewButton;
	private JButton btnNewButton_1;

	private BorderFactory bf;
	private JTextField removefirstfocus;

	private boolean male = false;
	private boolean female = false;
	private JTextField textField_TEL[] = new JTextField[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);


		setContentPane(contentPane);
		contentPane.setLayout(null);

		ML_btn listener_btn = new ML_btn();
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
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField.setBounds(28, 10, 282, 38);
		textField.addFocusListener(new MyFL_T(textField));
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new MyPT("비밀번호");
		textField_1.setEchoChar((char) 0);
		textField_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(28, 58, 360, 38);
		textField_1.addFocusListener(new MyFL_P(textField_1));
		panel_2.add(textField_1);

		textField_2 = new MyJT("별명");
		textField_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(28, 106, 360, 38);
		textField_2.addFocusListener(new MyFL_T(textField_2));
		panel_2.add(textField_2);

		textField_3 = new MyJT("이름");
		textField_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(28, 154, 360, 38);
		textField_3.addFocusListener(new MyFL_T(textField_3));
		panel_2.add(textField_3);

		textField_4 = new MyJT("생년월일 8자리");
		textField_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(28, 202, 184, 38);
		textField_4.addFocusListener(new MyFL_T(textField_4));

		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				if (textField_4.getText().length() > 7 || "1234567890".indexOf(k.getKeyChar()) == -1) {
					k.consume();
				}
			}
		});

		panel_2.add(textField_4);

		textField_5 = new MyJT("주소");
		textField_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_5.setText("주소");
		textField_5.setColumns(10);
		textField_5.setBounds(28, 250, 282, 38);
		textField_5.addFocusListener(new MyFL_T(textField_5));
		panel_2.add(textField_5);

		textField_6 = new MyJT("이메일");
		textField_6.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_6.setText("이메일");
		textField_6.setColumns(10);
		textField_6.setBounds(28, 346, 360, 38);
		textField_6.addFocusListener(new MyFL_T(textField_6));
		panel_2.add(textField_6);

		btnNewButton = new JButton("남자");
		btnNewButton.addMouseListener(listener_btn);
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(224, 202, 76, 38);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		panel_2.add(btnNewButton);

		btnNewButton_1 = new JButton("여자");
		btnNewButton_1.addMouseListener(listener_btn);
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_1.setBounds(312, 202, 76, 38);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		panel_2.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_2.setBounds(322, 250, 66, 38);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("인증");
		btnNewButton_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_3.setBounds(322, 298, 66, 38);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		panel_2.add(btnNewButton_3);

		removefirstfocus = new JTextField();
		removefirstfocus.setBounds(-200, 10, 116, 21);
		panel_2.add(removefirstfocus);
		removefirstfocus.setColumns(10);

		JButton btnNewButton_4 = new JButton("가입");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setBorder(bf.createEmptyBorder());
		btnNewButton_4.setBackground(new Color(31, 66, 121));
		btnNewButton_4.setBounds(332, 395, 75, 30);
		panel_2.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("중복");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(322, 10, 66, 38);
		panel_2.add(btnNewButton_5);

		JTextField textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_8.setBounds(28, 298, 60, 38);
		textField_8.setText("010");
		textField_8.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(textField_8);

		textField_TEL[0] = new JTextField();
		textField_TEL[0].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_TEL[0].setColumns(10);
		textField_TEL[0].setBounds(117, 298, 82, 38);
		textField_TEL[0].addFocusListener(new MyFL_TEL(textField_TEL[0]));
		textField_TEL[0].addKeyListener(KA);
		panel_2.add(textField_TEL[0]);

		textField_TEL[1] = new JTextField();
		textField_TEL[1].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		textField_TEL[1].setColumns(10);
		textField_TEL[1].setBounds(228, 298, 82, 38);
		textField_TEL[1].addFocusListener(new MyFL_TEL(textField_TEL[1]));
		textField_TEL[1].addKeyListener(KA);
		panel_2.add(textField_TEL[1]);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setFont(new Font("돋움", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(93, 312, 19, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("돋움", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(204, 312, 19, 15);
		panel_2.add(lblNewLabel_1_1);
	}

	static class MyJT extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected boolean isTyped = false;
		protected String init;

		public MyJT(String s) {
			// TODO Auto-generated constructor stub
			init = s;
			setText(s);
		}

	}

	class MyPT extends JPasswordField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected boolean isTyped = false;
		protected String init;

		public MyPT(String s) {
			// TODO Auto-generated constructor stub
			init = s;
			setText(s);
		}

	}

	static class MyFL_T implements FocusListener {
		private MyJT textField;

		public MyFL_T(MyJT textField) {
			// TODO Auto-generated constructor stub
			this.textField = textField;
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (!textField.isTyped) {
				textField.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (!textField.getText().isEmpty()) {
				textField.isTyped = true;
			} else {
				textField.isTyped = false;
			}
			if (!textField.isTyped) {
				textField.setText(textField.init);
			}
		}
	}

	class MyFL_P implements FocusListener {
		private MyPT passwordField;

		public MyFL_P(MyPT passwordField) {
			// TODO Auto-generated constructor stub
			this.passwordField = passwordField;
		}

		@Override
		public void focusGained(FocusEvent e) {
			if (!passwordField.isTyped) {
				passwordField.setText("");
				passwordField.setEchoChar('*');
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (!passwordField.getText().isEmpty()) {
				passwordField.isTyped = true;
			} else {
				passwordField.isTyped = false;
				passwordField.setEchoChar((char) 0);
			}
			if (!passwordField.isTyped) {
				passwordField.setText(passwordField.init);
			}
		}
	}

	class MyFL_TEL implements FocusListener {
		private JTextField textField;

		public MyFL_TEL(JTextField textField) {
			// TODO Auto-generated constructor stub
			this.textField = textField;
		}

		@Override
		public void focusGained(FocusEvent e) {
			textField.setHorizontalAlignment(JTextField.LEFT);
		}

		@Override
		public void focusLost(FocusEvent e) {
			textField.setHorizontalAlignment(JTextField.CENTER);
		}
	}

	class ML_btn implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource() == btnNewButton) { // 남자 버튼이 눌렸을때
				if (female) {
					female = false;
					btnNewButton_1.setBackground(new Color(255, 255, 255));
				}
				male = true;
				btnNewButton.setBackground(new Color(210, 210, 210));
			} else { // 여자 버튼이 눌렸을때
				if (male) {
					male = false;
					btnNewButton.setBackground(new Color(255, 255, 255));
				}
				female = true;
				btnNewButton_1.setBackground(new Color(210, 210, 210));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

	}
}
