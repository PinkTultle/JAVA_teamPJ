package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import JDBC.ItemDAO;
import JDBC.ItemDTO;

public class sending_offer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel[] lbl = new JLabel[4];
	private dateChooser dateChooser;
	private RoundButton btn_sending;
	private RoundButton btn_cancel;

	private boolean d1_c = false;
	private LocalDate d1, d2;
	private int costPerDate, itemNum, deposit;
	private ItemDTO data;

	/**
	 * Create the frame.
	 */
	public sending_offer(ItemDTO data) {
		setBounds(100, 100, 550, 350);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("예약하기");

		this.data = data;
		this.itemNum = data.getItemnumber();
		this.costPerDate = data.getRentalfee();
		this.deposit = data.getDeposit();

		JLabel lblNewLabel = new JLabel("물품코드");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 34, 100, 45);
		getContentPane().add(lblNewLabel);

		String[] s = { Integer.toString(itemNum), "시작 날짜", "반납 날짜", "0" };
		int[][] bound = { { 158, 34, 326, 45 }, { 158, 94, 116, 45 }, { 309, 94, 116, 45 }, { 158, 157, 326, 45 } };

		for (int i = 0; i < 4; i++) {
			lbl[i] = new JLabel(s[i]);
			lbl[i].setBounds(bound[i][0], bound[i][1], bound[i][2], bound[i][3]);
			lbl[i].setFont(new Font("굴림", Font.PLAIN, (i == 1 || i == 2) ? 15 : 20));
			lbl[i].setBorder(new LineBorder(Color.black));
			lbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(lbl[i]);
		}

		JLabel lblNewLabel_1 = new JLabel("렌트 기한");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 94, 100, 45);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("예상 금액");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(48, 154, 100, 45);
		getContentPane().add(lblNewLabel_1_1);

		btn_sending = new RoundButton("예약");
		btn_sending.setBounds(130, 245, 120, 35);
		btn_sending.setColorNormal(new Color(31, 78, 121));
		btn_sending.setForeground(new Color(255, 255, 255));
		btn_sending.addActionListener(this);
		getContentPane().add(btn_sending);

		btn_cancel = new RoundButton("취소");
		btn_cancel.setBounds(300, 245, 120, 35);
		btn_cancel.addActionListener(this);
		getContentPane().add(btn_cancel);

		JLabel lblNewLabel_2 = new JLabel("~");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(274, 94, 35, 45);
		getContentPane().add(lblNewLabel_2);

		dateChooser = new dateChooser(437, 94, 45, 45);
		// 이 명령어 필요한지 확인 필요
		dateChooser.setBounds(437, 94, 45, 45);
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					java.util.Date d = dateChooser.getDate();
					if (d != null) {
						if (!d1_c) {
							d1_c = true;
							d1 = LocalDate.ofInstant(d.toInstant(), ZoneId.systemDefault());
							lbl[1].setText(d1.toString());
							dateChooser.setDate(null);
						} else {
							d1_c = false;
							d2 = LocalDate.ofInstant(d.toInstant(), ZoneId.systemDefault());
							lbl[2].setText(d2.toString());
							dateChooser.setDate(null);

						}
						if (d2 != null && (d2.isAfter(d1) || d2.equals(d1))) {
							CostCalc();
						} else {
							lbl[3].setText(Integer.toString(deposit));
						}
					}
				}
			}
		});
		getContentPane().add(dateChooser);
		;
	}

	int CostCalc() {
		Long dayBetween = (ChronoUnit.DAYS.between(d1, d2) + 1) * costPerDate + deposit;
		lbl[3].setText(dayBetween.toString());
		return 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_cancel) {
			dispose();
		} else if (e.getSource() == btn_sending) {
			String msg = "예약에 실패했습니다.";
			String rentDate = data.getRentdate();
			LocalDate tmp = LocalDate.of(Integer.parseInt(rentDate.substring(0, 4)),
					Integer.parseInt(rentDate.substring(5, 7)), Integer.parseInt(rentDate.substring(8, 10)));
			if (d1.isBefore(LocalDate.now()) || d2.isAfter(tmp))
				msg = "날짜를 확인해주세요.";
			else if (d1.isBefore(d2)) {
				ItemDAO itemDAO = new ItemDAO();
				ItemDTO d = itemDAO.itemdetail(itemNum);
				if (d.getState().equals("대여가능")) {
					if (itemDAO.sendingOffer(data, d1, d2) == 0) {
						msg = "예약 성공했습니다.";
					}
				} else {
					msg = "대여가능 상태가 아닙니다.";
				}
			}

			JOptionPane.showMessageDialog(null, msg);
			if (msg.equals("예약 성공했습니다."))
				dispose();
		}

	}
}
