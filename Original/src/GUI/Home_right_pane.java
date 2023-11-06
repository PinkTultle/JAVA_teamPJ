package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Home_right_pane extends Function_pane implements ActionListener{
	
	private JButton Category;
	private String [] Cate = {"전자기기", "가구/인테리어", "유아용품", "뷰티", "패션잡화", "가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타", "요청"
			+ ""};
	
	public Home_right_pane() {
		
		
		setBounds(530, 150, 510, 715);
		
		setLayout(new GridLayout(4, 4, 5, 5));
		setBorder(BorderFactory.createEmptyBorder(50,0,50,0));
		
		for(int i = 0; i < 12; i++) {
			Category = new Cate_butten(Cate[i]);
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

	
	
	class Cate_butten extends JButton{
	
		public Cate_butten(String text) {
			
			setBorderPainted(false);
			setOpaque(false);
			setText(text);
			setHorizontalTextPosition(SwingConstants.CENTER);
			setVerticalTextPosition(SwingConstants.BOTTOM);
			
		}
		
		
		protected void paintComponent(Graphics g) {
			int width = getWidth();
		    int height = getHeight();

		    Graphics2D graphics = (Graphics2D) g;

		    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		    if (getModel().isArmed()) {
		        graphics.setColor(getBackground().darker());
		    } else if (getModel().isRollover()) {
		        graphics.setColor(getBackground().brighter());
		    } else {
		        graphics.setColor(getBackground());
		    }

		    graphics.fillRoundRect( 0, 0, width, height, 100, 100);

		    FontMetrics fontMetrics = graphics.getFontMetrics();
		    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		    int textX = (width - stringBounds.width) / 2;
		    int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent() + 40;

		    graphics.setColor(getForeground());
		    graphics.setFont(getFont());
		    graphics.drawString(getText(), textX, textY);
		    graphics.dispose();

		    super.paintComponent(g);
		}
	}
}
