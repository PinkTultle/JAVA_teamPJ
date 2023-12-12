package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main_home extends Function_pane {

	private JPanel BP = new Baener_pane();
	private JPanel Home_1, Home_2;

	public Main_home() {

		// 마우스 올리면 출력되는 문구 이후 삭제
		// setSize(1050, 900);
		setToolTipText("홈 패널");

		Home_1 = new Home_left_pane();
		add(Home_1);

		Home_2 = new Home_right_pane();
		Home_2.setBounds(Home_1.getWidth(), 250, 525, 700);
		add(Home_2);

		category_up up = new category_up();
		add(up);

	}

	class category_up extends JPanel {

		private JLabel L1;
		private Font font = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 24);;

		public category_up() {
			setBounds(Home_1.getWidth(), 0, 525, 250);
			setLayout(null);

			L1 = new JLabel("카테고리 선택");

			L1.setBounds(30, BP.getHeight() + 30, 250, 50);
			L1.setFont(font);
			L1.setForeground(Color.black);
			add(L1);

			setBackground(back_c);

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.black);
			g.drawLine(L1.getX(), L1.getY() + 50, L1.getX() + 450, L1.getY() + 50);
		}

	}

}
