package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.itemSlot_offer;

public class OfferManage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();

	private JLabel lblNewLabel_2[] = new JLabel[6];
	private String initString[] = { "물품코드", "물품명", "요청기한" };
	private Font headerFont = new Font("맑은 고딕", Font.PLAIN, 20);
	private int initBounds[] = { 9, 160, 330, 97, 89, 47 };
	private static itemSlot_offer is_receive, is_sending;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public OfferManage() {

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);

		RoundJLabel lblNewLabel = new RoundJLabel("받은 신청");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLineColor(new Color(244, 82, 95));
		lblNewLabel.setBounds(8, 10, 500, 70);
		add(lblNewLabel);

		RoundJLabel lblNewLabel_1 = new RoundJLabel("보낸 신청");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setLineColor(new Color(0, 140, 200));
		lblNewLabel_1.setBounds(526, 10, 500, 70);
		add(lblNewLabel_1);

		try {
			is_receive = new itemSlot_offer(28, 140, 461, 600, true);
			is_receive.setItem("receive");
			add(is_receive);

			is_sending = new itemSlot_offer(545, 140, 461, 600, false);
			is_sending.setItem("sending");
			add(is_sending);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 6; i++) {
			lblNewLabel_2[i] = new JLabel(initString[i % 3]);
			lblNewLabel_2[i].setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_2[i].setFont(headerFont);
			lblNewLabel_2[i].setBounds(((i > 2) ? 545 : 28) + initBounds[i % 3], initBounds[3], initBounds[4],
					initBounds[5]);
			add(lblNewLabel_2[i]);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(517, 20, 517, 680);
	}

	public static void refresh() {
		try {
			is_receive.setItem("receive");
			is_sending.setItem("sending");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
