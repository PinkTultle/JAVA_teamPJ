package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Home_right_pane extends Function_pane implements ActionListener {

	private JButton Category;
	private String[] Cate = { "전자기기", "가구/인테리어", "유아용품", "뷰티", "패션잡화", "가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타",
			"요청" + "" };
	
	private ImageIcon [] main_btn_img = {
			new ImageIcon("./src/images/main_btn_1.png"),
			new ImageIcon("./src/images/main_btn_2.png"),
			new ImageIcon("./src/images/main_btn_3.png"),
			new ImageIcon("./src/images/main_btn_4.png"),
			new ImageIcon("./src/images/main_btn_5.png"),
			new ImageIcon("./src/images/main_btn_6.png"),
			new ImageIcon("./src/images/main_btn_7.png"),
			new ImageIcon("./src/images/main_btn_8.png"),
			new ImageIcon("./src/images/main_btn_9.png"),
			new ImageIcon("./src/images/main_btn_10.png"),
			new ImageIcon("./src/images/main_btn_11.png"),
			new ImageIcon("./src/images/main_btn_12.png")			
	};
	private Font font = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 16);
	
	public Home_right_pane() {

		
		
		//setBounds(530, 150, 510, 715);

		setLayout(new GridLayout(4, 3, 5, 5));
		setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 20));

		for (int i = 0; i < 12; i++) {
			Category = new Cate_butten(Cate[i], main_btn_img[i] );
			Category.addActionListener(this);
			add(Category);
		}

		
		

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// 메인 프레임의 카테고리 메소드 동작
		Main_frame.Category(e.getActionCommand());

	}

	class Cate_butten extends JButton {

		public Cate_butten(String text, ImageIcon icon) {
			
			setFont(font);
			setSize(90,90);
			setBorderPainted(false);
			setOpaque(false);
			setIcon(icon);
			setText(text);
			setBackground(null);
			setFocusable(false);
			setBorder(null);
			setHorizontalTextPosition(SwingConstants.CENTER);
			setVerticalTextPosition(SwingConstants.BOTTOM);

		}

		
	}
}
