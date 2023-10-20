package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class MenuBar extends JPanel implements ActionListener{
	
	private static final Frame MenuBar = null;
	public JButton MenuButton;
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
			MenuButton.setBackground(Color.gray);
			MenuButton.setHorizontalAlignment(SwingConstants.CENTER);
			MenuButton.setVerticalAlignment(SwingConstants.CENTER);
			add(MenuButton);
			MenuButton.setBorderPainted(false);
			MenuButton.setFocusPainted(false);
			//MenuButton.setContentAreaFilled(false);
			MenuButton.addActionListener(this);
			MenuButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
			MenuButton.setForeground(Color.white);
		}
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton b = (JButton)e.getSource();
		JDialog jd = new JDialog( MenuBar, true);
		
		switch(b.getText()) {
		case "홈" :{
			jd.setTitle(b.getText());
			jd.show();
			break;
			}
		case "목록" :{
			jd.setTitle(b.getText());
			jd.show();
			break;
			}
		case "신청관리" :{
			jd.setTitle(b.getText());
			jd.show();
			break;
			}
		case "마이페이지" :{
			jd.setTitle(b.getText());
			jd.show();
			}
		}
	}
}
