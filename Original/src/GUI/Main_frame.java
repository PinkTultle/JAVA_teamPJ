package GUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTree;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class Main_frame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane, Baener, FunctionPane;
	private JLabel LOGO;
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
		setBounds(100, 100, 1050, 600);
		//사이즈 조절 off
		setResizable(false);
		//화면 중앙에 출력
		setLocationRelativeTo(null);
		
		//콘텐츠 패널 설정
		//이 위에 배너와 기능 패널 올라감
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("콘텐츠 팬");
		contentPane.setLayout(new CardLayout());
		
		//배널 패널 설정
		Baener = new JPanel();
		Baener.setBorder(new EmptyBorder(100, 100, 100, 100));
		Baener.setBackground(Color.CYAN);
		Baener.setToolTipText("배너 패널");
		
		contentPane.add(Baener);
		
		FunctionPane = new JPanel();
		FunctionPane.setBackground(Color.red);
		FunctionPane.setToolTipText("기능 패널");
		
		contentPane.add(FunctionPane);
		
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
	}

}
