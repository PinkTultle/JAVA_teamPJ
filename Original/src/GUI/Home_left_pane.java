package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home_left_pane extends Function_pane {

	private JLabel L1, L2;
	private JTextField Tf;
	private search_bt Jb1 = null;
	private Font font;
	private JPanel BP = new Baener_pane();

	public Home_left_pane() {

		new eventLisen();

		setSize(500, 800);
		setLayout(null);
		font = new Font("맑은 고딕", Font.PLAIN + Font.BOLD, 24);

		// 검색, 최근 방문 키워드 표시
		L1 = new JLabel("검색");
		L1.setBounds(50, BP.getHeight() + 30, 50, 50);
		L1.setFont(font);
		L1.setForeground(Color.black);
		add(L1);

		L2 = new JLabel("최근 방문");
		L2.setBounds(L1.getX(), L1.getY() + 200, 150, 50);
		L2.setFont(font);
		L2.setForeground(Color.black);
		add(L2);

		// 검색어 입력 텍스트 필드 설정
		Tf = new JTextField();

		Tf.setText("검색어를 입력하세요");
		font = new Font("맑은 고딕", Font.PLAIN, 18);
		// Tf.setBorder(new LineBorder(Color.black, 0));

		Tf.setFont(font);
		Tf.setEnabled(true);
		Tf.setBounds(50, BP.getHeight() + 100, 350, 40);
		Tf.addFocusListener(new eventLisen());
		add(Tf);

		// 검색 버튼 생성
		Jb1 = new search_bt();
		Jb1.addActionListener(new eventLisen());
		add(Jb1);

		// 최근방문 버튼
		JButton img1_btn = new JButton("");
		img1_btn.setIcon(new ImageIcon("../Original/src/images/Img_Computer.jpg")); // 버튼 경로
		img1_btn.setBounds(50, BP.getHeight() + 300, 210, 180); // 버튼 크기
		img1_btn.setBorderPainted(false); // 버튼 테두리 없앰
		img1_btn.setContentAreaFilled(false);
		add(img1_btn);

		JButton img2_btn = new JButton("");
		img2_btn.setIcon(new ImageIcon("../Original/src/images/Img_Book.png")); // 버튼 경로
		img2_btn.setBounds(270, BP.getHeight() + 310, 200, 160); // 버튼 크기
		img2_btn.setBorderPainted(false); // 버튼 테두리 없앰
		img2_btn.setContentAreaFilled(false);
		add(img2_btn);

		JButton img3_btn = new JButton("");
		img3_btn.setIcon(new ImageIcon("../Original/src/images/Img_Generated.jpg")); // 버튼 경로
		img3_btn.setBounds(50, BP.getHeight() + 480, 210, 160); // 버튼 크기
		img3_btn.setBorderPainted(false); // 버튼 테두리 없앰
		img3_btn.setContentAreaFilled(false);
		add(img3_btn);

		JButton img4_btn = new JButton("");
		img4_btn.setIcon(new ImageIcon("../Original/src/images/Img_Bicycle.png")); // 버튼 경로
		img4_btn.setBounds(270, BP.getHeight() + 480, 200, 160); // 버튼 크기
		img4_btn.setBorderPainted(false); // 버튼 테두리 없앰
		img4_btn.setContentAreaFilled(false);
		add(img4_btn);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.black);
		g.drawLine(this.L1.getX(), this.L1.getY() + 50, this.L1.getX() + 420, this.L1.getY() + 50);
		// g.drawLine(150, 1, this.L1.getWidth()+100, this.L1.getHeight()+100);

	}

	class eventLisen extends FocusAdapter implements ActionListener {

		@Override
		public void focusGained(FocusEvent e) {
			JTextField j = (JTextField) e.getSource();
			if (j.getText().equals("검색어를 입력하세요")) {
				j.setText("");
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(Jb1)) {
				// 검색 기능
				if (Tf.getText().equals("검색어를 입력하세요"))
					return;
				Main_frame.itemName(Tf.getText());
				Tf.setText("검색어를 입력하세요");
			}

		}

	}

}
