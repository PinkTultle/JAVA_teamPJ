package GUI;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterGUI extends JFrame implements ActionListener {

	private JPasswordField passwordField;
	private JButton btn_Register;
	private JTextField textField_ID;
	private JTextField textField_Name;
	private JTextField textField_TEL;
	private JTextField textField_Address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI window = new RegisterGUI();
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

	// textarea 를 textfield 로 교체 해봐야함
	public RegisterGUI() {
		setTitle("회원가입");
		getContentPane().setLayout(null);
		setBounds(100, 100, 240, 240);

		passwordField = new JPasswordField();
		passwordField.setBounds(110, 41, 110, 24);
		getContentPane().add(passwordField);

		btn_Register = new JButton("회원가입");
		btn_Register.setBounds(123, 176, 97, 23);
		btn_Register.addActionListener(this);
		getContentPane().add(btn_Register);

		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setBounds(12, 15, 57, 15);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(12, 45, 57, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setBounds(12, 77, 57, 15);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("전화번호");
		lblNewLabel_3.setBounds(12, 108, 57, 15);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("주소지");
		lblNewLabel_4.setBounds(12, 139, 57, 15);
		getContentPane().add(lblNewLabel_4);

		textField_ID = new JTextField();
		textField_ID.setBounds(110, 10, 110, 21);
		getContentPane().add(textField_ID);
		textField_ID.setColumns(10);

		textField_Name = new JTextField();
		textField_Name.setBounds(110, 72, 110, 21);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);

		textField_TEL = new JTextField();
		textField_TEL.setBounds(110, 105, 110, 21);
		getContentPane().add(textField_TEL);
		textField_TEL.setColumns(10);

		textField_Address = new JTextField();
		textField_Address.setBounds(110, 136, 110, 21);
		getContentPane().add(textField_Address);
		textField_Address.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_Register) {
			// 회원가입 버튼 눌렸을때
			// 각 항목의 작성 여부를 확인하는 메소드 필요
			boolean isEmpty = !textField_Address.getText().trim().isEmpty() && !textField_ID.getText().trim().isEmpty()
					&& !textField_Name.getText().trim().isEmpty() && !textField_TEL.getText().trim().isEmpty()
					&& passwordField.getPassword().length != 0;
			if (isEmpty) {
				User TEMP = new User(textField_ID.getText(), passwordField.getPassword().toString(),
						textField_Name.getText(), textField_TEL.getText(), textField_Address.getText());
				dispose();
			} else {
				showMessageDialog(null, "모든 항목을 채우지 않았습니다.");
			}

		}
	}
}

//해당 소스는 swing frame 을 완전히 종료할 수 없습니다.
//따라서 수동으로 디버깅을 종료 해주시길 바랍니다.