package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

// 메인 프레임 코드의 89번째 줄을 P4 = new My_Page(); 구문으로 수정하여 실행

public class My_Page extends JPanel implements ActionListener {

	private static final long serialVersionUID = 5812757489846205649L;
	private JTable table;
	String[] Column_Name = { "거래번호", "물품명", "반납기한" };
	String[][] Test = { { "data1", "data2", "data3" }, { "data1-1", "data2-1", "data3-1" } };
	private RoundButton Bt_profile;
	private JButton Bt_Rent_History;
	private JButton Bt_Rent_Alarm;
	private JButton Bt_My_Post;
	private JButton Bt_Report_History;
	private JButton Bt_More;
	private JButton Bt_temp1;
	private JButton Bt_temp2;
	private JProgressBar jpb;
	protected int RankScore=67; // TODO: 계정에 따라 각기다른 랭크 점수를 DB에서 받아와서 필드에 저장
	private String Rank;
	private JLabel lb_MyRank;
	private JLabel Rank_lb1;
	private JLabel Rank_lb2;
	private JButton Bt_Test;

	protected My_Page_Panel mpp;

	public My_Page() {

		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 1050, 800);
		setLayout(null);

		JLabel Label_NickName = new JLabel("KJH");

		Label_NickName.setFont(new Font("굴림", Font.BOLD, 19));
		Label_NickName.setBounds(50, 168, 112, 46); // 원래 좌표 -> 131, 198
		add(Label_NickName);

		Bt_profile = new RoundButton("프로필");
		Bt_profile.setForeground(new Color(255, 255, 255));
		Bt_profile.setColorNormal(new Color(41, 76, 121));
		Bt_profile.setFont(new Font("굴림", Font.BOLD, 11));
		Bt_profile.setBounds(250, 168, 72, 39);
		Bt_profile.addActionListener(this);
		add(Bt_profile);

		Bt_Rent_History = new RoundButton("렌트 내역",Color.LIGHT_GRAY);
		Bt_Rent_History.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Rent_History.setBounds(41, 246, 141, 130);
		Bt_Rent_History.addActionListener(this);
		add(Bt_Rent_History);

		Bt_Rent_Alarm = new RoundButton("렌트 알림",Color.LIGHT_GRAY);
		Bt_Rent_Alarm.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Rent_Alarm.setBounds(201, 246, 141, 130);
		Bt_Rent_Alarm.addActionListener(this);
		add(Bt_Rent_Alarm);

		Bt_My_Post = new RoundButton("나의 글",Color.LIGHT_GRAY);
		Bt_My_Post.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_My_Post.setBounds(41, 395, 141, 130);
		Bt_My_Post.addActionListener(this);
		add(Bt_My_Post);

		Bt_Report_History = new RoundButton("<html><center>신고<br>접수/내역<center></html>",Color.LIGHT_GRAY);
		Bt_Report_History.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Report_History.setBounds(202, 395, 141, 130);
		Bt_Report_History.addActionListener(this);
		add(Bt_Report_History);

		Bt_temp1 = new RoundButton("temp1",Color.LIGHT_GRAY);
		Bt_temp1.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_temp1.setBounds(41,544,141,130);
		add(Bt_temp1);
		
		Bt_temp2 = new RoundButton("temp2",Color.LIGHT_GRAY);
		Bt_temp2.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_temp2.setBounds(201,544,141,130);
		add(Bt_temp2);
		
		JLabel lblNewLabel_1 = new JLabel("렌트 알림");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(587, 576, 72, 32);
		add(lblNewLabel_1);

		
		table = new JTable(Test,Column_Name);
		table.setEnabled(false);
		table.setShowVerticalLines(false);
		table.setBounds(587, 645, 389, 144); 
		table.setRowHeight(70);  // 각 행의 높이 설정

