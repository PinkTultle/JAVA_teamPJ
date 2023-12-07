package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class My_Writing_History extends JPanel {
	private JTable table;
    private DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPanel BP = new Baener_pane();
	protected My_Page_Panel mpp;
	
	
	public My_Writing_History() {
		
		//패널 크기 및 배경색
		setBackground(new Color(255,255,255));
		setBounds(0, BP.getHeight(), 1050, 700);
		setLayout(null);
		
		//콤보박스
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("굴림", Font.PLAIN, 13));
        comboBox.setBounds(68, 63, 123, 33);
        comboBox.addItem("대여중");
        comboBox.addItem("대여");
        comboBox.addItem("예약중");
        add(comboBox);
        
        
        //검색창
        textField = new JTextField("검색어를 입력하세요");
        textField.setFont(new Font("굴림", Font.PLAIN, 13));
        textField.setBounds(203, 63, 205, 33);
        textField.setColumns(10);
        	textField.addFocusListener(new FocusListener() {
	            public void focusGained(FocusEvent e) {
	                // 텍스트 필드에 포커스가 생기면 기본값을 지움
	                if (textField.getText().equals("기본값 입력")) {
	                    textField.setText("");
	                }
	            }
	            
	            public void focusLost(FocusEvent e) {
	                // 텍스트 필드에서 포커스가 떠나면, 값이 비어있으면 다시 기본값을 설정
	                if (textField.getText().isEmpty()) {
	                    textField.setText("기본값 입력");
	                }
	            }
	        });
	    add(textField);
	    
	    
        //검색 버튼
        JButton btn_search = new JButton("");
        btn_search.setForeground(new Color(255, 255, 255));
        btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_search.setIcon(new ImageIcon("../Original/src/COMP_IMG/search3.png"));   // 버튼 경로
        btn_search.setBounds(416, 63, 40, 33);  //버튼 크기
        btn_search.setBorderPainted(false);   // 버튼 테두리 없앰
        btn_search.setContentAreaFilled(false);
        add(btn_search);
        
        
        
        // 표 -> db 연결
        Object[] columnNames = {"Name", "Age", "Gender"};
        Object[][] data = {
                {"John", 28, "Male"},
                {"Anna", 22, "Female"},
                {"Bob", 35, "Male"}
        };
        model = new DefaultTableModel(data, columnNames);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(68, 134, 890, 522);
        add(scrollPane);
        
        
	}
	public My_Writing_History(My_Page_Panel mpp) {
 		this();
 		this.mpp = mpp;
 	}
	 
}
