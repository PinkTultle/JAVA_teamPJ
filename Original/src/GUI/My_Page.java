package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import GUI.C_Component.myPageTable;
import JDBC.UserDAO;
import JDBC.UserDTO;

// 메인 프레임 코드의 89번째 줄을 P4 = new My_Page(); 구문으로 수정하여 실행

public class My_Page extends JPanel implements ActionListener {

	private static final long serialVersionUID = 5812757489846205649L;
	myPageTable table;
	String[] Column_Name = { "거래번호", "물품명", "반납기한" };
	String[][] Test = { { "data1", "data2", "data3" }, { "data1-1", "data2-1", "data3-1" } };
	private RoundButton Bt_profile;
	private JButton Bt_Rent_History;
	private JButton Bt_Rent_Alarm;
	private JButton Bt_My_Post;
	private JButton Bt_Report_History;
	private JButton Bt_temp1;
	private JButton Bt_temp2;
	private JProgressBar jpb;
	protected int RankScore;
	private String Rank;
	private JLabel lb_MyRank;
	private String previousRank;
	private JLabel Rank_lb1;
	private JLabel Rank_lb2;
	private JButton Bt_Test;
	private String name;
	private JLabel lb_image;
	private ImageIcon resizeIcon3_TOP;
	private ImageIcon resizeIcon2_TOP;
	private ImageIcon resizeIcon1_TOP;
	protected My_Page_Panel mpp;

