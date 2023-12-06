package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import JDBC.ReportDAO;

public class Report_Window_Write {

	private JFrame frame;
	private JTextField textField_거래번호;

	/**
	 * Create the application.
	 */
	public Report_Window_Write(String itemNum, String itemName) {
		initialize(itemNum, itemName);
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String itemNum, String itemName) {
		frame = new JFrame();
		frame.setTitle("신고");
		frame.setBounds(100, 100, 364, 273);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("물품코드");
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
		JComboBox comboBox = new JComboBox(new String[] { "허위물품", "연락두절", "과한금액/보증금", "파손된 물품", "기타" });
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(113, 57, 162, 23);
		panel.add(comboBox);

		textField_거래번호 = new JTextField();
		textField_거래번호.setBounds(113, 22, 162, 21);
		textField_거래번호.setText(itemNum);
		textField_거래번호.disable();
		panel.add(textField_거래번호);
		textField_거래번호.setColumns(10);

		JButton Report_Btn = new RoundButton("신고");
		Report_Btn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Report_Btn.setBounds(72, 203, 91, 23);
		panel.add(Report_Btn);

		JButton Cancel_Btn = new RoundButton("취소");
		Cancel_Btn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Cancel_Btn.setBounds(194, 203, 91, 23);
		panel.add(Cancel_Btn);

		RoundJTextArea textArea = new RoundJTextArea();
		textArea.setBounds(27, 113, 300, 80);
		textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		panel.add(textArea);

		Report_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> vector = new Vector<String>();
				vector.add(itemNum);
				vector.add(itemName);
				vector.add(comboBox.getSelectedItem().toString());
				vector.add(textArea.getText());
				ReportDAO reportDAO = new ReportDAO();
				if (reportDAO.insertReport(vector)) {
					JOptionPane.showMessageDialog(null, "신고 완료");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "신고 실패");
				}
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
