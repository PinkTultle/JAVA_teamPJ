package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report_Window {

	private JFrame frame;
	private JTextField textField_거래번호;
	private JTextField textField_사유;
	
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report_Window window = new Report_Window();
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
	public Report_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("신고");
		frame.setBounds(100, 100, 364, 273);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("거래번호");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 22, 61, 21);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("신고분류");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 58, 61, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("사유");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(27, 91, 50, 15);
		panel.add(lblNewLabel_1_1);
		
		// 콤보박스 목록 추가해야함
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(113, 57, 162, 23);
		panel.add(comboBox);
		
		textField_거래번호 = new JTextField();
		textField_거래번호.setBounds(113, 22, 162, 21);
		panel.add(textField_거래번호);
		textField_거래번호.setColumns(10);
		
		textField_사유 = new RoundJTextField();
		textField_사유.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField_사유.setColumns(10);
		textField_사유.setBounds(27, 113, 300, 80);
		panel.add(textField_사유);
		
		JButton Report_Btn = new RoundButton("신고");
		Report_Btn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Report_Btn.setBounds(72, 203, 91, 23);
		panel.add(Report_Btn);
		
		JButton Cancel_Btn = new RoundButton("취소");
		Cancel_Btn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Cancel_Btn.setBounds(194, 203, 91, 23);
		panel.add(Cancel_Btn);
		
		////// 신고 완료 알림창
		 final JDialog dialog = new JDialog(frame, "신고 결과", true);
	     dialog.setSize(100, 100);
	     dialog.setLocationRelativeTo(frame);
	     JLabel label = new JLabel("신고 완료");
	     label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
	     label.setHorizontalAlignment(JLabel.CENTER);
	     label.setVerticalAlignment(JLabel.CENTER);
	     dialog.add(label);

	     Report_Btn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             dialog.setVisible(true);
	         }
	     });

	     Cancel_Btn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	         }
	     });
	     //////
	}
}

