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
		setBounds(100, 100, 364, 273);
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
		btn_back.setBounds(132, 201, 100, 23);
		btn_back.setForeground(new Color(255, 255, 255));
		btn_back.setColorNormal(new Color(31, 78, 121));
		btn_back.addActionListener(this);
		getContentPane().add(btn_back);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn_back) {
			dispose();
		}
	}

}
