package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuBar extends JPanel implements ActionListener {

	public JButton MenuButton;
	private String[] tagList = { "홈", "목록", "신청관리", "마이페이지" };
	private int length = 520, Bnum = (length - 10) / 4;

	public MenuBar() {

		setBounds(530, 120, length, 30);
		setBackground(Color.white);

		// 버튼 왼쪽부터 정렬 및 버튼 사이 여백 없에기
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		// 버튼 1부터 4까지 설정
		for (int i = 0; i < 4; i++) {
			MenuButton = new JButton(tagList[i]);
			MenuButton.setPreferredSize(new Dimension(Bnum, 30));
			MenuButton.setBackground(new Color(59, 56, 56));
			MenuButton.setHorizontalAlignment(SwingConstants.CENTER);
			MenuButton.setVerticalAlignment(SwingConstants.CENTER);
			add(MenuButton);
			MenuButton.setBorderPainted(false);
			MenuButton.setFocusPainted(false);
			// MenuButton.setContentAreaFilled(false);
			MenuButton.addActionListener(this);
			MenuButton.setFont(new Font("맑은고딕", Font.BOLD, 15));
			MenuButton.setForeground(Color.white);
		}

	}

	// 메인 프레임의 버튼 바 클릭 이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		// 버튼의 TEXT를 가져오기위해 버튼 객체로 변환
		JButton b = (JButton) e.getSource();

		// 버튼 객체의 TEXT를 불러와 Main_frame.java의 main(string text) 함수 호출
		Main_frame.Changepane(b.getText());

	}
}
