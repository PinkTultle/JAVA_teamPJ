package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.Vector;

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
	private int initBounds[] = { 9, 185, 355, 97, 89, 47 };

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public OfferManage() {

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);

	/*public OfferManage() throws SQLException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);

		ManagePanel panel = new ManagePanel();
		panel.setBounds(0, 0, 1034, 700);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);*/

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

		itemSlot_offer is_receive = new itemSlot_offer(28, 140, 461, 600);

		is_receive.setHeaderColor(new Color(244, 82, 95));
		add(is_receive);


		// 테스트용 코드
		Vector<String[]> vector = new Vector<String[]>();
		for (int i = 0; i < 15; i++) {
			vector.add(new String[] { "asdf", "asdf", "asdf" });
		}
		is_receive.setItem(vector);
		// 테스트용 코드

		itemSlot_offer is_sending = new itemSlot_offer(545, 140, 461, 600);
		add(is_sending);

		for (int i = 0; i < 6; i++) {
			lblNewLabel_2[i] = new JLabel(initString[i % 3]);
			lblNewLabel_2[i].setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_2[i].setFont(headerFont);
			lblNewLabel_2[i].setBounds(((i > 2) ? 545 : 28) + initBounds[i % 3], initBounds[3], initBounds[4],
					initBounds[5]);
			add(lblNewLabel_2[i]);
		}

		// 테스트용 코드
		vector.clear();
		for (int i = 0; i < 15; i++) {
			vector.add(new String[] { "qwer", "qwer", "qwer" });
		}
		is_sending.setItem(vector);
		// 테스트용 코드
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(517, 20, 517, 680);
		/*is_receive.setItem("receive"); // 받은 신청 출력

		itemSlot_offer is_sending = new itemSlot_offer(545, 90, 461, 600, 1);
		panel.add(is_sending);

		is_sending.setItem("sending"); // 보낸 신청 출력
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	class ManagePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(517, 20, 517, 680);
		}*/
	}
}
