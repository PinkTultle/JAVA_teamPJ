package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Member;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		table.addMouseListener(new MouseAdapter() {
			
		    public void mouseClicked(MouseEvent e) {
		    	if(e.getClickCount()%2 ==0) {
		    		approve.doClick();
		    	}
		    }
			
		});	
		
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
		private JButton OK_bt, cancle_bt;
		private JLabel title, complainant, Classification;
		private Font font = new Font("굴림", Font.PLAIN, 14);
		
		public Answer(ReportDTO report) {
			
			setModal(true);
			setSize(400, 550);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setResizable(false);
			
			setLocationRelativeTo(null);
			
			
			Container c = getContentPane();
			c.setLayout(null);
			
			title = new JLabel("신고답변");
			title.setFont(new Font("굴림",Font.BOLD + Font.PLAIN, 20));
			title.setSize(100, 40);
			title.setLocation((getWidth()-title.getWidth())/2, 15);
			
			complainant = new JLabel("신고자 : "+report.getPostID());
			complainant.setSize(200, 30);
			complainant.setFont(font);
			complainant.setLocation(((getWidth()/2)-(complainant.getWidth()-50))/2,
						title.getY()+title.getHeight()+10);
			
			Classification = new JLabel("신고유형 : "+ report.getCategory());
			Classification.setSize(200, 30);
			Classification.setFont(font);
			Classification.setLocation(((getWidth()/2)-(Classification.getWidth()-50))/2,
						complainant.getY()+complainant.getHeight());
			
			
			
			Detail = new JTextArea(10, 20);
			Detail.setSize(350, 150);
			Detail.setLocation((getWidth()-Detail.getWidth())/2 - 5,
					Classification.getY()+Classification.getHeight() +10);
			Detail.setFont(font);
			Detail.setEditable(false);
			Detail.setText("신고 내용 \n--------------------------------------\n\n"+report.getReportDetail());
			Detail.setLineWrap(true);
			
			
			Answer_ta = new JTextArea(10,20);
			Answer_ta.setSize(350, 150);
			Answer_ta.setLocation((getWidth()-Answer_ta.getWidth())/2 - 5,
					Detail.getY()+Detail.getHeight() +20);
			Answer_ta.setFont(font);
			Answer_ta.setText(report.getAnswer());
			Answer_ta.setLineWrap(true);
			
			
			
			OK_bt = new JButton("완료");
			OK_bt.setFont(font);
			OK_bt.setSize(100, 30);
			OK_bt.setLocation(75, Answer_ta.getY()+Answer_ta.getHeight()+10);
			
			OK_bt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					report.setAnswer(Answer_ta.getText());					
					if(dao.report_add_Answer(report)) {
						JOptionPane.showMessageDialog(null, "처리되었습니다.","답변 완료",
								JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
			});
			
			
			cancle_bt = new JButton("닫기");
			cancle_bt.setFont(font);
			cancle_bt.setSize(100, 30);
			cancle_bt.setLocation(OK_bt.getX()+OK_bt.getWidth() + 50,
							OK_bt.getY());
			cancle_bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			
			
			c.add(OK_bt);
			c.add(cancle_bt);
			c.add(Classification);
			c.add(complainant);
			c.add(Detail);
			c.add(Answer_ta);
			c.add(title);
			
			
			setVisible(true);
		}		
	}
	
}
