package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
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
		lb_Receive.setBounds(20, 212, 491, 41);
		add(lb_Receive);
		
		
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
        
        
        JTableHeader header = table.getTableHeader();
        // 헤더의 배경색, 텍스트 정렬을 설정할 수 있는 메소드
        header.setDefaultRenderer(new DefaultTableCellRenderer() {

        	private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
                label.setBackground(Color.WHITE); // 헤더의 배경색을 흰색으로 설정
                label.setHorizontalAlignment(JLabel.CENTER); // 헤더 내 텍스트 중앙 정렬
                label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK)); // 헤더 칸 하단에 윤곽선을 설정
                return label;
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
        scrollPane.setBounds(20, 320, 480, 291); 
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출

		// 선의 색상을 검정색으로 설정
		g.setColor(Color.lightGray);

		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(518, 212, 518, 750);
	}
}
