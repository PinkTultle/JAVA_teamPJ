package GUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

class bt_next extends JButton {
	public bt_next(int x, int y, int width, int height, boolean mode) {
		// true: 다음 | false: 이전

		setBounds(x, y, width, height);
		setBackground(Color.white);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);

		String path = "../COMP_IMG/button_prev.png";
		if (mode)
			path = "../COMP_IMG/button_next.png";
		ImageIcon bt_img = new ImageIcon(bt_next.class.getResource(path));

		Image image = bt_img.getImage();
		image = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
		bt_img.setImage(image);

		setIcon(bt_img);
		setRolloverIcon(bt_img);
	}
}

/*class search_bt extends JButton{
	
	JPanel BP = new Baener_pane();
	
	public search_bt() {
		

		setBounds(400, BP.getHeight()+100, 80, 40);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		//setContentAreaFilled(false);
		
		setBackground(new Color(255,255,250));

		ImageIcon Bt_img = new ImageIcon(search_bt.class.getResource("../COMP_IMG/search.png"));
		
		Image img = Bt_img.getImage();
		
		img.getScaledInstance( getHeight(), getWidth(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(img);
		
		setIcon(icon);
		
		
		setRolloverIcon(icon);
		
	}	
}*/