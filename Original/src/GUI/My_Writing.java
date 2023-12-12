package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.C_Component.itemSlot_myWriting;

public class My_Writing extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	protected My_Page_Panel mpp;

	private Baener_pane BP = new Baener_pane();
	private RoundButton btn_back;
	private itemSlot_myWriting is;
	private bt_next btn_next, btn_prev;
	private JLabel tableHeader[] = new JLabel[6];

	public My_Writing(My_Page_Panel mpp) {
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1050, 750);
		setBorder(new LineBorder(Color.black));

		this.mpp = mpp;

		JLabel lblNewLabel = new JLabel("나의 글");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 38, 202, 64);
		add(lblNewLabel);

		btn_back = new RoundButton("뒤로");
		btn_back.setBounds(863, 633, 124, 33);
		btn_back.setForeground(new Color(255, 255, 255));
		btn_back.setColorNormal(new Color(31, 78, 121));
		btn_back.addActionListener(this);
		add(btn_back);

		int[] xLoc = { 67, 180, 415, 652, 770, 880 };
		String[] headerText = { "물품코드", "카테고리", "물품명", "등록자", "렌트 기한", "처리 상태" };
		Font hFont = new Font("맑은 고딕", Font.PLAIN, 16);

		for (int i = 0; i < 6; i++) {
			tableHeader[i] = new JLabel(headerText[i]);
			tableHeader[i].setBounds(xLoc[i], 134, 86, 40);
			tableHeader[i].setHorizontalAlignment(SwingConstants.CENTER);
			tableHeader[i].setFont(hFont);
			add(tableHeader[i]);
		}

		is = new itemSlot_myWriting(57, 170, 920, 410, 10);
		is.setPage();
		add(is);

		btn_prev = new bt_next(435, 605, 50, 50, false);
		btn_prev.addActionListener(this);
		add(btn_prev);

		btn_next = new bt_next(555, 605, 50, 50, true);
		btn_next.addActionListener(this);
		add(btn_next);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_back) {
			mpp.Open_My_Page();
		} else if (e.getSource() == btn_next) {
			is.nextPage();
		} else if (e.getSource() == btn_prev) {
			is.prevPage();
		}
	}

	public void refresh() {
		is.setPage();
		this.repaint();
	}
}
