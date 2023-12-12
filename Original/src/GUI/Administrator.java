package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;




public class Administrator extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, Report, Member, Products;
	private JButton report, member, article;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
					frame.setTitle("관리자창");   // 창이름 설정
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Administrator() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		
		
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);
		contentPane = (JPanel) getContentPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// <패널>-------------------------------------------------------------
		
		Administrator_pane a = new Administrator_pane(this);
		
		// 상단 메뉴바 패널
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 597, 79);
		panel_1.setBackground(new Color(245,245,245));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Report = new Administrator_Report_Pane(this);
		Member = new Administrator_Members_Pane(this, a);
		Products = new Administrator_Products_Pane(this);

		contentPane.add(Report);
		contentPane.add(Member);
		contentPane.add(Products);		
		
		Member.setVisible(false);
		Products.setVisible(false);
		
		
		//관리자 텍스트 라벨
		JLabel lblNewLabel = new JLabel("관리자");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(24, 0, 150, 66);
		panel_1.add(lblNewLabel);
				
		
		
		// <버튼>-------------------------------------------------------------
		
		//메뉴 버튼
		report = new JButton("신고관리");
		report.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		report.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		report.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		report.setBounds(337, 51, 84, 28);
		panel_1.add(report);
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member.setVisible(false);
				Report.setVisible(true);
				Products.setVisible(false);
			}
		});
		
		member = new JButton("회원관리");
		member.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		member.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		member.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		member.setBounds(418, 51, 84, 28);
		panel_1.add(member);
		member.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member.setVisible(true);
				Report.setVisible(false);
				Products.setVisible(false);
			}
		});
		
		
		article = new JButton("물품관리");
		article.setFont(new Font("굴림", Font.BOLD, 12));   // 폰트 크기 및 굵기 설정
		article.setBackground(new Color(59, 56, 56));	// 버튼 색상 설정
		article.setForeground(new Color(255, 255, 255));	// 글자 색상 설정
		article.setBounds(501, 51, 84, 28);
		panel_1.add(article);
		article.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {
				Member.setVisible(false);
				Report.setVisible(false);
				Products.setVisible(true);
			}
		});		
		
		setVisible(true);
		
	}
}