		// 테이블 내 텍스트 가운데 정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 수평 가운데 정렬
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(128); // setPreferredWidth(128) => 첫번째 열 너비 설정
			columnModel.getColumn(i).setCellRenderer(centerRenderer);
		}
		//
		add(table);

		JLabel Label_Trade_Num = new JLabel("거래번호");
		Label_Trade_Num.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Trade_Num.setBounds(627, 614, 60, 23);
		add(Label_Trade_Num);

		JLabel Label_Item_Name = new JLabel("물품명");
		Label_Item_Name.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Item_Name.setBounds(764, 614, 60, 23);
		add(Label_Item_Name);

		JLabel Label_Return_Deadline = new JLabel("반납기한");
		Label_Return_Deadline.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Return_Deadline.setBounds(888, 614, 60, 23);
		add(Label_Return_Deadline);

		Bt_More = new JButton("더보기 >");
		Bt_More.setFont(new Font("굴림", Font.BOLD, 9));
		Bt_More.setBackground(new Color(255, 255, 255));
		Bt_More.setForeground(new Color(0, 0, 0));
		Bt_More.setBounds(910, 591, 48, 15);
		Bt_More.setMargin(new Insets(2, 2, 2, 2));
		Bt_More.setContentAreaFilled(false); // 버튼 눌렀을 때 버튼영역 표시가 나지 않게
		Bt_More.setBorderPainted(false); // 버튼 윤곽선 삭제
		Bt_More.setFocusPainted(false); // 클릭했을 때의 윤곽선 삭제
		Bt_More.addActionListener(this);
		add(Bt_More);

		//FIXME - 원하는 이미지로 경로 수정
		ImageIcon image = new ImageIcon(My_Page.class.getResource("../images/MEDAL.png"));
		Image image_ = image.getImage();   // 146 ~ 148 이미지 리사이즈를 위한 코드
		Image change = image_.getScaledInstance(250, 350, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(change);
		JLabel lb_mid_image = new JLabel(resizeIcon);
		lb_mid_image.setBounds(376, 140, 175, 454);
		add(lb_mid_image);
		
		
		jpb = new JProgressBar(JProgressBar.HORIZONTAL,0,100); 
		jpb.setForeground(new Color(99, 163, 146)); 
		jpb.setBackground(new Color(177, 209, 201)); 
		jpb.setBounds(582, 456,397, 15); 
		jpb.setMinimum(0);
		jpb.setMaximum(100); 
		jpb.setStringPainted(true); 
		jpb.setValue(RankScore);
		jpb.setString(String.valueOf(RankScore)+"점");
	    add(jpb);
		
		
		lb_MyRank = new JLabel("내 등급");
		lb_MyRank.setFont(new Font("굴림", Font.BOLD, 16));
		lb_MyRank.setBounds(572, 175, 72, 39);
		add(lb_MyRank);
		
		
		ImageIcon image_3 = new ImageIcon(My_Page.class.getResource("../images/3.png"));
		Image image3 = image_3.getImage();   // 146 ~ 148 이미지 리사이즈를 위한 코드
		Image change3 = image3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon3 = new ImageIcon(change3);
		JLabel lb_rank3 = new JLabel(resizeIcon3);
		lb_rank3.setBounds(675, 400, 50, 46);
		add(lb_rank3);
		
		ImageIcon image_2 = new ImageIcon(My_Page.class.getResource("../images/2.png"));
		Image image2 = image_2.getImage();   // 146 ~ 148 이미지 리사이즈를 위한 코드
		Image change2 = image2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon2 = new ImageIcon(change2);
		JLabel lb_rank2 = new JLabel(resizeIcon2);
		lb_rank2.setBounds(794, 400, 50, 46);
		add(lb_rank2);
		
		ImageIcon image_1 = new ImageIcon(My_Page.class.getResource("../images/1.png"));
		Image image1 = image_1.getImage();   // 146 ~ 148 이미지 리사이즈를 위한 코드
		Image change1 = image1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon1 = new ImageIcon(change1);
		JLabel lb_rank1 = new JLabel(resizeIcon1);
		lb_rank1.setBounds(953, 400, 50, 46);
		add(lb_rank1);
		
		//FIXME 랭크 점수 증가의 확인을 위한 임시버튼
		Bt_Test = new JButton("점수증가 테스트용");
		Bt_Test.setBounds(817, 496, 141, 57);
		Bt_Test.addActionListener(this);
		add(Bt_Test);
		
		
		Rank = "<html><font color='cd853f'>3</font>"; // 3급, 2급, 1급. 명칭은 바꾸는게 나을지도
		Rank_lb2 = new JLabel();
		Rank_lb2.setHorizontalAlignment(SwingConstants.CENTER);
		Rank_lb2.setFont(new Font("굴림", Font.BOLD, 18));
		Rank_lb2.setBounds(582, 309, 397, 46);
		add(Rank_lb2);
		
		Rank_lb1 = new JLabel();
		Rank_lb1.setHorizontalAlignment(SwingConstants.CENTER);
		Rank_lb1.setFont(new Font("굴림", Font.BOLD, 18));
		Rank_lb1.setBounds(582, 220, 397, 120);
		add(Rank_lb1);
		
		
		updatelabel(); // 랭크점수가 증가함에 따른 라벨 내용 업데이트 함수
		
		//JLabel lblNewLabel_2 = new JLabel("<html><font color='red'>40</font>점 남았습니다!");
		
		
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

	public My_Page(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	// 선 그리는 함수 ( 닉네임 이랑 렌트내역,렌트알림 버튼 사이 회색 선 )
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출

		// 선의 색상을 검정색으로 설정
		g.setColor(Color.lightGray);

		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(23, 220, 360, 220);
		g.drawLine(605, 640, 955, 640); // 렌트 알림 부분 선
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_profile) {
			System.out.println("프로필 창 호출");
			mpp.Open_profile();
		} else if (e.getSource() == Bt_Rent_History) {
			// 렌트 내역 창 호출
			System.out.println("렌트 내역 창 호출");
			mpp.Open_rentHistory();
		} else if (e.getSource() == Bt_Rent_Alarm) {
			// 렌트 알림 창 호출
			System.out.println("렌트 알림 호출");
		} else if (e.getSource() == Bt_My_Post) {
			// 나의 글 창 호출
			System.out.println("나의 글 창 호출");
		} else if (e.getSource() == Bt_Report_History) {
			// 신고/접수 내역 창 호출
			mpp.Open_reportHistory();
			System.out.println("신고 접수/내역 창 호출");
			Main_frame.Changepane("신고내역");
		}
		else if(e.getSource() == Bt_More) {
			// 더보기 창 호출
			System.out.println("더보기 창 호출");
		}
		else if(e.getSource()== Bt_Test && RankScore < 100) {
			RankScore += 5; // TODO: 게시물 작성, 신고완료 등의 활동에 따라 등급 점수 부여
			if (RankScore > 100)
				RankScore -= (RankScore - 100); 
			jpb.setValue(RankScore);
			jpb.setString(String.valueOf(RankScore)+"점");
			System.out.println(RankScore);
			updatelabel();
		}
	}
	
	// 랭크점수가 증가함에 따른 라벨 내용 업데이트 함수
	private void updatelabel() {
		
		if (RankScore < 30 ) {
			Rank = "<html><font color='cd853f'>3</font>";
			Rank_lb2.setText("<html><font color='red'>" +String.valueOf(30-RankScore)+ "</font>점 남았습니다!");
		}
		else if (RankScore <60) {
			Rank = "<html><font color='gray'>2</font>";
			Rank_lb2.setText("<html><font color='red'>" +String.valueOf(60-RankScore)+ "</font>점 남았습니다!");
		}
		else if (RankScore < 100){
			Rank = "<html><font color='ffd700'>1</font>";
			Rank_lb2.setText("<html><font color='red'>" +String.valueOf(100-RankScore)+ "</font>점 남았습니다!");
		}
		
		if (RankScore <100) {
			Rank_lb1.setText("<html><font color='red'>[1KJH]</font>님의 다음 등급["+Rank+"] 달성까지");
		}
		else {
			Rank_lb2.setText("");
			Rank_lb1.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;축하합니다!<br><br>최고 등급을 달성하였습니다!");
		}
	}
}
 