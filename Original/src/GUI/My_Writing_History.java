package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import GUI.C_Component.reportDetailTable;

import java.awt.Font;

public class My_Writing_History extends JPanel implements ActionListener {
    private DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();
	protected My_Page_Panel mpp;
	private RoundButton btn_back;
	
	
	public My_Writing_History() {
		
		//패널 크기 및 배경색
		setBackground(new Color(255,255,255));
		setBounds(0, BP.getHeight(), 1050, 700);
		setLayout(null);
        
		//나의 글 라벨
		JLabel lblNewLabel = new JLabel("나의 글");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblNewLabel.setBounds(30, 42, 185, 46);
		add(lblNewLabel);
		
		//뒤로가기 버튼
		btn_back = new RoundButton("뒤로가기");
		btn_back.setForeground(new Color(255, 255, 255));
		btn_back.setColorNormal(new Color(31, 78, 121));
		btn_back.setBounds(890, 660, 110, 30);
		btn_back.addActionListener(this);
		add(btn_back);
		
		
		JLabel[] labels = new JLabel[5];
        String[] productInfo = {"물품코드", "카테고리", "물품명", "반납기한", "처리상태"};
        Font slotFont = new Font("맑은 고딕", Font.PLAIN, 20);
        int[] xLoc = { 76, 240, 440, 640, 840};
        
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(productInfo[i]);
            labels[i].setFont(slotFont);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setBounds(xLoc[i], 110, 110, 50);
            add(labels[i]);
        }
		

        /*
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
        scrollPane.setBounds(68, 134, 890, 378);
        add(scrollPane);
        */
        
	}
	public My_Writing_History(My_Page_Panel mpp) {
 		this();
 		this.mpp = mpp;
 	}
	

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btn_back) {
			mpp.Open_My_Page();
		}
	}
	 
}
