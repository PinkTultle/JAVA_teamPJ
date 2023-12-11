package GUI;

import java.awt.Color;

import javax.swing.JPanel;

abstract public class Function_pane extends JPanel {
	
	protected Color back_c; 
	
	public Function_pane() {
		
		setBounds(0, 0, 1050, 900);

		back_c = new Color(255,255,250);
		setLayout(null);
		
		//배경색
		setBackground(back_c);
	}
	
	public void set_color(int r, int g, int b) {
		back_c = new Color(r, g, b);
		setBackground(back_c);
	}
}
