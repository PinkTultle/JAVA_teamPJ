package GUI;

import java.awt.Color;

import javax.swing.JPanel;

public class My_Page_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static My_Page myPage;
	private static JPanel rentHistory, rentAlarm, myWrite, reportHistory;

	public My_Page_Panel() {
		setBounds(0, 150, 1050, 800);

		setLayout(null);

		setBackground(new Color(255, 255, 255));

		myPage = new My_Page(this);
		this.add(myPage);

		rentHistory = new RentHistory(this);
		// rentAlarm = new
		// myWrite = new
		reportHistory = new Report_Details(this);

		this.add(rentHistory);
		this.add(reportHistory);

		reportHistory.setVisible(false);

		myPage.setVisible(true);
	}

	void Open_My_Page() {
		myPage.setVisible(true);
		rentHistory.setVisible(false);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(false);
	}

	void Open_rentHistory() {
		myPage.setVisible(false);
		rentHistory.setVisible(true);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(false);
	}

	void Open_reportHistory() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(true);
	}

}