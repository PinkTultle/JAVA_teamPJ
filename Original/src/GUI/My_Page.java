package GUI;

import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 메인 프레임 코드의 89번째 줄을 P4 = new My_Page(); 구문으로 수정하여 실행

public class My_Page extends JPanel implements ActionListener {

	private static final long serialVersionUID = 5812757489846205649L;
	private JTable table;
	String[] Column_Name = {"거래번호","물품명","반납기한"};
	String[][]	Test= {{"data1","data2","data3"},{"data1-1","data2-1","data3-1"}};
	private JButton Bt_profile;
	private JButton Bt_Rent_History;
	private JButton Bt_Rent_Alarm;
	private JButton Bt_My_Post;
	private JButton Bt_Report_History;
	private JButton Bt_More;
	private JButton Bt_temp1;
	private JButton Bt_temp2;


	public My_Page() {
		
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1050, 800);
		setLayout(null);
		
		JLabel Label_NickName = new JLabel("KJH");
		Label_NickName.setFont(new Font("굴림", Font.PLAIN, 19));
		Label_NickName.setBounds(50, 168, 112, 46); // 원래 좌표 -> 131, 198
		add(Label_NickName);
		
		Bt_profile = new RoundButton("프로필");
		Bt_profile.setFont(new Font("굴림", Font.PLAIN, 9));
		Bt_profile.setBounds(262, 175, 60, 32);
		Bt_profile.addActionListener(this);
		add(Bt_profile);
		
		Bt_Rent_History = new RoundButton("렌트 내역");
		Bt_Rent_History.setFont(new Font("굴림", Font.PLAIN, 16));
		Bt_Rent_History.setBounds(41, 246, 141, 130); // 버튼크기 width 141 ,height 110 -> width 141, height 130
		Bt_Rent_History.addActionListener(this);
		add(Bt_Rent_History);
		
		Bt_Rent_Alarm = new RoundButton("렌트 알림");
		Bt_Rent_Alarm.setFont(new Font("굴림", Font.PLAIN, 16));
		Bt_Rent_Alarm.setBounds(201, 246, 141, 130);
		Bt_Rent_Alarm.addActionListener(this);
		add(Bt_Rent_Alarm);
		
		Bt_My_Post = new RoundButton("나의 글");
		Bt_My_Post.setFont(new Font("굴림", Font.PLAIN, 16));
		Bt_My_Post.setBounds(41, 395, 141, 130);
		Bt_My_Post.addActionListener(this);
		add(Bt_My_Post);
		
		Bt_Report_History = new RoundButton("<html><center>신고<br>접수/내역<center></html>");
		Bt_Report_History.setFont(new Font("굴림", Font.PLAIN, 16));
		Bt_Report_History.setBounds(202, 395, 141, 130);
		Bt_Report_History.addActionListener(this);
		add(Bt_Report_History);
		
		Bt_temp1 = new RoundButton("temp1");
		Bt_temp1.setFont(new Font("굴림",Font.PLAIN,16));
		Bt_temp1.setBounds(41,544,141,130);
		add(Bt_temp1);
		
		Bt_temp2 = new RoundButton("temp2");
		Bt_temp2.setFont(new Font("굴림",Font.PLAIN,16));
		Bt_temp2.setBounds(201,544,141,130);
		add(Bt_temp2);
		
		JLabel lblNewLabel_1 = new JLabel("렌트 알림");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(600, 581, 72, 32);
		add(lblNewLabel_1);
		
		table = new JTable(Test,Column_Name);
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setBounds(600, 650, 389, 144); // y위치 555 -> 650 // Y축 95
		                                     // X위치 572 -> 600 // X축 28
		table.setRowHeight(70);  // 각 행의 높이 설정
		// 테이블 내 텍스트 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		TableColumnModel columnModel = table.getColumnModel();
		for (int i=0; i<columnModel.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(128); // setPreferredWidth(128) => 첫번째 열 너비 설정
			columnModel.getColumn(i).setCellRenderer(centerRenderer);
		}
		//
		add(table);
		
		JLabel Label_Trade_Num = new JLabel("거래번호");
		Label_Trade_Num.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Label_Trade_Num.setBounds(640, 619, 60, 23);
		add(Label_Trade_Num);
		
		JLabel Label_Item_Name = new JLabel("물품명");
		Label_Item_Name.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Label_Item_Name.setBounds(776, 619, 60, 23);
		add(Label_Item_Name);
		
		JLabel Label_Return_Deadline = new JLabel("반납기한");
		Label_Return_Deadline.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Label_Return_Deadline.setBounds(898, 619, 60, 23);
		add(Label_Return_Deadline);
		
		Bt_More = new JButton("더보기 >");
		Bt_More.setFont(new Font("굴림", Font.BOLD, 9));
		Bt_More.setBackground(new Color(255, 255, 255));
		Bt_More.setForeground(new Color(0, 0, 0));
		Bt_More.setBounds(923, 596, 48, 15);
		Bt_More.setMargin(new Insets(2, 2, 2, 2));
		Bt_More.setContentAreaFilled(false); // 버튼 눌렀을 때 버튼영역 표시가 나지 않게
		Bt_More.setBorderPainted(false); // 버튼 윤곽선 삭제
		Bt_More.setFocusPainted(false); // 클릭했을 때의 윤곽선 삭제
		Bt_More.addActionListener(this);
		add(Bt_More);
		
		//FIXME - 원하는 이미지로 경로 수정
		ImageIcon image = new ImageIcon(My_Page.class.getResource("../COMP_IMG/search2.jpg"));
		JLabel lb_image = new JLabel();
		lb_image.setIcon(image);
		
		
		lb_image.setBounds(395, 246, 175, 533);
		add(lb_image);
		
		/*
		 * // 클릭할 때만 윤곽선이 나타나게 설정 Bt_More.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mousePressed(MouseEvent e) {
		 * Bt_More.setBorderPainted(true); }
		 * 
		 * @Override public void mouseReleased(MouseEvent e) {
		 * Bt_More.setBorderPainted(false); } });
		 * 
		 * // 버튼이 포커스를 잃었을 때 윤곽선이 나타나지 않게 설정 Bt_More.addFocusListener(new FocusAdapter()
		 * {
		 * 
		 * @Override public void focusLost(FocusEvent e) {
		 * Bt_More.setBorderPainted(false); } });
		 */
	}
	
	// 선 그리는 함수 ( 닉네임 이랑 렌트내역,렌트알림 버튼 사이 회색 선 )
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출

		// 선의 색상을 검정색으로 설정
		g.setColor(Color.lightGray);

		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(23, 220, 360, 220);
		g.drawLine(618, 645, 968, 645); // 렌트 알림 부분 선
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_profile) {
			System.out.println("프로필 창 호출");
		}
		else if(e.getSource() == Bt_Rent_History) {
			// 렌트 내역 창 호출
			System.out.println("렌트 내역 창 호출");
		}
		else if(e.getSource() == Bt_Rent_Alarm) {
			// 렌트 알림 창 호출
			System.out.println("렌트 알림 호출");
		}
		else if(e.getSource() == Bt_My_Post) {
			// 나의 글 창 호출
			System.out.println("나의 글 창 호출");
		}
		else if(e.getSource() == Bt_Report_History) {
			// 신고/접수 내역 창 호출
			System.out.println("신고 접수/내역 창 호출");
			Main_frame.main("신고내역");
		}
		else if(e.getSource() == Bt_More) {
			// 더보기 창 호출
			System.out.println("더보기 창 호출");
		}
	}
}