package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.CompoundBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.SwingComponentWrapper;

public class Main_frame extends JFrame {

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
		FunctionPane.setBackground(Color.red);
		FunctionPane.setToolTipText("기능 패널");
		
		contentPane.add(FunctionPane);
		
		setContentPane(contentPane);
		
	}
}

//배너 패널 클래스
//로고 레이블과 버튼을 올릴 패널을 멤버로 가진다.
class Baener_pane extends JPanel {

	private JLabel LOGO;
	private JPanel MenuBar;
	private Font LFont;
	
	public Baener_pane() {
		// TODO Auto-generated constructor stub
		
		//패버 패널 옵션 설정
		setSize(1050, 150);
		setLocation(0, 0);
		
		setLayout(null);
		setBackground(Color.CYAN);
		setToolTipText("배너 패널");
		
		
		//로고 초기설정
		LOGO = new JLabel("렌트");
		LFont = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 34);
		LOGO.setFont(LFont);
		LOGO.setBounds(40, 0, 150, 150);
		add(LOGO);
		
		MenuBar = new JPanel();
		MenuBar.setBounds(100, 75, 600, 150);
		MenuBar.setBackground(Color.green);
		
		
		
	}
}



