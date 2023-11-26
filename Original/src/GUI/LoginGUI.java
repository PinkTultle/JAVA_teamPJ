package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import GUI.C_Component.MyJT;
import GUI.C_Component.MyPT;
import JDBC.UserDAO;
import JDBC.UserDTO;

//주석 및 추가 작업 필요
public class LoginGUI extends JFrame implements ActionListener {
	UserDTO userDTO;
	UserDAO userDAO;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT txtId;
	private BorderFactory bf;
	private MyPT txtPassword;
	private JTextField removefirstfocus;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JFrame mainFrame;

	private boolean isTyped_l = false;
	private boolean isTyped_p = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ML_btn listener_btn = new ML_btn();

		JPanel panel = new JPanel();
		panel.setBounds(292, 97, 470, 450);
		panel.setBackground(new Color(0, 191, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 25, true));
		panel_1.setBounds(12, 10, 450, 380);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBounds(10, 10, 430, 360);
		panel_1.add(panel_1_1);
		panel_1_1.setLayout(null);

		btnNewButton = new JButton("로그인");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(80, 213, 270, 50);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton.addMouseListener(listener_btn);
		btnNewButton.addActionListener(this);
		panel_1_1.add(btnNewButton);

		btnNewButton_1 = new JButton("회원가입");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		Font font = btnNewButton_1.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		btnNewButton_1.setFont(font.deriveFont(attributes));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addMouseListener(listener_btn);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(166, 295, 98, 22);
		panel_1_1.add(btnNewButton_1);

		txtId = new MyJT("Id");
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		txtId.setBounds(30, 49, 370, 50);
		panel_1_1.add(txtId);
		txtId.setColumns(10);

		txtPassword = new MyPT("Password");
		txtPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		txtPassword.setColumns(10);
		txtPassword.setBounds(30, 109, 370, 50);
		txtPassword.setEchoChar((char) 0);
		panel_1_1.add(txtPassword);

		removefirstfocus = new JTextField();
		removefirstfocus.setBounds(-200, 10, 116, 21);
		panel_1_1.add(removefirstfocus);
		removefirstfocus.setColumns(10);

		btnNewButton_2 = new JButton("아이디/비밀번호 찾기");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btnNewButton_2.setBounds(256, 165, 162, 23);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addMouseListener(listener_btn);
		btnNewButton_2.addActionListener(this);
		panel_1_1.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("렌트 프로그램");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 34));
		lblNewLabel.setBounds(375, 21, 298, 66);
		contentPane.add(lblNewLabel);
	}

	class ML_btn implements MouseListener {

		@Override
		public void mouseEntered(MouseEvent e) {
			Cursor cursor = new Cursor(HAND_CURSOR);
			setCursor(cursor);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Cursor cursor = new Cursor(DEFAULT_CURSOR);
			setCursor(cursor);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) { // 로그인 버튼 동작
			System.out.println(((JButton) (e.getSource())).getText());
			userDTO = new UserDTO();
			userDAO = new UserDAO();

			String id = txtId.getText();
			String pw = new String(txtPassword.getPassword());

			userDTO.setId(id);
			userDTO.setPw(pw);

			// 로그인 없이 바로 홈 진입
			// 프로젝트 완료시점에서 해당 코드 삭제
			try {
				mainFrame = new Main_frame();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setVisible(false);
			////////////////////////////////////////////

			try {
				int n = userDAO.checkLogin(userDTO);

				if (n == 0) {
					// 로그인 성공
					System.out.println("로그인 성공");
					userDTO.setLoginid(id); // 로그인한 아이디 저장
					// 페이지 전환 소스 넣어야함

					setVisible(false);
					mainFrame = new Main_frame();

				} else if (n == 1) {
					// 비밀번호 불일치
					System.out.println("로그인 실패(비밀번호 불일치)");
				} else if (n == -1) {
					// 아이디 없음
					System.out.println("로그인 실패(아이디 없음)");
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			} // 로그인 확인

		} else if (e.getSource() == btnNewButton_1) { // 회원가입 버튼 동작
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == btnNewButton_2) { // 아이디/비밀번호 찾기 동작
			System.out.println(((JButton) (e.getSource())).getText());
		}
	}
	// txtId : 아이디 입력 JTextField
	// txtPassword : 패스워드 입력 JPasswordField
}
