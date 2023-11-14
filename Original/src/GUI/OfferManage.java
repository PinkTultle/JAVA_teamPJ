package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GUI.C_Component.itemSlot_offer;

public class OfferManage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfferManage frame = new OfferManage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public OfferManage() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		ManagePanel panel = new ManagePanel();
		panel.setBounds(0, 0, 1034, 531);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
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

		itemSlot_offer is_receive = new itemSlot_offer(28, 90, 461, 431, 0);
		is_receive.setHeaderColor(new Color(244, 82, 95));
		panel.add(is_receive);

		is_receive.setItem("receive"); // 받은 신청 출력

		itemSlot_offer is_sending = new itemSlot_offer(545, 90, 461, 431, 1);
		panel.add(is_sending);

		is_sending.setItem("sending"); // 보낸 신청 출력
	}

	class ManagePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(517, 20, 517, 510);
		}
	}
}
