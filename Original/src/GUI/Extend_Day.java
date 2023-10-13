package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class Extend_Day {

	private JFrame frame;
	private JTextField textField_거래번호;
	private JTextField textField_반납날짜;
	private JTextField textField_연장기간;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Extend_Day window = new Extend_Day();
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
	public Extend_Day() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("거래번호");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 31, 63, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("반납날짜");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 62, 63, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("연장기간");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(26, 93, 63, 15);
		panel.add(lblNewLabel_1_1);
		
		textField_거래번호 = new JTextField();
		textField_거래번호.setBounds(118, 28, 221, 21);
		panel.add(textField_거래번호);
		textField_거래번호.setColumns(10);
		
		textField_반납날짜 = new JTextField();
		textField_반납날짜.setColumns(10);
		textField_반납날짜.setBounds(118, 60, 221, 21);
		panel.add(textField_반납날짜);
		
		textField_연장기간 = new JTextField();
		textField_연장기간.setColumns(10);
		textField_연장기간.setBounds(118, 91, 221, 21);
		panel.add(textField_연장기간);
		
		JButton Requ_Btn = new RoundButton("New button");
		Requ_Btn.setText("요청");
		Requ_Btn.setBounds(77, 139, 91, 23);
		panel.add(Requ_Btn);
		
		JButton Cancel_Btn = new RoundButton("New button");
		Cancel_Btn.setText("취소");
		Cancel_Btn.setBounds(208, 139, 91, 23);
		panel.add(Cancel_Btn);
		
		
		////// 연장 완료 알림창
		final JDialog requ_dialog = new JDialog(frame, true);
		requ_dialog.setSize(180, 100);
		requ_dialog.setLocationRelativeTo(frame);
		JLabel label = new JLabel("기간이 연장되었습니다.");
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		requ_dialog.add(label);
		
		// 연장 요청 버튼 - 연장 완료 알림
		Requ_Btn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 requ_dialog.setVisible(true);
	         }
	     });
		
		// 취소 버튼 - 창 끄기
		Cancel_Btn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	         }
	     });
	}
}
