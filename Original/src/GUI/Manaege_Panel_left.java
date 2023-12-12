package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Manaege_Panel_left extends JPanel {
	
	 	Vector<String> columnNames;
	    Vector<Vector<Object>> data;
	    String[][] receive_tempdata = {{"15714","산악자전거","23-11-08 ~ 23-11-15"},{"01250","NJ-203","협의"}};
	    private JTable table;
	    private JScrollPane scrollPane;

	    public Manaege_Panel_left() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 527, 800);
		setLayout(null);
		
		RoundJLabel lb_Receive = new RoundJLabel("New label");
		lb_Receive.setHorizontalAlignment(JLabel.CENTER);
		lb_Receive.setText("받은 신청");
		lb_Receive.setBounds(20, 172, 491, 41);
		add(lb_Receive);
		
		
		JLabel lb_ItemCode = new JLabel("품명코드");
        lb_ItemCode.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_ItemCode.setBounds(70, 235, 66, 15);
        add(lb_ItemCode);
        
        JLabel lb_ItemName = new JLabel("물품명");
        lb_ItemName.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_ItemName.setBounds(238, 235, 43, 15);
        add(lb_ItemName);
        
        JLabel lb_Day = new JLabel("요청기한");
        lb_Day.setFont(new Font("굴림", Font.PLAIN, 15));
        lb_Day.setBounds(390, 235, 66, 15);
        add(lb_Day);
		
		 // 컬럼 이름을 벡터로 초기화
        columnNames = new Vector<>();
        columnNames.add("품명코드");
        columnNames.add("물품명");
        columnNames.add("요청기한");
        
        data = new Vector<>();
        for (int i = 0; i < receive_tempdata.length; i++) {
            Vector<Object> row = new Vector<>();
            row.add(receive_tempdata[i][0]);
            row.add(receive_tempdata[i][1]);
            row.add(receive_tempdata[i][2]);
            data.add(row);
        }
        NonEditableTableModel nonEditableModel = new NonEditableTableModel(data, columnNames);
        table = new JTable(nonEditableModel);
        table.setShowVerticalLines(false);
        table.setRowSelectionAllowed(false);
        table.setRowHeight(60);  // 각 행의 높이 설정
        table.getTableHeader().setReorderingAllowed(false);
        table.setTableHeader(null); // 테이블 헤더 제거
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
        scrollPane.setBounds(20, 260, 480, 410); 
        scrollPane.getViewport().setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        add(scrollPane);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출

		// 선의 색상을 검정색으로 설정
		g.setColor(Color.lightGray);

		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(518, 165, 518, 750);
	}
}
