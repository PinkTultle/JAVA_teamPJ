package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import JDBC.ItemDAO;

public class extendOffer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private dateChooser dc;
	private RoundButton btn1, btn2;
	private JLabel[] itemHeader = new JLabel[3];
	private JLabel[] item = new JLabel[4];

	private LocalDate date;
	private int rentNum = 0;

	// 호출시 itemDTO 전달 필요
	public extendOffer(int rentNum) {
		setBounds(100, 100, 480, 290);
		setTitle("거래 연장");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		this.rentNum = rentNum;

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font nFont = new Font("굴림", Font.PLAIN, 16);
		String[] s_h = { "거래번호", "반납날짜", "연장기간" };
		int[] bound_h = { 30, 20, 96, 40 };

		for (int i = 0; i < 3; i++) {
			itemHeader[i] = new JLabel(s_h[i]);
			itemHeader[i].setFont(nFont);
			itemHeader[i].setHorizontalAlignment(SwingConstants.CENTER);
			itemHeader[i].setBounds(bound_h[0], bound_h[1], bound_h[2], bound_h[3]);
			bound_h[1] += 50;
			contentPane.add(itemHeader[i]);
		}

		String[] s_i = { "", "", "", "반납날짜" };
		int[][] bound_i = { { 135, 20, 282, 40 }, { 135, 70, 282, 40 }, { 135, 120, 100, 40 }, { 273, 120, 100, 40 } };

		for (int i = 0; i < 4; i++) {
			item[i] = new JLabel(s_i[i]);
			item[i].setFont(nFont);
			item[i].setHorizontalAlignment(SwingConstants.CENTER);
			item[i].setBorder(new LineBorder(Color.black));
			item[i].setBounds(bound_i[i][0], bound_i[i][1], bound_i[i][2], bound_i[i][3]);
			contentPane.add(item[i]);
		}

		JLabel lblNewLabel_4 = new JLabel("~");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(235, 120, 38, 40);
		contentPane.add(lblNewLabel_4);

		btn1 = new RoundButton("요청");
		btn1.setBounds(95, 195, 120, 30);
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setColorNormal(new Color(31, 78, 121));
		btn1.addActionListener(this);
		contentPane.add(btn1);

		btn2 = new RoundButton("취소", Color.black);
		btn2.setBounds(250, 195, 120, 30);
		btn2.addActionListener(this);
		contentPane.add(btn2);

		dc = new dateChooser(380, 120, 40, 40);
		dc.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if ("date".equals(e.getPropertyName())) {
					java.util.Date d = dc.getDate();
					if (d != null) {
						date = LocalDate.ofInstant(d.toInstant(), ZoneId.systemDefault());
						item[3].setText(date.toString());
						dc.setDate(null);
					}
				}
			}
		});
		contentPane.add(dc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			ItemDAO itemDAO = new ItemDAO();
			// ItemDTO data=itemDAO.serchRent(rentNum);

		} else if (e.getSource() == btn2) {
			dispose();
		}
	}

}
