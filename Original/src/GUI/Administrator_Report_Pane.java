package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Administrator_Report_Pane extends Administrator_pane  {
	
	private JButton approve;
	
	
	public Administrator_Report_Pane(JFrame master) {
		super(master);

		setBackground(Color.white);
		
		approve = new JButton("완료");
		approve.setBounds(close_bt.getX(), scrollPane.getY(),
				close_bt.getWidth(), close_bt.getHeight());
		
		approve.setBackground(Color.white);
		add(approve);
		
		
	
	}

}
