package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import JDBC.ItemDAO;

public class checkOffer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundButton btnNewButton, btnNewButton_1;
	private int offerNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkOffer frame = new checkOffer();
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
	public checkOffer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setTitle("대여승인");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("물품번호");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 25, 61, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 25, 290, 40);
		lblNewLabel_1.setBorder(new LineBorder(Color.black));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("대여기간");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 84, 57, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1_1.setBorder(new LineBorder(Color.black));
		lblNewLabel_1_1.setBounds(100, 75, 130, 40);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_1_2.setBorder(new LineBorder(Color.black));
		lblNewLabel_1_2.setBounds(260, 75, 130, 40);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_3 = new JLabel("~");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(229, 75, 32, 40);
		contentPane.add(lblNewLabel_3);

		btnNewButton = new RoundButton("승인");
		btnNewButton.setBounds(70, 140, 135, 30);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setColorNormal(new Color(31, 78, 121));
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new RoundButton("거부", Color.black);
		btnNewButton_1.setBounds(245, 140, 135, 30);
		btnNewButton_1.addActionListener(this);
		contentPane.add(btnNewButton_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ItemDAO itemDAO = new ItemDAO();
		if (e.getSource() == btnNewButton) {
			int result = itemDAO.checkOffer(offerNum, 0);
			if (result == 1) {
				JOptionPane.showConfirmDialog(null, "오류발생");
			} else
				JOptionPane.showConfirmDialog(null, "대여 승인하였습니다.");
		} else if (e.getSource() == btnNewButton_1) {
			int result = itemDAO.checkOffer(offerNum, 0);
			if (result == 1) {
				JOptionPane.showConfirmDialog(null, "오류발생");
			} else
				JOptionPane.showConfirmDialog(null, "승인 거부하였습니다.");
		}

	}
}
