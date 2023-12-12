package GUI;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import JDBC.UserDAO;
import JDBC.UserDTO;

public class My_Page_Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private My_Page myPage;
	private ProfilePanel profile;
	private Report_Details_1 reportHistory;
	private RentHistory rentHistory;
	private My_Writing myWrite;
	private JPanel rentAlarm;
	private Rent_Notification rentnotifi;

	public static UserDTO userInfo_cur;

	public My_Page_Panel(boolean Administrator) {

		setLayout(null);
		setBounds(0, 150, 1050, 700);
		setBackground(new Color(255, 255, 255));

		UserDAO userDAO;
		userDAO = new UserDAO();
		userInfo_cur = userDAO.userSelect(userDAO.user_cur);

		myPage = new My_Page(this, Administrator);
		this.add(myPage);

		rentHistory = new RentHistory(this);
		myWrite = new My_Writing(this);
		reportHistory = new Report_Details_1(this);
		profile = new ProfilePanel(this);
		rentnotifi = new Rent_Notification(this);

		this.add(rentHistory);
		this.add(myWrite);
		this.add(reportHistory);
		this.add(profile);
		this.add(rentnotifi);

		rentHistory.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
		myWrite.setVisible(false);

		myPage.setVisible(true);
	}

	void Open_My_Page() {
		myPage.setVisible(true);
		myPage.table.refresh(2);
		rentHistory.setVisible(false);
		myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
		rentnotifi.setVisible(false);
	}

	void Open_rentHistory() {
		myPage.setVisible(false);
		rentHistory.refresh();
		rentHistory.setVisible(true);
		myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
		rentnotifi.setVisible(false);
	}

	void Open_reportHistory() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		myWrite.setVisible(false);
		reportHistory.refresh();
		reportHistory.setVisible(true);
		profile.setVisible(false);
		rentnotifi.setVisible(false);
	}

	void Open_profile() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(true);

	}

	void Open_myWrite() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);

		My_Writing tmp = (My_Writing) myWrite;
		tmp.refresh();
		rentnotifi.setVisible(false);
		myWrite.setVisible(true);
		reportHistory.setVisible(false);
		profile.setVisible(false);
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

	void Open_rentnotifi() {
		myPage.setVisible(false);
		rentHistory.setVisible(false);
		myWrite.setVisible(false);
		reportHistory.setVisible(false);
		profile.setVisible(false);
		rentnotifi.setVisible(true);
	}
}