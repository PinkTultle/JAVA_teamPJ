package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

public class dateChooser extends JDateChooser {

	public dateChooser(int x, int y, int width, int height) {
		ImageIcon ic = new ImageIcon(sending_offer.class.getResource("/COMP_IMG/calender.png"));
		Image image = ic.getImage();
		image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ic.setImage(image);
		setIcon(ic);
		getCalendarButton().setBackground(Color.white);
		getCalendarButton().setBorder(null);
		getCalendarButton().setOpaque(true);
		getCalendarButton().setFocusPainted(false);
		getCalendarButton().setBorderPainted(false);
		setBounds(x, y, width, height);
	}

}
