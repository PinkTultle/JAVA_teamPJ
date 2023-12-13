package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.myPageTable;
import JDBC.ItemDAO;
import JDBC.ItemDTO;

public class Rent_Notification extends JPanel implements ActionListener { // 렌트 알림 창
	private static final long serialVersionUID = 1L;

	Vector<String> columnNames;
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();

	private myPageTable table;
	private RoundButton Bt_Back;
	protected My_Page_Panel mpp;
	JLabel[] columnLbl = new JLabel[4];
	int[] xLoc = { 170, 465, 755 };
	int item_count = 0;

	public Rent_Notification() {

		ItemDAO dao = new ItemDAO();

		Vector<ItemDTO> v = new Vector<ItemDTO>();
		try {
			v = dao.itemRental();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < v.size(); i++) {
			item_count += 1;
		}

		setBackground(new Color(255, 255, 255));
		setBounds(0, 150, 1050, 800);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("렌트 알림");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(30, 29, 162, 78);
		add(lblNewLabel);

		String[] columnName = { "거래번호", "물품명", "반납 기한" };

		for (int i = 0; i < columnName.length; i++) {
			columnLbl[i] = new JLabel(columnName[i]);
			columnLbl[i].setBounds(xLoc[i], 110, 110, 50);
			columnLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			columnLbl[i].setFont(new Font("굴림", Font.PLAIN, 20));
			add(columnLbl[i]);
		}

		table = new myPageTable(81, 160, 878, 436, item_count);
		table.setItem(item_count);
		add(table);

		Bt_Back = new RoundButton("뒤로");
		Bt_Back.setBounds(890, 635, 110, 30);
		Bt_Back.setForeground(Color.WHITE);
		Bt_Back.setColorNormal(new Color(31, 78, 121));
		Bt_Back.addActionListener(this);
		add(Bt_Back);
	}

	public Rent_Notification(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출
		// 선의 색상을 검정색으로 설정
		g.setColor(Color.BLACK);
		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(table.getX(), table.getY() - 1, table.getX() + table.getWidth(), table.getY() - 1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_Back) {
			Main_frame.Changepane("마이페이지");
		}
	}
}
