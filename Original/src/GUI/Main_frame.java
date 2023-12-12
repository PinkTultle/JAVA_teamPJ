package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	/*
	 * contentPane - 배너 패널과 기능 패널 올라갈 배경 패널 Baener - 프로그램 로고와 패널 이동 버튼들이 올라간 메뉴바 패널이
	 * 있는 패널 FunctionPane - 기능 패널로 홈, 목록, 신청관리, 마이페이지 패널이 올라갈 패널
	 */
	private JPanel contentPane, Baener;
	private static My_Page_Panel P4;
	static JPanel P1, P2, P3;

	public static JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame. 메인 프레임 위에 콘텐츠 팬 그위 배너 팬과 기능 팬 올림
	 * 
	 * @throws SQLException
	 */
	public Main_frame(boolean Administrator) {

		mainFrame = this;

		mainFrame = this;

		// 프레임 설정
		setTitle("랜트 프로그램!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 프레임 크기 설정
		setSize(1050, 900);
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);

		// 콘텐츠 패널 설정
		// 이 위에 배너와 기능 패널 올라감
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(new BorderLayout());

		// 배널 클래스 생성
		// Baener_pane.java 파일에 정의
		Baener = new Baener_pane();

		// 콘텐츠 패널 위에 배너 패널 추가
		contentPane.add(Baener);

		P1 = new Main_home();
		P2 = new ListPanel();
		P3 = new OfferManage();
		P4 = new My_Page_Panel(Administrator);

		setContentPane(contentPane);

		contentPane.add(P1);
		contentPane.add(P2);
		contentPane.add(P3);
		contentPane.add(P4);

		P1.setVisible(true);
		P2.setVisible(false);
		P3.setVisible(false);
		P4.setVisible(false);

		setVisible(true);
	}

	// MenuBar.java의 버튼 이벤트와 연동할 패널 교체 함수
	public static void Changepane(String text) {

		// 패널 교체 메서
		if (text != null) {

			switch (text) {

			case "홈":
				// 패널교체
				if (!P4.Close_profile())
					break;
				P1.setVisible(true);
				P2.setVisible(false);
				P3.setVisible(false);
				P4.setVisible(false);
				break;

			case "목록":
				// 패널교체
				if (!P4.Close_profile())
					break;
				P1.setVisible(false);
				P2.setVisible(true);
				ListPanel.clear();
				ListPanel.searchCategory("전체");
				P3.setVisible(false);
				P4.setVisible(false);
				break;

			case "신청관리":
				// 패널교체
				if (!P4.Close_profile())
					break;

				P1.setVisible(false);
				P2.setVisible(false);
				OfferManage.refresh();
				P3.setVisible(true);
				P4.setVisible(false);
				break;

			case "메인 검색":

				// 패널교체 및 검색
				break;

			case "마이페이지":
				// 패널교체
				if (!P4.Close_profile())
					break;
				P4.Open_My_Page();

				P1.setVisible(false);
				P2.setVisible(false);
				P3.setVisible(false);
				P4.setVisible(true);
				break;
			}

			System.out.println("");

		}
	}

	public static void Category(String category) {

		// 목록배너 호출 및 카테고리값으로 겂색하는 긴능 추가부

		P1.setVisible(false);
		P2.setVisible(true);

		ListPanel.searchCategory(category);
	}

	public static void itemName(String itemName) {
		

		P1.setVisible(false);
		P2.setVisible(true);

		ListPanel.serachItemName(itemName);
	}
}
