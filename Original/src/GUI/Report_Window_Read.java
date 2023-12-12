package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import JDBC.ReportDAO;
import JDBC.ReportDTO;

public class Report_Window_Read extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	RoundButton btn_back;

	/**
	 * Create the frame.
	 */
	public Report_Window_Read(String reportNum) {
		getContentPane().setBackground(new Color(250, 250, 250));
		setBounds(100, 100, 360, 400);
		setTitle("신고");
		getContentPane().setLayout(null);

		ReportDAO reportDAO = new ReportDAO();
		ReportDTO data = reportDAO.reportNumData(Integer.parseInt(reportNum));

		JLabel lblNewLabel = new JLabel("물품코드");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(27, 22, 61, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("신고분류");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(27, 58, 61, 15);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("사유");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(27, 91, 50, 15);
		getContentPane().add(lblNewLabel_1_1);

		JComboBox comboBox = new JComboBox(new String[] { "허위물품", "연락두절", "과한금액/보증금", "파손된 물품", "기타" });
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setSelectedItem(data.getCategory());
		comboBox.setBounds(113, 57, 162, 23);
		comboBox.disable();
		getContentPane().add(comboBox);

		JTextField itemNum = new JTextField();
		itemNum.setText(Integer.toString(data.getItemNumber()));
		itemNum.disable();
		itemNum.setBounds(113, 22, 162, 21);
		getContentPane().add(itemNum);

		// limit : 36
		RoundJLabel reportDetail = new RoundJLabel();
		reportDetail.setHorizontalAlignment(SwingConstants.LEFT);
		reportDetail.setVerticalAlignment(SwingConstants.TOP);
		reportDetail.setText(SwingCRLF.CRLF(data.getReportDetail(), 36));
		reportDetail.setBounds(27, 113, 300, 80);
		reportDetail.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		getContentPane().add(reportDetail);

		btn_back = new RoundButton("뒤로");
		btn_back.setBounds(130, 328, 100, 23);
		btn_back.setForeground(new Color(255, 255, 255));
		btn_back.setColorNormal(new Color(31, 78, 121));
		btn_back.addActionListener(this);
		getContentPane().add(btn_back);

		RoundJTextArea reportDetail_1 = new RoundJTextArea();
		reportDetail_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		reportDetail_1.setBounds(27, 238, 300, 80);
		reportDetail_1.setEditable(false);
		reportDetail_1.setLineWrap(true);
		getContentPane().add(reportDetail_1);

		if (data.getAnswer() != null) {
			reportDetail_1.setText(data.getAnswer());
		}

		JLabel lblNewLabel_2 = new JLabel("답변");
		lblNewLabel_2.setBounds(27, 213, 57, 15);
		getContentPane().add(lblNewLabel_2);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_back) {
			dispose();
		}
	}
}
