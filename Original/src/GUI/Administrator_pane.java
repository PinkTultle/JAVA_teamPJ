package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import GUI.C_Component.reportDetailTable;

public class Administrator_pane extends JPanel {
	
	protected JButton close_bt;
	protected Font font = new Font("굴림", Font.BOLD + Font.PLAIN, 12);
	//protected JTable Table;
	protected JScrollPane scrollPane;
	protected Object [] colNames;
	protected Object [][] data;
	protected DefaultTableModel model;
	protected JTable table;
	private TableCellRenderer renderer;
	
	
	public Administrator_pane(JFrame master) {
		
		setBounds(0, 79, 597, 421);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);	
		
		close_bt = new JButton("닫기");
		close_bt.setFont(font);
		close_bt.setBounds(getWidth()-100, getHeight()-80, 70, 30);
		close_bt.setBackground(null);
		close_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master.dispose();
			}
		});
		add(close_bt);		
		
		scrollPane = new JScrollPane();
		
	}
	
	
	protected void set_table(){
		
		//테이블 순서, 크기 못바꾸게
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.setFillsViewportHeight(true);
		
		table.addRowSelectionInterval(0, 0);
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		
		
		renderer = new Mytablerander();
		try {
			table.setDefaultRenderer(Class.forName("java.lang.Object"), renderer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	
	protected class Mytablerander extends DefaultTableCellRenderer{
		public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
			
			Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			
			if(!isSelected) {
				cell.setBackground(Color.white);
			}else {
				cell.setBackground(new Color(0xffecd2));
			}
			
			return cell;
		}
	}
}
