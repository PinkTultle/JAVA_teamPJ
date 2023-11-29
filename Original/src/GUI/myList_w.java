package GUI;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class myList_w {

    private JFrame frame;
    private JTable table;
    private JTextField textField;
    private DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                myList_w window = new myList_w();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public myList_w() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("나의 글");
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 898, 636);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 199, 255)); // 투명 파란색
        panel.setBounds(0, 0, 884, 105);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("렌트");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
        lblNewLabel.setBounds(25, 36, 81, 47);
      
        panel.add(lblNewLabel);

        JButton btn_mypage = new JButton("마이페이지");
        btn_mypage.setFont(new Font("굴림", Font.BOLD, 13));
        btn_mypage.setBackground(new Color(59, 56, 56));
        btn_mypage.setForeground(new Color(255, 255, 255));
        btn_mypage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_mypage.setBounds(782, 76, 102, 29);
        panel.add(btn_mypage);

        JButton btn_apply_mgmt = new JButton("신청관리");
        btn_apply_mgmt.setForeground(new Color(255, 255, 255));
        btn_apply_mgmt.setBackground(new Color(59, 56, 56));
        btn_apply_mgmt.setFont(new Font("굴림", Font.BOLD, 13));
        btn_apply_mgmt.setBounds(681, 76, 102, 29);
        panel.add(btn_apply_mgmt);

        JButton btn_list = new JButton("목록");
        btn_list.setFont(new Font("굴림", Font.BOLD, 13));
        btn_list.setBackground(new Color(59, 56, 56));
        btn_list.setForeground(new Color(255, 255, 255));
        btn_list.setBounds(580, 76, 102, 29);
        panel.add(btn_list);

        JButton btn_home = new JButton("홈");
        btn_home.setFont(new Font("굴림", Font.BOLD, 13));
        btn_home.setForeground(new Color(255, 255, 255));
        btn_home.setBackground(new Color(59, 56, 56));
        btn_home.setBounds(479, 76, 102, 29);
        panel.add(btn_home);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 115, 862, 474);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        panel_1.setOpaque(false);

        Object[] columnNames = {"Name", "Age", "Gender"};
        Object[][] data = {
                {"John", 28, "Male"},
                {"Anna", 22, "Female"},
                {"Bob", 35, "Male"}
        };
        model = new DefaultTableModel(data, columnNames);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(48, 91, 769, 373);
        panel_1.add(scrollPane);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(48, 48, 123, 33);
        panel_1.add(comboBox);

        textField = new JTextField();
        textField.setText("  검색어 입력");
        textField.setBounds(174, 48, 223, 33);
        panel_1.add(textField);
        textField.setColumns(10);

        JButton btn_search = new JButton("");
        btn_search.setForeground(new Color(255, 255, 255));
        btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btn_search.setIcon(new ImageIcon("../COMP_IMG/search3.png"));
        btn_search.setBounds(392, 48, 40, 33);
        btn_search.setBorderPainted(false);
        btn_search.setContentAreaFilled(false);
        panel_1.add(btn_search);
        
        JList list = new JList();
        list.setBounds(168, 56, 1, 1);
        panel_1.add(list);
    }
}
