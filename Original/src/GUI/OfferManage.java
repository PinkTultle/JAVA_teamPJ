package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.itemSlot_offer;

public class OfferManage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();

	/**
	 * Create the frame.
	 */
	public OfferManage() {

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);

		ManagePanel panel = new ManagePanel();
		panel.setBounds(0, 0, 1034, 700);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);

		RoundJLabel lblNewLabel = new RoundJLabel("받은 신청");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(8, 10, 500, 70);
		panel.add(lblNewLabel);

		RoundJLabel lblNewLabel_1 = new RoundJLabel("보낸 신청");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(526, 10, 500, 70);
		panel.add(lblNewLabel_1);

		itemSlot_offer is_receive = new itemSlot_offer(28, 90, 461, 600, 0);
		is_receive.setHeaderColor(new Color(244, 82, 95));
		panel.add(is_receive);

		// 테스트용 코드
		Vector<String[]> vector = new Vector<String[]>();
		for (int i = 0; i < 15; i++) {
			vector.add(new String[] { "asdf", "asdf", "asdf" });
		}
		is_receive.setItem(vector);
		// 테스트용 코드

		itemSlot_offer is_sending = new itemSlot_offer(545, 90, 461, 600, 1);
		panel.add(is_sending);

		// 테스트용 코드
		vector.clear();
		for (int i = 0; i < 15; i++) {
			vector.add(new String[] { "qwer", "qwer", "qwer" });
		}
		is_sending.setItem(vector);
		// 테스트용 코드
	}

	class ManagePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(517, 20, 517, 680);
		}
	}
}
