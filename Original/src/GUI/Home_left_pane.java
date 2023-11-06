package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;

public class Home_left_pane extends Function_pane implements ActionListener{

	private JLabel L1, L2;
	private JTextField Tf;
	private static JButton Jb1 = null;
	private Font font;
	private JPanel BP = new Baener_pane();
	
	
	
	public Home_left_pane() {
		// TODO Auto-generated constructor stub
		
		setSize(530, 800);
		setLayout(null);
		font = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 24);
		
		
		
		//검색, 최근 방문 키워드 표시
		L1 = new JLabel("검색");
		L1.setBounds(70, BP.getHeight()+30, 50, 50);
		L1.setFont(font);
		L1.setForeground(Color.black);
		add(L1);
		
		L2 = new JLabel("최근방문");
		L2.setBounds(70, BP.getHeight()+150, 150, 50);
		L2.setFont(font);
		L2.setForeground(Color.black);
		add(L2);
		
		
		//검색어 입력 텍스트 필드 설정
		Tf = new JTextField(10);
		
		Tf.setText("검색어를 입력하세요");
		font = new Font("맑은 고딕", Font.PLAIN, 18);
		//Tf.setBorder(new LineBorder(Color.black, 0));
		Tf.setFont(font);
		Tf.setEnabled(true);
		Tf.setBounds( 50, BP.getHeight()+85, 350, 40);
		add(Tf);
		
		//검색 버튼 생성
		Jb1 = new search_bt();
		Jb1.addActionListener(this);

		add(Jb1);
		
		//최근 방문 글 목록 생성할 곳
		//아무래도 패널 따로 빼서 클래스 만드는게 좋을듯
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "검색") {
			//검색 버튼 클릭상황
			
			Main_frame.main("메인 검색");
			
		}
		
	}
	
	class search_bt extends JButton{
		
		public search_bt() {
			
			setBounds(410, BP.getHeight()+85, 80, 40);
			setOpaque(false);
			setFocusPainted(false);
			setBorderPainted(false);
			//setContentAreaFilled(false);
			
			setBackground(back_c);

			ImageIcon Bt_img = new ImageIcon(search_bt.class.getResource("../COMP_IMG/search.png"));
			
			Image img = Bt_img.getImage();
			
			img.getScaledInstance( getHeight(), getWidth(), Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(img);
			
			setIcon(icon);
			
			
			setRolloverIcon(icon);
			
		}	
	
}


class Main_Search_act implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//검색 버튼 클릭
	}
}
}