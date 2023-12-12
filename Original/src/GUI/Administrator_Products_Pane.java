package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import JDBC.ItemDAO;

public class Administrator_Products_Pane extends Administrator_pane {

	private JButton revise, delete;
	private String colNames[] = { "물품코드", "카테고리", "물품명", "소유주", "대여상태" }; // 테이블 컬럼 값들

	private ItemDAO dao;

	public Administrator_Products_Pane(JFrame master) {
		super(master);

		Refresh_table();
		set_table();

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		add(scrollPane);

		Action act = new Action();

		revise = new JButton("조회");
		revise.setBounds(close_bt.getX(), scrollPane.getY(), close_bt.getWidth(), close_bt.getHeight());
		revise.setBackground(null);
		revise.addActionListener(act);
		add(revise);

		delete = new JButton("삭제");
		delete.setBounds(close_bt.getX(), revise.getY() + revise.getHeight() + 20, close_bt.getWidth(),
				close_bt.getHeight());
		delete.setBackground(null);
		delete.addActionListener(act);
		add(delete);

		setBackground(Color.white);

	}

	private void Refresh_table() {

		model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				if (column >= 0) {
					return false;
				} else {
					return true;
				}
			}
		};

		if (table == null)
			table = new JTable(model);

		table.getColumn("물품코드").setPreferredWidth(30);
		table.getColumn("대여상태").setPreferredWidth(40);
		table.getColumn("소유주").setPreferredWidth(50);

		dao = new ItemDAO();
		try {
			dao.itemAll(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		table.setModel(model);
	}

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == delete) {
				dao.deleteItem(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
				Refresh_table();
				table.repaint();
				revalidate();
				repaint();
			}
			if (e.getSource() == revise) {
				new Administrator_ItemInfo_frame(
						Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
			}

		}
	}

}
