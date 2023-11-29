package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class RoundButton extends JButton {
	/**
	 * 버튼 모서리 둥글게 만드는 클래스
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color colorNormal = Color.white;
	private Color colorClicked = Color.LIGHT_GRAY;
	private Color bordercolor;

	public RoundButton(String label) {
		super(label);	
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
		
	public RoundButton(String label,Color BorderColor) { // 라운드버튼 테두리 색깔도 받아 적용시키는 생성자
		super(label);
		bordercolor = BorderColor;
		setContentAreaFilled(false);
		setFocusPainted(false);
	}
	
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(colorClicked); // 버튼이 눌렸을 때의 버튼 색
		} else {
			g.setColor(colorNormal); // 기본 버튼 색
		}
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 라운드 버튼 테두리 계단현상 줄이기
	    g2.setStroke(new BasicStroke(2)); // 라운드 버튼 테두리 굵기 증가
		g2.setColor(bordercolor);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

	public void setColorNormal(Color color) {
		colorNormal = color;
	}

	public void setColorClicked(Color color) {
		colorClicked = color;
	}
}

