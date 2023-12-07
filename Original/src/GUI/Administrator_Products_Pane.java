package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Administrator_Products_Pane extends Administrator_pane  {
	
	private JButton revise, delete;
	
	
	public Administrator_Products_Pane(JFrame master) {
		super(master);


		revise = new JButton("수정");
		revise.setBounds(close_bt.getX(), scrollPane.getY(),
					close_bt.getWidth(), close_bt.getHeight());
		revise.setBackground(null);
		add(revise);

		delete = new JButton("삭제");
		delete.setBounds(close_bt.getX(), revise.getY()+revise.getHeight()+20,
				close_bt.getWidth(), close_bt.getHeight());
		delete.setBackground(null);
		add(delete);
		
		
		
		setBackground(Color.white);
		
	}
		
}
