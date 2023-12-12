package GUI;

import java.awt.Color;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Manage_Panel_right extends JPanel{

	private static final long serialVersionUID = 1L;
    String[][] send_tempdata = {{"10918","노트북","23-11-08 ~ 23-11-15"},{"01250","NJ-203","협의"},
    		{"10918","노트북","23-11-08 ~ 23-11-15"},{"10918","노트북","23-11-08 ~ 23-11-15"},
    		{"10918","노트북","23-11-08 ~ 23-11-15"},{"10918","노트북","23-11-08 ~ 23-11-15"}};
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
		lb_Send.setBounds(0, 172, 491, 41);
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
        table.setBorder(BorderFactory.createEmptyBorder());
        // 테이블에서 행 단위로 선택되게 설정
        table.setRowSelectionAllowed(true);
        table.addMouseListener(new MouseAdapter() { // 테이블 요소 마우스선택 이벤트
        	  public void mouseClicked(MouseEvent e) {
        	        int row = table.rowAtPoint(e.getPoint()); // 클릭된 위치의 행 인덱스
        	        int col = table.columnAtPoint(e.getPoint()); // 클릭된 위치의 열 인덱스

        	        if (row >= 0 && col >= 0) {
        	        	Object value = table.getValueAt(row, col); // 선택된 셀의 값을 value에 저장
        	            // TODO 셀 선택시 해당 글 페이지로 연결
        	          
        	        }
        	    }
        });
        
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
        scrollPane.setBounds(10, 260, 480, 410);  
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK)); // 테이블이 들어있는 스크롤 패널의 상단 윤곽선을 2로 진하게 만듦
        add(scrollPane);
        
        JLabel lb_ItemCode = new JLabel("품명코드");
        lb_ItemCode.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_ItemCode.setBounds(58, 235, 66, 15);
        add(lb_ItemCode);
        
        JLabel lb_ItemName = new JLabel("물품명");
        lb_ItemName.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_ItemName.setBounds(229, 235, 43, 15);
        add(lb_ItemName);
        
        JLabel lb_Day = new JLabel("요청기한");
        lb_Day.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_Day.setBounds(382, 235, 66, 15);
        add(lb_Day);
	
	}
}
