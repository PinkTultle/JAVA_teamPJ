package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Baener_pane extends JPanel {
	
	private JLabel LOGO;
	private JPanel MenuBar;
	private Font LFont;
	private JButton logout;	
	
	public Baener_pane() {
		// TODO Auto-generated constructor stub
		
		//배너 사이즈 및 위치설정
		setBounds(0, 0, 1050, 150);
		//자유 레이아웃 설정
		setLayout(null);
		//배너 설정
		setToolTipText("배너 패널");
		
		//배너 배경색(진한 파랑)
		//setBackground(new Color(0,191,255));
		
		//로고 초기설정
		LOGO = new JLabel("렌트");
		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 34);
		LOGO.setFont(LFont);
		LOGO.setBounds(40, 0, 150, 150);
		add(LOGO);
		
		logout = new JButton("로그아웃");
		
		logout.setLocation(940, 0);
		logout.setSize(100, 50);
		logout.setBackground(new Color(59, 56, 56));
		logout.setHorizontalAlignment(SwingConstants.CENTER);
		logout.setVerticalAlignment(SwingConstants.CENTER);
		logout.setBorderPainted(false);
		logout.setFocusPainted(false);
		logout.addActionListener(new logo_eve());
		//MenuButton.setContentAreaFilled(false);
		logout.setFont(new Font("맑은고딕", Font.BOLD, 15));
		logout.setForeground(Color.white);
		add(logout);
		
		MenuBar = new MenuBar();
		
		add(MenuBar);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		
		GradientPaint gp = new GradientPaint(0, 0, new Color(0xc2e9fb), 1050, 150, new Color(0,191,255));
		
		g2.setPaint(gp);
		g2.fillRect(0, 0, 1050, 150);
	}
	class logo_eve implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		
			new LoginGUI();
			
		}		
	}
}