	public My_Page(boolean Administrator) {

		setBackground(new Color(255, 255, 255));
		setBounds(0, 150, 1050, 800);
		setLayout(null);

		name = My_Page_Panel.userInfo_cur.getNickname();
		JLabel Label_NickName = new JLabel(name);

		Label_NickName.setFont(new Font("굴림", Font.BOLD, 19));
		Label_NickName.setBounds(50, 18, 112, 46); // 원래 좌표 -> 131, 198
		add(Label_NickName);

		// 마일리지 점수
		UserDAO dao;
		dao = new UserDAO();
		RankScore = dao.milerege();
		RankScore = (RankScore > 100) ? 100 : RankScore;

		Bt_profile = new RoundButton("프로필");
		Bt_profile.setForeground(new Color(255, 255, 255));
		Bt_profile.setColorNormal(new Color(41, 76, 121));
		Bt_profile.setFont(new Font("굴림", Font.BOLD, 11));
		Bt_profile.setBounds(250, 18, 72, 39);
		Bt_profile.addActionListener(this);
		add(Bt_profile);

		Bt_Rent_History = new RoundButton("렌트 내역", Color.LIGHT_GRAY);
		Bt_Rent_History.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Rent_History.setBounds(41, 96, 141, 130);
		Bt_Rent_History.addActionListener(this);
		add(Bt_Rent_History);

		Bt_Rent_Alarm = new RoundButton("렌트 알림", Color.LIGHT_GRAY);
		Bt_Rent_Alarm.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Rent_Alarm.setBounds(201, 96, 141, 130);
		Bt_Rent_Alarm.addActionListener(this);
		add(Bt_Rent_Alarm);

		Bt_My_Post = new RoundButton("나의 글", Color.LIGHT_GRAY);
		Bt_My_Post.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_My_Post.setBounds(41, 245, 141, 130);
		Bt_My_Post.addActionListener(this);
		add(Bt_My_Post);

		Bt_Report_History = new RoundButton("<html><center>신고<br>접수/내역<center></html>", Color.LIGHT_GRAY);
		Bt_Report_History.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_Report_History.setBounds(202, 245, 141, 130);
		Bt_Report_History.addActionListener(this);
		add(Bt_Report_History);

		Bt_temp1 = new RoundButton("관라자 메뉴", Color.LIGHT_GRAY);
		Bt_temp1.setFont(new Font("굴림", Font.BOLD, 16));
		Bt_temp1.setBounds(41, 394, 141, 130);
		Bt_temp1.addActionListener(this);

		add(Bt_temp1);

		Bt_temp1.setVisible(Administrator);

		JLabel lblNewLabel_1 = new JLabel("렌트 알림");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(587, 426, 72, 32);
		add(lblNewLabel_1);

		table = new myPageTable(587, 495, 389, 144, 2);
		table.setItem(2);
		add(table);

		JLabel Label_Trade_Num = new JLabel("거래번호");
		Label_Trade_Num.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Trade_Num.setBounds(627, 464, 60, 23);
		add(Label_Trade_Num);

		JLabel Label_Item_Name = new JLabel("물품명");
		Label_Item_Name.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Item_Name.setBounds(764, 464, 60, 23);
		add(Label_Item_Name);

		JLabel Label_Return_Deadline = new JLabel("반납기한");
		Label_Return_Deadline.setFont(new Font("굴림", Font.PLAIN, 12));
		Label_Return_Deadline.setBounds(888, 464, 60, 23);
		add(Label_Return_Deadline);

		// FIXME - 원하는 이미지로 경로 수정
		ImageIcon image = new ImageIcon(My_Page.class.getResource("../images/MEDAL.png"));
		Image image_ = image.getImage();
		Image change = image_.getScaledInstance(250, 350, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon = new ImageIcon(change);
		JLabel lb_mid_image = new JLabel(resizeIcon);
		lb_mid_image.setBounds(376, -10, 175, 454);
		add(lb_mid_image);

		jpb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		jpb.setForeground(new Color(99, 163, 146));
		jpb.setBackground(new Color(177, 209, 201));
		jpb.setBounds(582, 306, 397, 15);
		jpb.setMinimum(0);
		jpb.setMaximum(100);
		jpb.setStringPainted(true);
		jpb.setValue(RankScore);
		jpb.setString(String.valueOf(RankScore) + "점");
		add(jpb);

		lb_MyRank = new JLabel("내 등급");
		lb_MyRank.setFont(new Font("굴림", Font.BOLD, 16));
		lb_MyRank.setBounds(572, 25, 72, 39);
		add(lb_MyRank);

		// 프로그레스 바 위에 작은 랭크 아이콘 이미지
		ImageIcon image_3 = new ImageIcon(My_Page.class.getResource("../images/3.png"));
		Image image3 = image_3.getImage();
		Image change3 = image3.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon3 = new ImageIcon(change3);
		JLabel lb_rank3 = new JLabel(resizeIcon3);
		lb_rank3.setBounds(688, 277, 26, 23);
		add(lb_rank3);

		ImageIcon image_2 = new ImageIcon(My_Page.class.getResource("../images/2.png"));
		Image image2 = image_2.getImage();
		Image change2 = image2.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon2 = new ImageIcon(change2);
		JLabel lb_rank2 = new JLabel(resizeIcon2);
		lb_rank2.setBounds(806, 277, 26, 23);
		add(lb_rank2);

		ImageIcon image_1 = new ImageIcon(My_Page.class.getResource("../images/1.png"));
		Image image1 = image_1.getImage();
		Image change1 = image1.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon resizeIcon1 = new ImageIcon(change1);
		JLabel lb_rank1 = new JLabel(resizeIcon1);
		lb_rank1.setBounds(965, 277, 26, 23);
		add(lb_rank1);

		// FIXME 랭크 점수 증가의 확인을 위한 임시버튼
		Bt_Test = new JButton("점수증가 테스트용");
		Bt_Test.setBounds(817, 346, 141, 57);
		Bt_Test.addActionListener(this);
		add(Bt_Test);

		Rank = "<html><font color='cd853f'>0</font>"; // 3급, 2급, 1급. 명칭은 바꾸는게 나을지도
		Rank_lb2 = new JLabel();
		Rank_lb2.setHorizontalAlignment(SwingConstants.CENTER);
		Rank_lb2.setFont(new Font("굴림", Font.BOLD, 18));
		Rank_lb2.setBounds(582, 159, 397, 46);
		add(Rank_lb2);

		Rank_lb1 = new JLabel();
		Rank_lb1.setHorizontalAlignment(SwingConstants.CENTER);
		Rank_lb1.setFont(new Font("굴림", Font.BOLD, 18));
		Rank_lb1.setBounds(582, 70, 397, 120);
		add(Rank_lb1);

		lb_image = new JLabel("");
		lb_image.setFont(new Font("굴림", Font.BOLD, 13));
		lb_image.setHorizontalAlignment(SwingConstants.CENTER);
		lb_image.setBounds(631, 4, 92, 92);
		add(lb_image);

		// <내 등급> 레이블 옆에 표시될 이미지 사이즈 조정
		Image change3_TOP = image3.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		resizeIcon3_TOP = new ImageIcon(change3_TOP);
		Image change2_TOP = image2.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		resizeIcon2_TOP = new ImageIcon(change2_TOP);
		Image change1_TOP = image1.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		resizeIcon1_TOP = new ImageIcon(change1_TOP);

		updatelabel(RankScore);
		updateImage(RankScore);
	}

	public My_Page(My_Page_Panel mpp, boolean Administrator) {
		this(Administrator);
		this.mpp = mpp;
	}

	// 선 그리는 함수 ( 닉네임 이랑 렌트내역,렌트알림 버튼 사이 회색 선 )
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // 원래 JPanel의 그리기 기능을 호출

		// 선의 색상을 검정색으로 설정
		g.setColor(Color.lightGray);

		// 선을 그리기. (x1, y1)에서 (x2, y2)까지
		g.drawLine(23, 70, 360, 70);
		g.drawLine(605, 490, 955, 490); // 렌트 알림 부분 선
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_profile) {
			mpp.Open_profile();
		} else if (e.getSource() == Bt_Rent_History) {
			// 렌트 내역 창 호출
			mpp.Open_rentHistory();
		} else if (e.getSource() == Bt_Rent_Alarm) {
			// 렌트 알림 창 호출
			mpp.Open_rentnotifi();
		} else if (e.getSource() == Bt_My_Post) {
			// 나의 글 창 호출
			mpp.Open_myWrite();
		} else if (e.getSource() == Bt_Report_History) {
			// 신고/접수 내역 창 호출
			mpp.Open_reportHistory();

			Main_frame.Changepane("신고내역");
		} else if (e.getSource() == Bt_Test) {

			UserDAO dao;
			UserDTO dto = new UserDTO();
			dao = new UserDAO();

			dao.milerege_sum(); // 마일리지 +5
			int return_mile = dao.milerege();

			return_mile = (return_mile > 100) ? 100 : return_mile;

			jpb.setValue(return_mile);
			jpb.setString(String.valueOf(return_mile) + "점");


			updatelabel(return_mile);
			updateImage(return_mile);
		} else if (e.getSource() == Bt_temp1) {
			try {
				new Administrator();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			// 관리자 창 연결 함수

		}
	}

