package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class New_registered_items extends JScrollPane {
	
	private int print_num = 6;
	private JButton jb; 
	
	public New_registered_items() {
		
		setLayout(null);		
		/*		
		for(int i=0; i < print_num; i++) {
			jb = new JButton(Integer.toString(i+1));
			jb.setSize(430, 360/print_num);
			jb.setLocation( getX(), getY()+ jb.getHeight()*i);
			
			jb.setBackground(Color.white);
			add(jb);			
		}*/
		
		String []head = {"카테고리", "제목", "등록일"};
		String [][]content = {
				{"ㅇㅁ","ㅇㅁ","ㅇㅇ"},
				{"ㅇㅈ","ㅇㅈ","ㅈㅈ"}
		};
		
		
		JTable JT = new JTable(content, head);
		JT.setSize(430, 360);
		JT.setLocation(getX(), getY());
		JT.setBackground(getForeground());
		add(JT);
		
		
		
		
	}

	public void Update_button() {
		
	}
	

}
