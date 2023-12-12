package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.reportDetailTable;

public class Report_Details_1 extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel BP = new Baener_pane();
	private RoundButton bt_back;
	private reportDetailTable table;
	protected My_Page_Panel mpp;

	public Report_Details_1() {
		setLayout(null);
		setBackground(Color.white);
		setBounds(0, BP.getHeight(), 1050, 700);

		JLabel lblNewLabel = new JLabel("신고 접수/내역");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 23));
		lblNewLabel.setBounds(30, 42, 185, 46);
		add(lblNewLabel);

		table = new reportDetailTable(30, 150, 975, 480);
		table.setItem();
		add(table);

		bt_back = new RoundButton("뒤로가기");
		bt_back.setForeground(new Color(255, 255, 255));
		bt_back.setColorNormal(new Color(31, 78, 121));
		bt_back.setBounds(890, 660, 110, 30);
		bt_back.addActionListener(this);
		add(bt_back);

		JLabel[] columnLbl = new JLabel[4];
		String[] columnName = { "신고 순번", "물품 코드", "물품명", "처리 상태" };
		Font slotFont = new Font("굴림", Font.PLAIN, 20);
		int[] xLoc = { 58, 222, 544, 862 };

		for (int i = 0; i < 4; i++) {
			columnLbl[i] = new JLabel(columnName[i]);
			columnLbl[i].setBounds(xLoc[i], 110, 110, 50);
			columnLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			columnLbl[i].setFont(slotFont);
			add(columnLbl[i]);
		}
	}

	public Report_Details_1(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	public void refresh() {
		table.setItem();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_back) {
			mpp.Open_My_Page();
		}
	}
}
