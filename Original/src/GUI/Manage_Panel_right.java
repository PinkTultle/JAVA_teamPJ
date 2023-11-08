package GUI;

import java.awt.Color;
import java.awt.Component;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Manage_Panel_right extends JPanel{

	private static final long serialVersionUID = 1L;
    String[][] send_tempdata = {{"10918","노트북","23-11-08 ~ 23-11-15"},{"01250","NJ-203","협의"}};
    private JTable table;
    private JScrollPane scrollPane;
    Vector<String> columnNames;
    Vector<Vector<Object>> data;

	public Manage_Panel_right() {
		setBackground(new Color(255, 255, 255));
		setBounds(527, 0, 523, 800);
		setLayout(null);
		
		RoundJLabel lb_Send = new RoundJLabel("New label");
		lb_Send.setText("보낸 신청");
		lb_Send.setHorizontalAlignment(SwingConstants.CENTER);
		lb_Send.setBounds(0, 212, 491, 41);
		add(lb_Send);
		
		 // 컬럼 이름을 벡터로 초기화
        columnNames = new Vector<>();
        columnNames.add("품명코드");
        columnNames.add("물품명");
        columnNames.add("요청기한");
        
        data = new Vector<>();
        for (int i = 0; i < send_tempdata.length; i++) {
            Vector<Object> row = new Vector<>();
            row.add(send_tempdata[i][0]);
            row.add(send_tempdata[i][1]);
            row.add(send_tempdata[i][2]);
            data.add(row);
        }
        NonEditableTableModel nonEditableModel = new NonEditableTableModel(data, columnNames);
        table = new JTable(nonEditableModel);
        table.setShowVerticalLines(false);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(60);  // 각 행의 높이 설정
        table.setTableHeader(null); // 테이블 헤더 제거
        
        
        // 테이블 내 텍스트 가운데 정렬을 위한 렌더러 설정
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬
        
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(centerRenderer);
        }
             
        scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(10, 320, 480, 291);  
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);
	
	}
}
