package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import GUI.MenuBar;


public class Main_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	/*
	 * contentPane - 배너 패널과 기능 패널 올라갈 배경 패널
	 * Baener - 프로그램 로고와 패널 이동 버튼들이 올라간 메뉴바 패널이 있는 패널
	 * FunctionPane - 기능 패널로 홈, 목록, 신청관리, 마이페이지 패널이 올라갈 패널
	 */
	private JPanel contentPane, Baener;
	private static JPanel FunctionPane, P1, P2, P3, P4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	
	}

	/**
	 * Create the frame.
	 * 메인 프레임 위에 콘텐츠 팬
	 * 그위 배너 팬과 기능 팬 올림
	 */
	public Main_frame() {
	
		//프레임 설정
		setTitle("랜트 프로그램!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//프레임 크기 설정
		setSize(1050, 900);
		//사이즈 조절 off
		setResizable(false);
		//화면 중앙에 출력
		setLocationRelativeTo(null);
		
		//콘텐츠 패널 설정
		//이 위에 배너와 기능 패널 올라감
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setLayout(new BorderLayout());
		
		//배널 클래스 생성
		//Baener_pane.java 파일에 정의
		Baener = new Baener_pane();
		
		//콘텐츠 패널 위에 배너 패널 추가 
		contentPane.add(Baener);
		
		
		//기능 패널 설정 - 이후 JPanel생성 -> 홈패널 생성으로 변경
		FunctionPane = new Main_home();
		//구역 구분쉽게 색깔 입히기

		
		//콘텐츠 패널 위에 기능 패널 올림
		contentPane.add(FunctionPane);
		
		//해당 프레임의 콘텐츠 팬 설정
		setContentPane(contentPane);
		
		//패널 교체를 위한 임시 코드
		
		P1 = new Main_home();
		P2 = new ListPanel();
		P3 = new Panel03();
		P4 = new Panel04();
		
		
		contentPane.add(P1);
		contentPane.add(P2);
		contentPane.add(P3);
		contentPane.add(P4);
		
		P1.setVisible(false);
		P2.setVisible(false);
		P3.setVisible(false);
		P4.setVisible(false);
		
		FunctionPane.setVisible(true);

	
	}


	//MenuBar.java의 버튼 이벤트와 연동할 패널 교체 함수
	public static void main(String text) {
		// TODO Auto-generated method stub

		//인자값을 받아야 실행
		if(text != null) {
			//인자값으로 받은 문자열에 따라 동작 결정
			//각 패널 만들어지면 함수 구현해서 넣을 부분
			switch(text) {
			
			case "홈":
				System.out.println("홈 패널 교체 호출");
				//패널교체
				P1.setVisible(true);
				P2.setVisible(false);
				P3.setVisible(false);
				P4.setVisible(false);
				FunctionPane.setVisible(false);
				
				break;
			
			case "목록":
				System.out.println("목록 패널 교체 호출");
				//패널교체
				P1.setVisible(false);
				P2.setVisible(true);
				P3.setVisible(false);
				P4.setVisible(false);
				FunctionPane.setVisible(false);
				
				break;
	
			case "신청관리":
				System.out.println("신청관리 패널 교체 호출");
				//패널교체
				P1.setVisible(false);
				P2.setVisible(false);
				P3.setVisible(true);
				P4.setVisible(false);
				FunctionPane.setVisible(false);
				

			case "메인 검색":
				System.out.println("메인 프레임 검색 기능 호출");

				//패널교체 및 검색
				break;
				
				
			case "마이페이지":
				System.out.println("마이페이지 패널 교체 호출");
				//패널교체
				P1.setVisible(false);
				P2.setVisible(false);
				P3.setVisible(false);
				P4.setVisible(true);
				FunctionPane.setVisible(false);
				
				break;
			}
		}
	}
	
	
	public static void Category(String category) {
		
		//목록배너 호출 및 카테고리값으로 겂색하는 긴능 추가부
		System.out.println("카테고리 버튼 클릭");
		System.out.println("클릭된 버튼 : " + category);	

		
	}
}



class Panel01 extends JPanel{
	private JLabel LOGO;
	private Font LFont;
	
	public Panel01() {
		setBounds(0, 150, 1050, 450);
		
		setLayout(null);
		//배너 설정
		setBackground(Color.MAGENTA);
		setToolTipText("홈 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("홈");
		LOGO.setBounds(525, 125, 250, 250);
		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 50);
		LOGO.setFont(LFont);

		add(LOGO);
		
	}
}

class Panel02 extends JPanel{
	private JLabel LOGO;
	private Font LFont;
	
	public Panel02() {
		setBounds(0, 150, 1050, 450);
		
		setLayout(null);
		//배너 설정
		setBackground(Color.YELLOW);
		setToolTipText("목록 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("목록");
		LOGO.setBounds(525, 125, 250, 250);

		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 50);
		LOGO.setFont(LFont);

		add(LOGO);
		
	}
}

class Panel03 extends JPanel{
	private JLabel LOGO;
	private Font LFont;
	
	public Panel03() {
		setBounds(0, 150, 1050, 800);
		
		setLayout(null);
		//배너 설정
		setBackground(Color.ORANGE);
		setToolTipText("");
		
		
		//로고 초기설정
		LOGO = new JLabel("");
		LOGO.setBounds(525, 125, 250, 250);

		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 50);
		LOGO.setFont(LFont);

		add(LOGO);
		
	}
}

class Panel04 extends JPanel{
	private JLabel LOGO;
	private Font LFont;
	
	public Panel04() {
		setBounds(0, 150, 1050, 800);
		
		setLayout(null);
		//배너 설정
		setBackground(Color.PINK);
		setToolTipText("마이패이지 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("마이페이지");
		LOGO.setBounds(525, 125, 250, 250);

		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 50);
		LOGO.setFont(LFont);

		add(LOGO);
		
	}
}









