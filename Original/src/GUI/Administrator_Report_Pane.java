package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
		set_table();
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		scrollPane.setBackground(null);
		add(scrollPane);
		
		approve = new JButton("선택");
		approve.setBounds(close_bt.getX(), scrollPane.getY(),
				close_bt.getWidth(), close_bt.getHeight());
		approve.setBackground(null);
		approve.addActionListener(new approve_bt());
		
		add(approve);
		
	}
	
	
	private void Refresh_table() {
		
		
		
		
		Vector<ReportDTO> list = dao.allReportData();		
		
		model = new DefaultTableModel(header, 0) {
			 public boolean isCellEditable(int row, int column) {
			    	if(column >= 0) {
			    		return false;
			    	}else {
			    		return true;
			    	}
			    }
		};
		
		table = new JTable(model);
		
		table.getColumn("신고번호").setPreferredWidth(30); 
		table.getColumn("물품코드").setPreferredWidth(30); 
		table.getColumn("물품명").setPreferredWidth(50);
		table.getColumn("처리상태").setPreferredWidth(50); 
		
		

		for (ReportDTO item : list) {
			Object [] data = new Object[] { Integer.toString(item.getReportNum()),
					Integer.toString(item.getItemNumber()), item.getItemName(),
					item.getCategory(), item.getStatus()};
			model.addRow(data);
		}		
	}
	
	class approve_bt implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int row = table.getSelectedRow();

			if(row != -1) {
				int report_num = Integer.parseInt((String)model.getValueAt(row, 0));
				ReportDTO report = 	dao.reportNumData(report_num);
				
				new Answer(report);
			}
		}
	}
	
	
	class Answer extends JDialog{
		
		private JTextArea Detail, Answer_ta; 
		private JButton OK, cancle;
		
		
		public Answer(ReportDTO report) {
			
			setModal(true);
			setSize(300, 300);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			Container c = getContentPane();
			c.setLayout(null);
			
			//			텍스트 에이리어
			//			텍스트 에이리어
			// 			벝느 1, 버튼 2
			
			
			
			
			
			setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Answer(null);
	}
	
}
