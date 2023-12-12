package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import JDBC.MyHistoryDTO;

public class My_Writing_History extends JPanel implements ActionListener {
	private DefaultTableModel model;

	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();
	protected My_Page_Panel mpp;

	private RoundButton btn_back;

	private Vector<String> v2 = new Vector<String>(10);

	public My_Writing_History() {

		// 패널 크기 및 배경색
		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1050, 700);
		setLayout(null);

		// 나의 글 라벨
		JLabel lblNewLabel = new JLabel("나의 글");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(30, 42, 185, 46);
		add(lblNewLabel);

		// 뒤로가기 버튼
		btn_back = new RoundButton("뒤로가기");
		btn_back.setForeground(new Color(255, 255, 255));
		btn_back.setColorNormal(new Color(31, 78, 121));
		btn_back.setBounds(863, 610, 110, 30);
		btn_back.addActionListener(this);
		add(btn_back);

		select();
		int n1 = v2.size();
		int cnt = 0;
		n1 = n1 / 5;
		String changeData[][] = new String[n1][5];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < 5; j++) {
				changeData[i][j] = v2.get(cnt);
				cnt++;
			}
		}
		String colume[] = { "물품코드", "카테고리", "물품명", "반납기한", "처리상태" };
		JTable table = new JTable(changeData, colume);
		DefaultTableModel model = new DefaultTableModel(colume, 0);
		Font slotFont = new Font("맑은 고딕", Font.PLAIN, 20);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(68, 117, 904, 445);
		add(scrollPane);

	}

	public My_Writing_History(My_Page_Panel mpp) {

		this();
		this.mpp = mpp;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_back) {
			mpp.Open_My_Page();
		}
	}

	public void select() {
		MyHistoryDTO data = new MyHistoryDTO();
		v2 = data.select();
		System.out.println(v2.size());
	}

}