	// 랭크점수가 증가함에 따른 라벨 내용 업데이트 메소드
	private void updatelabel(int RankScore) {
		String nextRank = "";
		RankScore = RankScore > 100 ? 100 : RankScore;
		if (RankScore < 30) {
			Rank = "없음";
			Rank_lb2.setText("<html><font color='red'>" + String.valueOf(30 - RankScore) + "</font>점 남았습니다!");

			nextRank = "<html><font color='cd853f'>3</font>";
		} else if (RankScore < 60) {
			Rank = "<html><font color='cd853f'>3</font>";
			Rank_lb2.setText("<html><font color='red'>" + String.valueOf(60 - RankScore) + "</font>점 남았습니다!");

			nextRank = "<html><font color='gray'>2</font>";
		} else if (RankScore < 100) {
			Rank = "<html><font color='gray'>2</font>";
			Rank_lb2.setText("<html><font color='red'>" + String.valueOf(100 - RankScore) + "</font>점 남았습니다!");

			nextRank = "<html><font color='ffd700'>1</font>";
		} else if (RankScore == 100) {
			Rank = "<html><font color='ffd700'>1</font>";
			Rank_lb2.setText("");
			Rank_lb1.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;축하합니다!<br><br>최고 등급을 달성하였습니다!");
		}

		if (RankScore < 100) {
			Rank_lb1.setText("<html><font color='red'>[" + name + "]</font>님의 다음 등급 [" + nextRank + "] 달성까지");
		}
	}

	// <내 등급> 레이블 옆에 랭크 아이콘 이미지 업데이트 메소드
	private void updateImage(int RankScore) {
		RankScore %= 101;
		if (RankScore < 30)
			lb_image.setIcon(null);
		else if (RankScore < 60) {
			lb_image.setIcon(resizeIcon3_TOP);
		} else if (RankScore < 100) {
			lb_image.setIcon(resizeIcon2_TOP);
		} else if (RankScore == 100) {
			lb_image.setIcon(resizeIcon1_TOP);
		}
	}
}
