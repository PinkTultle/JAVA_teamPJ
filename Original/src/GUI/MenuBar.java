package GUI;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar extends JPanel {
	
	private JButton MenuButton;
	private String [] tagList = {"홈", "목록", "신청관리", "마이페이지"};
	private int Bnum = 4;
	
	public static void main(String[] args) {
		MenuBar M = new MenuBar();
	}
	
	public MenuBar() {
				
		setBounds(530, 120, 520, 30);
		setBackground(Color.white);
		
		
		setLayout(new FlowLayout());
		
		for(int i = 0 ; i < 4; i++) {
			MenuButton = new JButton(tagList[i]);
			MenuButton.setSize(530 / Bnum, 120);
			add(MenuButton);
		}
	}		
}
