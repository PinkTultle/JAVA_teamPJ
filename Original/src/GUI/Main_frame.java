package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Main_frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	/*
	 * contentPane - 배너 패널과 기능 패널 올라갈 배경 패널
	 * Baener - 프로그램 로고와 패널 이동 버튼들이 올라간 메뉴바 패널이 있는 패널
	 * FunctionPane - 기능 패널로 홈, 목록, 신청관리, 마이페이지 패널이 올라갈 패널
	 */
	private JPanel contentPane, Baener, FunctionPane;
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
		setSize(1050, 600);
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
		FunctionPane = new JPanel();
		//구역 구분쉽게 색깔 입히기
		FunctionPane.setBackground(Color.orange);
		//마우스 올리면 출력되는 문구 이후 삭제
		FunctionPane.setToolTipText("기능 패널");
		
		//콘텐츠 패널 위에 기능 패널 올림
		contentPane.add(FunctionPane);
		
		//해당 프레임의 콘텐츠 팬 설정
		setContentPane(contentPane);
		
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//e.getActionCommand()
		
	}

	//MenuBar.java의 버튼 이벤트와 연동할 패널 교체 함수
	public static void main(String text) {
		// TODO Auto-generated method stub
		
		
		//혹시몰라 예외처리
		try {
			
			//인자값을 받아야 실행
			if(text != null) {
				//인자값으로 받은 문자열에 따라 동작 결정
				//각 패널 만들어지면 함수 구현해서 넣을 부분
				switch(text) {
				
				case "홈":
					System.out.println("홈 패널 교체 호출");
					//패널교체
					break;
				
				case "목록":
					System.out.println("목록 패널 교체 호출");

					//패널교체
					break;
		
				case "신청관리":
					System.out.println("신청관리 패널 교체 호출");

					//패널교체
					break;
					
				case "마이페이지":
					System.out.println("마이페이지 패널 교체 호출");

					//패널교체
					break;
				
				}
				
			}
			
		} catch (Exception e1){
			
		}
	}
}
