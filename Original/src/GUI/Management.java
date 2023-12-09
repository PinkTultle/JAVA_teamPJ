package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;




public class Management extends JFrame {
	private JTable table;
    private JTextField textField;
    private DefaultTableModel model;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
					frame.setTitle("관리자창");   // 창이름 설정
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// <패널>-------------------------------------------------------------
		
		// 상단 메뉴바 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 597, 79);
		panel_1.setBackground(new Color(245,245,245));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//왼쪽 표 위치 패널
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 79, 487, 395);
		panel_2.setBackground(Color.white);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		//오른쪽 버튼 위치 패널(메뉴 '신고관리' 클릭 시 이용되는 패널)
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(482, 77, 103, 385);
		panel_3.setBackground(Color.white);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		//오른쪽 버튼 위치 패널(메뉴 '회원관리, 물품관리' 클릭 시 이용되는 패널)
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(482, 77, 103, 385);
		panel_4.setBackground(Color.white);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		
		//관리자 텍스트 라벨
		JLabel lblNewLabel = new JLabel("관리자");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 0, 150, 66);
		panel_1.add(lblNewLabel);
				
		
		
		// <버튼>-------------------------------------------------------------
		
		//메뉴 버튼
		JButton report = new JButton("신고관리");
		report.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		report.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		report.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		report.setBounds(337, 51, 84, 28);
		panel_1.add(report);
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(true);     // 신고관리 패널 띄우기
				panel_4.setVisible(false);    // 회원관리, 물품관리 패널 없애기
			}
		});
		
		JButton member = new JButton("회원관리");
		member.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		member.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		member.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		member.setBounds(418, 51, 84, 28);
		panel_1.add(member);
		member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);   // 신고관리 패널 없애기
				panel_4.setVisible(true);    // 회원관리, 물품관리 패널 띄우기
			}
		});
		
		
		JButton article = new JButton("물품관리");
		article.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		article.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		article.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		article.setBounds(501, 51, 84, 28);
		panel_1.add(article);
		article.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				panel_3.setVisible(false);   // 신고관리 패널 없애기
				panel_4.setVisible(true);    // 회원관리, 물품관리 패널 띄우기
			}
		});
		
		

		//메뉴 '신고관리' 클릭 시 출력되는 버튼
		JButton approve = new JButton("완료");
		approve.setBounds(16, 31, 65, 28);
		approve.setBackground(Color.white);
		panel_3.add(approve);
		
		JButton close1 = new JButton("닫기");
		close1.setBounds(16, 111, 65, 28);
		close1.setBackground(Color.white);
		panel_3.add(close1);
		
		
		
		//메뉴 '회원관리, 물품관리' 클릭 시 출력되는 버튼
		JButton revise = new JButton("수정");
		revise.setBounds(16, 31, 65, 28);
		revise.setBackground(Color.white);
		panel_4.add(revise);

		
		JButton delete = new JButton("삭제");
		delete.setBounds(16, 65, 65, 28);
		delete.setBackground(Color.white);
		panel_4.add(delete);
		
		
		JButton close2 = new JButton("닫기");
		close2.setBounds(16, 150, 65, 28);
		close2.setBackground(Color.white);
		panel_4.add(close2);
	
		
		
		// <표>-------------------------------------------------------------
		
		// 표 삽입 -> 수정 필요함
		Object[] colNames = {"Name", "Age", "Gender"};
		Object[][] data = {
		                {"John", 28, "Male"},
		                {"Anna", 22, "Female"},
		                {"Bob", 35, "Male"}
		};
		model = new DefaultTableModel(data, colNames);

		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 30, 460, 344);
		panel_2.add(scrollPane);

		
		
		
		
	}
}
