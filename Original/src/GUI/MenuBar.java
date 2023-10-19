package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuBar extends JPanel implements ActionListener{
	
	private JButton MenuButton;
	private String [] tagList = {"홈", "목록", "신청관리", "마이페이지"};
	private int length = 520, Bnum = (length - 10) / 4;
	
	
	public MenuBar() {
				
		setBounds(530, 120, length, 30);
		setBackground(Color.white);
		
		//버튼 왼쪽부터 정렬 및 버튼 사이 여백 없에기
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		//버튼 1부터 4까지 설정
		for(int i = 0 ; i < 4; i++) {
			MenuButton = new JButton(tagList[i]);
			MenuButton.setPreferredSize(new Dimension(Bnum, 30));
			MenuButton.setBackground(Color.WHITE);
			MenuButton.setHorizontalAlignment(SwingConstants.CENTER);
			MenuButton.setVerticalAlignment(SwingConstants.CENTER);
			add(MenuButton);
		}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}		
}
