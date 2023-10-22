package GUI;

import java.awt.Color;
import java.awt.Graphics;
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

	public RoundButton(String label) {
		super(label);
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
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
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