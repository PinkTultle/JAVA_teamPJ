package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
	private JPanel Banner;

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
	 */
	public Main_frame() {
		setTitle("랜트 프로그램!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		//사이즈 조절 off
		setResizable(false);
		//화면 중앙에 출력
		setLocationRelativeTo(null);

		
		Banner = new JPanel();
		Banner.setBackground(Color.LIGHT_GRAY);
		Banner.setToolTipText("안녕!");
		Banner.setBorder(new TitledBorder(null, "\u314D\u3147\u3134\u314D", TitledBorder.LEFT, TitledBorder.TOP, null, null));

		setContentPane(Banner);
		Banner.setLayout(new CardLayout(0, 0));
	}

}
