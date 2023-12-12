package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.Administrator_Products_Pane.Action;
import JDBC.UserDAO;

public class Administrator_Members_Pane extends Administrator_pane {

	private JButton revise, delete;
	private String colNames[] = { "아이디", "이름", "전화번호", "관리자여부" }; // 테이블 컬럼 값들
	UserDAO dao;

	public Administrator_Members_Pane(JFrame master, Administrator_pane a) throws ClassNotFoundException {
		super(master);

		Refresh_table();
		set_table();

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		add(scrollPane);

		//master.add(table);
		
		Action act =  new Action();

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
		/*
		 * table.getColumn("관리자여부").setPreferredWidth(20); /* for(String col : colNames)
		 * table.getColumn(col).set;
		 */
		dao = new UserDAO();
		dao.userAll(model);

		table.setModel(model);

		revalidate();
		repaint();

	}

	class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == delete) {
				dao.admin_user_delete(table.getValueAt(table.getSelectedRow(), 0).toString());

				// ((AbstractTableModel)
				// table.getModel()).fireTableCellUpdated(table.getSelectedRow(), 0);

				Refresh_table();

				table.repaint();
				revalidate();
				repaint();
			}
			if (e.getSource() == revise) {
				new Administrator_UserInfo_frame(table.getValueAt(table.getSelectedRow(), 0).toString());
			}

		}
	}

}
