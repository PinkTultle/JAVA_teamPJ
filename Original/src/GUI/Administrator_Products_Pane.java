package GUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import JDBC.ItemDAO;
import JDBC.UserDAO;

public class Administrator_Products_Pane extends Administrator_pane  {
	
	private JButton revise, delete;
	private String colNames[] = {"물품코드","카테고리","물품명","소유주", "대여상태"};  // 테이블 컬럼 값들
    private DefaultTableModel model = new DefaultTableModel(colNames, 0);
    private JTable table ;
    private ItemDAO dao;
	
	public Administrator_Products_Pane(JFrame master){
		super(master);
		table = new JTable(model);
		dao = new ItemDAO();
		try {
			dao.itemAll(model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		scrollPane.setBackground(Color.white);
		add(scrollPane);


		revise = new JButton("수정");
		revise.setBounds(close_bt.getX(), scrollPane.getY(),
					close_bt.getWidth(), close_bt.getHeight());
		revise.setBackground(null);
		add(revise);

		delete = new JButton("삭제");
		delete.setBounds(close_bt.getX(), revise.getY()+revise.getHeight()+20,
				close_bt.getWidth(), close_bt.getHeight());
		delete.setBackground(null);
		add(delete);
		
		
		
		setBackground(Color.white);
		
	}
		
}
