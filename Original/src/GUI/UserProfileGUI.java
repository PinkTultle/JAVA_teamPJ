package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class UserProfileGUI extends JFrame implements ActionListener {

	private final int AddressLineMaximum = 37;
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private SwingCRLF sc = new SwingCRLF();

	// 코드 구동을 위한 User 객체 | DB와 연결시에는 필요없음
	private static User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfileGUI frame = new UserProfileGUI(user);
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
	public UserProfileGUI(User user) { // 매개변수로 DB의 ID를 받고 메소드를 이용해 User 데이터를 받아야함
		UserProfileGUI.user = user; // 테스트용 코드

		setTitle("유저 정보");
		setBounds(100, 100, 347, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(12, 10, 309, 260);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(user.Name);
		lblNewLabel.setToolTipText(user.Name);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(12, 27, 159, 44);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(user.ID);
		lblNewLabel_1.setToolTipText(user.ID);
		lblNewLabel_1.setBounds(34, 80, 137, 15);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(209, 25, 70, 70);
		panel.add(panel_1);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setToolTipText("신용 등급");
		lblNewLabel_2.setForeground(new Color(0, 128, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 55));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("신용 등급");
		lblNewLabel_3.setBounds(216, 10, 63, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("ID: ");
		lblNewLabel_4.setBounds(12, 80, 50, 15);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("전화번호: ");
		lblNewLabel_5.setBounds(12, 116, 63, 15);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(user.TEL);
		lblNewLabel_6.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(78, 108, 201, 30);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("주소: ");
		lblNewLabel_7.setBounds(12, 149, 50, 15);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(sc.CRLF(user.Address, AddressLineMaximum));
		lblNewLabel_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(52, 147, 245, 57);
		panel.add(lblNewLabel_8);

		JButton btnNewButton = new JButton("정보 수정");
		btnNewButton.setBounds(188, 215, 91, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserProfileEditGUI frame = new UserProfileEditGUI(user);
		frame.setVisible(true);
		dispose();
	}
}

// User 클래스 불러오는 메소드 구현 필요