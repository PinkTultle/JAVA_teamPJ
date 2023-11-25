package GUI;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class My_Page_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private My_Page myPage;
	private ProfilePanel profile;
	private JPanel rentHistory, rentAlarm, myWrite, reportHistory;

	public My_Page_Panel() throws SQLException {
		setLayout(null);
		setBounds(0, 150, 1050, 700);
		setBackground(new Color(255, 255, 255));

		myPage = new My_Page(this);
		this.add(myPage);

		rentHistory = new RentHistory(this);
		// rentAlarm = new
		// myWrite = new
		reportHistory = new Report_Details(this);
		profile = new ProfilePanel(this);

		this.add(rentHistory);
		this.add(reportHistory);
		this.add(profile);

		rentHistory.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);

		myPage.setVisible(true);
	}

	void Open_My_Page() {
		myPage.setVisible(true);
		rentHistory.setVisible(false);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
	}

	void Open_rentHistory() {
		myPage.setVisible(false);
		rentHistory.setVisible(true);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
	}

	void Open_reportHistory() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(true);
		profile.setVisible(false);
	}

	void Open_profile() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		// rentAlarm.setVisible(false);
		// myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(true);
	}

	public boolean Close_profile() {
		if (profile.getMode()) { // 수정 상태인 경우
			int closeProfile = JOptionPane.showConfirmDialog(null, "정보 수정 중입니다. 나가시겠습니까?", "경고",
					JOptionPane.YES_NO_OPTION);
			if (closeProfile == JOptionPane.NO_OPTION)
				return false;
			profile.changeMode(false);
		}
		return true;
	}
}