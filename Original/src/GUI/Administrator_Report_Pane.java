package GUI;

import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import GUI.C_Component.reportDetailTable;
import JDBC.ReportDAO;
import JDBC.ReportDTO;

public class Administrator_Report_Pane extends Administrator_pane  {
	
	private JButton approve;
	private ReportDAO dao;
	private String[] head = {"신고번호", "물품코드", "물품명", "신고분류", "처리상태"};
	private Vector<String> header = new Vector<String>(Arrays.asList("신고번호", "물품코드", "물품명", "신고분류", "처리상태"));
	
	
	public Administrator_Report_Pane(JFrame master) {
		super(master);

		setBackground(Color.white);
		
		dao = new ReportDAO();
		
		Refresh_table();

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		add(scrollPane);
		
		approve = new JButton("선택");
		approve.setBounds(close_bt.getX(), scrollPane.getY(),
				close_bt.getWidth(), close_bt.getHeight());
		approve.setBackground(null);
		
		add(approve);
		
	}
	
	
	private void Refresh_table() {
		
		Vector<ReportDTO> list = dao.allReportData();
		Vector<ReportDTO> ptr = new Vector<ReportDTO>();
		
		
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		
		
		
		for (ReportDTO item : list) {
			Object [] data = new Object[] { Integer.toString(item.getReportNum()),
					Integer.toString(item.getItemNumber()), item.getItemName(),
					item.getCategory(), item.getStatus()};
			model.addRow(data);
		}		
		
		
	}
	

}
