package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Reservation_Status {

	private JFrame frame;
	private JTextField textField_품명코드;
	private JTextField textField_렌트기한2;
	private JTextField textField_렌트기한1;
	private JTextField textField_예상금액;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation_Status window = new Reservation_Status();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservation_Status() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 388, 224);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("품명 코드");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel.setBounds(24, 25, 66, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("렌트 기한");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(24, 62, 66, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("예상 금액");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(24, 98, 66, 15);
		panel.add(lblNewLabel_1_1);
		
		textField_품명코드 = new JTextField();
		textField_품명코드.setEnabled(false);
		textField_품명코드.setBounds(107, 24, 207, 21);
		panel.add(textField_품명코드);
		textField_품명코드.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("~");
		lblNewLabel_2.setBounds(191, 61, 9, 15);
		panel.add(lblNewLabel_2);
		
		textField_렌트기한2 = new JTextField();
		textField_렌트기한2.setColumns(10);
		textField_렌트기한2.setBounds(201, 61, 82, 21);
		panel.add(textField_렌트기한2);
		
		textField_렌트기한1 = new JTextField();
		textField_렌트기한1.setColumns(10);
		textField_렌트기한1.setBounds(107, 61, 82, 21);
		panel.add(textField_렌트기한1);
		
		textField_예상금액 = new JTextField();
		textField_예상금액.setEnabled(false);
		textField_예상금액.setColumns(10);
		textField_예상금액.setBounds(107, 97, 207, 21);
		panel.add(textField_예상금액);
		
		JLabel lblNewLabel_3 = new JLabel("예상금액 계산 : 일수 x 대여료 + 보증금");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(107, 120, 217, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("예약현황 :");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(135, 3, 59, 15);
		panel.add(lblNewLabel_4);
		
		JButton btnNewButton = new RoundButton("예약");
		btnNewButton.setBounds(59, 151, 103, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new RoundButton("취소");
		btnNewButton_1.setBounds(211, 151, 103, 23);
		panel.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("협의");
		chckbxNewCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(308, 61, 59, 23);
		panel.add(chckbxNewCheckBox);
	}
}
