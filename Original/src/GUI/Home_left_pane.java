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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home_left_pane extends Function_pane {

	private JLabel L1, L2;
	private JTextField Tf;
	private search_bt Jb1 = null;
	private Font font;
	private JPanel BP = new Baener_pane();
	
	public Home_left_pane() {
		// TODO Auto-generated constructor stub
		
		new eventLisen();
		
		setSize(530, 800);
		setLayout(null);
		font = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 24);
		
		
		//검색, 최근 방문 키워드 표시
		L1 = new JLabel("검색");
		L1.setBounds(50, BP.getHeight()+30, 50, 50);
		L1.setFont(font);
		L1.setForeground(Color.black);
		add(L1);
		
		L2 = new JLabel("최근방문");
		L2.setBounds(L1.getX(), L1.getY()+170, 150, 50);
		L2.setFont(font);
		L2.setForeground(Color.black);
		add(L2);
		
		
		//검색어 입력 텍스트 필드 설정
		Tf = new JTextField();
		
		Tf.setText("검색어를 입력하세요");
		font = new Font("맑은 고딕", Font.PLAIN, 18);
		//Tf.setBorder(new LineBorder(Color.black, 0));		
		
		Tf.setFont(font);
		Tf.setEnabled(true);
		Tf.setBounds( 50, BP.getHeight()+100, 350, 40);
		
		Tf.addFocusListener(new eventLisen());
		add(Tf);
		
		//검색 버튼 생성
		Jb1 = new search_bt();
		Jb1.addActionListener(new eventLisen());

		add(Jb1);
		
		//최근 방문 글 목록 생성할 곳
		//아무래도 패널 따로 빼서 클래스 만드는게 좋을듯

	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.black);
		g.drawLine(this.L1.getX(), this.L1.getY()+50, this.L1.getX()+420, this.L1.getY()+50);
		//g.drawLine(150, 1, this.L1.getWidth()+100, this.L1.getHeight()+100);
		
	}
	
	class eventLisen implements ActionListener, FocusListener{


		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField j = (JTextField)e.getSource();
			if(j.getText().equals("검색어를 입력하세요")) {
				j.setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource().equals(Jb1)) {
				//검색 기능					
				Tf.setText("검색어를 입력하세요");
			}
			
			
			
			
			
			
		}
		
		
		
	}

}

