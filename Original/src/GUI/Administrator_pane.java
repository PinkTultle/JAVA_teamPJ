package GUI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Administrator_pane extends JPanel {
	
	protected JButton close_bt;
	protected Font font = new Font("굴림", Font.BOLD + Font.PLAIN, 12);
	protected JTable Table;
	protected JScrollPane scrollPane;
	protected Object [] colNames;
	protected Object [][] data;
	protected DefaultTableModel model;

	
	public Administrator_pane(JFrame master) {
		
		setBounds(0, 79, 597, 421);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);	
		
		close_bt = new JButton("닫기");
		close_bt.setFont(font);
		close_bt.setBounds(getWidth()-100, getHeight()-80, 70, 30);
		close_bt.setBackground(null);
		close_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master.dispose();
			}
		});
		add(close_bt);		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		add(scrollPane);
	}

}
