package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import net.miginfocom.swing.SwingComponentWrapper;

public class Main_frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
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
		setTitle("랜트 프로그램!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1050, 600);
		//사이즈 조절 off
		setResizable(false);
		//화면 중앙에 출력
		setLocationRelativeTo(null);
		
		//콘텐츠 패널 설정
		//이 위에 배너와 기능 패널 올라감
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("콘텐츠 팬");
		contentPane.setLayout(new BorderLayout());
		
		//배널 패널 설정
		Baener = new Baener_pane();
		
		
		contentPane.add(Baener);
		
		FunctionPane = new JPanel();
		FunctionPane.setBackground(Color.orange);
		FunctionPane.setToolTipText("기능 패널");
		
		contentPane.add(FunctionPane);
		
		setContentPane(contentPane);
		
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//e.getActionCommand()
		
	}
}

/*
//배너 패널 클래스
//로고 레이블과 버튼을 올릴 패널을 멤버로 가진다.
class Baener_pane extends JPanel {

	private JLabel LOGO;
	public JPanel MenuBar;
	private Font LFont;
	private Color BColor;
	
	public Baener_pane() {
		// TODO Auto-generated constructor stub
		
		//배너 사이즈 및 위치설정
		setBounds(0, 0, 1050, 150);
		
		//자유 레이아웃 설정
		setLayout(null);
		//배너 설정
		//색깔 설정 푸른색 + 투명도 비활성화
		BColor = new Color(0x31BAF5, false);
		setBackground(BColor);
		setToolTipText("배너 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("렌트");
		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 34);
		LOGO.setFont(LFont);
		LOGO.setBounds(40, 0, 150, 150);
		add(LOGO);
		
		MenuBar = new MenuBar();
		
		add(MenuBar);
	}
}


*/


