package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class LoginGUI  extends JFrame implements ActionListener {
	
	UserDTO userDTO ;
	UserDAO userDAO ;

	private JPasswordField passwordField;
	private JTextArea textArea_ID;
	private JPanel panel;
	private JButton btn_Login;
	private JButton btn_Register;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		setTitle("로그인");
		setBounds(100, 100, 322, 112);
		
		userDAO = new UserDAO();

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(12, 10, 340, 170);
		getContentPane().add(panel);
		panel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(79, 45, 110, 24);
		panel.add(passwordField);

		textArea_ID = new JTextArea();
		textArea_ID.setBounds(79, 7, 110, 24);
		panel.add(textArea_ID);

		btn_Login = new JButton("로그인");
		btn_Login.setBounds(201, 43, 97, 23);
		btn_Login.addActionListener(this);
		panel.add(btn_Login);

		btn_Register = new JButton("회원가입");
		btn_Register.setBounds(201, 10, 97, 23);
		btn_Register.addActionListener(this);
		panel.add(btn_Register);
		
		JLabel lblNewlabel = new JLabel("아이디");
		lblNewlabel.setBounds(12, 4, 84, 31);
		panel.add(lblNewlabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(10, 49, 57, 15);
		panel.add(lblNewLabel_1);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_Login) {
			
			String id = textArea_ID.getText();
			String pw = new String(passwordField.getPassword());
			
			userDTO = new UserDTO();
			
			userDTO.setId(id);
			userDTO.setPw(pw);
			
			try {
				int n = userDAO.checkLogin(userDTO);
				
				if(n==0) {
					//로그인 성공
					System.out.println("로그인 성공");
				}else if(n==1) {
					//비밀번호 불일치
					System.out.println("비밀번호 재확인");
				}else if(n==-1) {
					//아이디 없음
					System.out.println("아이디 없음");
				}
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // 로그인 확인
			
			
		}
		if (e.getSource() == btn_Register) {
			// 회원가입 버튼 눌렀을때
			RegisterGUI frame = new RegisterGUI();
			frame.setVisible(true);
		}
	}
	
	
	
}

// 해당 소스는 swing frame 을 완전히 종료할 수 없습니다.
// 따라서 수동으로 디버깅을 종료 해주시길 바랍니다.
