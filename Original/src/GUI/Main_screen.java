package GUI;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Main_screen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mainframe MF = new Mainframe();
		

	}

}


class Mainframe extends JFrame{
	
	//private JPanel Operating_Area = null;
	
	public Mainframe() {
		
		setSize(1050, 600);
		setLocationRelativeTo(null);
		setTitle("메인 프레임");
		
		Banner Mb = new Banner("홈 화면");
		
		//기본 패널 삽입
		//홈 패널 불러와서 삽입
		
		add(Mb);
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setVisible(true);


	}
	
}



class Banner extends JPanel{
	
	private JLabel Title = null;
	
	public Banner(String S) {
		
		setSize(new Dimension(500,200));
		setBackground(Color.GRAY);
		
		Title = new JLabel();
		
		
		Font f = new Font("Gothic", Font.ITALIC, 60);
		Title.setLocation(5, 5);
		Title.setFont(f);
		
		
		
		change_Title(S);
		
		add(Title);
	
	}
	
	void change_Title(String S) {
		Title.setText(S);
	}
	
	
}

