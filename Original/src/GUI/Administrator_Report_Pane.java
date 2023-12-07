package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GUI.C_Component.reportDetailTable;

public class Administrator_Report_Pane extends Administrator_pane  {
	
	private JButton approve;
	
	
	public Administrator_Report_Pane(JFrame master) {
		super(master);

		setBackground(Color.white);
		
		approve = new JButton("선택");
		approve.setBounds(close_bt.getX(), scrollPane.getY(),
				close_bt.getWidth(), close_bt.getHeight());
		approve.setBackground(null);

		table = new reportDetailTable(0, 0, scrollPane.getWidth(), scrollPane.getHeight());
		table.getViewport().setBackground(new Color(243, 246, 249));
		table.setItem_allreport();
		
		add(approve);
		
		JLabel[] columnLbl = new JLabel[4];
		String[] columnName = { "신고 순번", "물품 코드", "물품명", "처리 상태" };
		Font slotFont = new Font("굴림", Font.PLAIN, 12);

		for (int i = 0; i < 4; i++) {
			columnLbl[i] = new JLabel(columnName[i]);
			columnLbl[i].setBounds(scrollPane.getWidth()/4*(i)+30, 0, 70, 50);
			columnLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			columnLbl[i].setFont(slotFont);
			add(columnLbl[i]);
		}
		scrollPane.add(table);

	
	}

}
