package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Baener_pane extends JPanel {
	
	private JLabel LOGO;
	private JPanel MenuBar;
	private Font LFont;
	private Color BColor;
	
	public Baener_pane() {
		// TODO Auto-generated constructor stub
		
		//배너 사이즈 및 위치설정
		setBounds(0, 0, 1050, 150);
		
		//자유 레이아웃 설정
		setLayout(null);
		//배너 설정
		//색깔 설정 푸른색 + 투명도 비활성화
		BColor = new Color(0x31BAF5, false);
		setBackground(BColor);
		setToolTipText("배너 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("렌트");
		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 34);
		LOGO.setFont(LFont);
		LOGO.setBounds(40, 0, 150, 150);
		add(LOGO);
		
		MenuBar = new MenuBar();
		
		add(MenuBar);
	}
}
