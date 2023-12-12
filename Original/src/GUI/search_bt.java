package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class search_bt extends JButton {

	JPanel BP = new Baener_pane();

	public search_bt() {

		setBounds(400, BP.getHeight() + 100, 80, 40);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);

		setBackground(new Color(255, 255, 250));

		ImageIcon Bt_img = new ImageIcon(search_bt.class.getResource("../COMP_IMG/search.png"));

		Image img = Bt_img.getImage();

		img.getScaledInstance(getHeight(), getWidth(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);

		setIcon(icon);

		setRolloverIcon(icon);

	}
}