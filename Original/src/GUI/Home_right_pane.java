package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Home_right_pane extends JPanel implements ActionListener{
	
	private JButton Category;
	private String [] Cate = {"전자", "전기", "가정", "가정", "가정", "가정", "가정", "가정", "가정", "가정", "가정", "기타"};
	
	public Home_right_pane() {
		
		
		setBounds(530, 150, 510, 615);
		setBackground(Color.lightGray);
		setLayout(new GridLayout(4, 4, 5, 5));
		setBorder(BorderFactory.createEmptyBorder(50,0,50,0));
		
		for(int i = 0; i < 12; i++) {
			Category = new JButton(Cate[i]);
			Category.addActionListener(this);
			add(Category);
		}		
			
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//메인 프레임의 카테고리 메소드 동작 
		Main_frame.Category(e.getActionCommand());
		
	}


}
