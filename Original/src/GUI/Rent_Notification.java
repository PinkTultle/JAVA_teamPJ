package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Rent_Notification extends JPanel implements ActionListener{ // 렌트 알림 창
	private static final long serialVersionUID = 1L;

	Vector<String> columnNames;
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	
	private JTable table;
	private RoundButton Bt_Back;
	protected My_Page_Panel mpp;
	JLabel[] columnLbl = new JLabel[4];
	int[] xLoc = { 135, 460, 785 };
	
	public Rent_Notification() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 150, 1050, 800);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("렌트 알림");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(30, 29, 162, 78);
		add(lblNewLabel);
		
		String[] columnName = { "거래번호", "물품명", "반납 기한" };
		
		for (int i = 0; i < columnName.length; i++) {
			columnLbl[i] = new JLabel(columnName[i]);
			columnLbl[i].setBounds(xLoc[i], 110, 110, 50);
			columnLbl[i].setHorizontalAlignment(SwingConstants.CENTER);
			columnLbl[i].setFont(new Font("굴림", Font.PLAIN, 20));
			add(columnLbl[i]);
		}
		
		// 임시 데이터
//		  columnNames = new Vector<String>(); columnNames.add("거래번호");
//		  columnNames.add("물품명"); columnNames.add("반납 기한"); Vector<Object> row1 = new
//		  Vector<>(); row1.add("1"); row1.add("Item 1"); row1.add("2023-12-31");
//		  data.add(row1);
//		  
//		  Vector<Object> row2 = new Vector<>(); row2.add("2"); row2.add("Item 2");
//		  row2.add("2023-11-15"); data.add(row2);
		 
		   
		
		/* 
		 * TODO: 테이블 내용(data 벡터)을 DB랑 연동
		*/
		
		
		NonEditableTableModel nonEditableModel = new NonEditableTableModel(data, columnNames);
		table = new JTable();
		table.setBackground(new Color(192, 192, 192));
		table.setModel(nonEditableModel);
		table.setShowVerticalLines(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(30, 150, 975, 480);
		table.setRowHeight(60); // 각 행의 높이 설정
		table.getTableHeader().setReorderingAllowed(false); // 열 위치 드래그해서 바꿔지는 기능 비활성화
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(128); // setPreferredWidth() 열 너비 설정 메소드
			columnModel.getColumn(i).setCellRenderer(centerRenderer);
		}
		add(table);
		
		Bt_Back = new RoundButton("뒤로");
		Bt_Back.setBounds(890, 635, 110, 30);
		Bt_Back.setForeground(Color.WHITE);
		Bt_Back.setColorNormal(new Color(31, 78, 121));
		Bt_Back.addActionListener(this);
		add(Bt_Back);
	}
	
	public Rent_Notification(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출
		// 선의 색상을 검정색으로 설정
		g.setColor(Color.BLACK);
		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(table.getX(), table.getY()-1, table.getX()+table.getWidth(), table.getY()-1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_Back) {
			Main_frame.Changepane("마이페이지");
		}
	}
}
