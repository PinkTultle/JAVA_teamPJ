package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;

public class RoundJLabel extends JLabel {
	/*
	 * 텍스트필드 모서리 둥글게 만드는 클래스
	 */
	private static final long serialVersionUID = 1L;
	private Shape shape;
	private Color backgroundColor = Color.white;
	private Color lineColor = getForeground();
	private float lineThickness = 1f;

	public RoundJLabel() {
		setOpaque(false);
	}

	public RoundJLabel(String s) {
		super(s);
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setStroke(new java.awt.BasicStroke(lineThickness));
		g2.setColor(lineColor);
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

	public void setBackgroundColor(Color color) {
		backgroundColor = color;
	}

	public void setLineColor(Color color) {
		lineColor = color;
	}

	public void setThickness(float n) {
		lineThickness = n;
	}
}
