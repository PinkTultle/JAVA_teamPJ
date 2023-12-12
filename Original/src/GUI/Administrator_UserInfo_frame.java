package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import JDBC.UserDAO;
import JDBC.UserDTO;

public class Administrator_UserInfo_frame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator_UserInfo_frame frame = new Administrator_UserInfo_frame("asd1");
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
	public Administrator_UserInfo_frame(String ID) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		UserDAO userDAO = new UserDAO();
		UserDTO data = userDAO.userSelect(ID);

		setTitle(ID);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 30, 90, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("이름:");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 60, 90, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("별명:");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 90, 90, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("생년월일:");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 150, 90, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("성별:");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(28, 120, 90, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("전화번호:");
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(28, 180, 90, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("주소:");
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(28, 240, 90, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("이메일:");
		lblNewLabel_7.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(28, 210, 90, 20);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("관리자 여부:");
		lblNewLabel_8.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(28, 270, 90, 20);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("ID 입력");
		lblNewLabel_9.setText(data.getId());
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9.setBounds(110, 30, 214, 20);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("이름 입력");
		lblNewLabel_9_1.setText(data.getName());
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_1.setBounds(110, 60, 214, 20);
		contentPane.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("별명 입력");
		lblNewLabel_9_2.setText(data.getNickname());
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_2.setBounds(110, 90, 214, 20);
		contentPane.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("성별 입력");
		lblNewLabel_9_3.setText(data.getGender());
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_3.setBounds(110, 120, 214, 20);
		contentPane.add(lblNewLabel_9_3);

		JLabel lblNewLabel_9_4 = new JLabel("생년월일 입력");
		String tmp = Integer.toString(data.getBirth());
		lblNewLabel_9_4.setText(tmp.substring(0, 4) + "-" + tmp.substring(4, 6) + "-" + tmp.substring(6, 8));
		lblNewLabel_9_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_4.setBounds(110, 150, 214, 20);
		contentPane.add(lblNewLabel_9_4);

		JLabel lblNewLabel_9_5 = new JLabel("전화번호 입력");
		tmp = "0" + Integer.toString(data.getTel());
		lblNewLabel_9_5.setText(tmp.substring(0, 3) + "-" + tmp.substring(3, 7) + "-" + tmp.substring(7, 11));
		lblNewLabel_9_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_5.setBounds(110, 180, 214, 20);
		contentPane.add(lblNewLabel_9_5);

		JLabel lblNewLabel_9_6 = new JLabel("이메일 입력");
		lblNewLabel_9_6.setText(data.getEmail());
		lblNewLabel_9_6.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_6.setBounds(110, 210, 214, 20);
		contentPane.add(lblNewLabel_9_6);

		JLabel lblNewLabel_9_7 = new JLabel("주소 입력");
		lblNewLabel_9_7.setText(data.getAddress());
		lblNewLabel_9_7.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_7.setBounds(110, 240, 214, 20);
		contentPane.add(lblNewLabel_9_7);

		JLabel lblNewLabel_9_8 = new JLabel("관리자 여부 입력");
		if (data.getAdministrator() == 1) {
			lblNewLabel_9_8.setText("Y");
		} else {
			lblNewLabel_9_8.setText("N");
		}
		lblNewLabel_9_8.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_9_8.setBounds(110, 270, 214, 20);
		contentPane.add(lblNewLabel_9_8);

		JButton btnNewButton = new JButton("닫기");
		btnNewButton.setBounds(120, 304, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton);

		setVisible(true);
	}
}
