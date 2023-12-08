package GUI;

import java.awt.Color;

import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

public class dateChooser extends JDateChooser {

	public dateChooser(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		setIcon(new ImageIcon(sending_offer.class.getResource("/COMP_IMG/calender.png")));
		getCalendarButton().setBackground(Color.white);
		getCalendarButton().setBorder(null);
		getCalendarButton().setOpaque(true);
		getCalendarButton().setFocusPainted(false);
		getCalendarButton().setBorderPainted(false);
		setBounds(x, y, width, height);
	}

}
