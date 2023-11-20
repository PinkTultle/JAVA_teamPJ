package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import GUI.C_Component.MyFL;
import GUI.C_Component.MyJT;
import GUI.C_Component.MyKA_Num;

public class ProfilePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Baener_pane BP = new Baener_pane();
	private MyJT[] textFields = new MyJT[10];
	private RoundButton button;
	private RoundButton button_1;
	private RoundButton button_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JToggleButton tglbtnNewToggleButton;
	private JToggleButton tglbtnNewToggleButton_1;
	private ButtonGroup BG = new ButtonGroup();
	private BorderFactory bf;
	private MyFL FL = new MyFL();

	protected My_Page_Panel mpp;

	/**
	 * Create the panel.
	 */
	public ProfilePanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);
		setLayout(null);

		int[] loc = { 108, 168, 227, 286, 346, 405, 464 };
		Font slotFont = new Font("맑은 고딕", Font.PLAIN, 18);

		for (int i = 0; i < 10; i++) {
			int width = 420;
			if (i == 4)
				width = 244;
			if (i == 6 || i == 9)
				width = 332;
			textFields[i] = new MyJT();
			textFields[i].setFont(slotFont);
			textFields[i].addFocusListener(FL);
			textFields[i].setBounds((i > 6) ? 532 : 82, loc[i % 7], width, 50);
			add(textFields[i]);
		}

		textFields[4].addKeyListener(new MyKA_Num(8));

		JLabel lblNewLabel = new JLabel("프로필");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(401, 45, 215, 40);
		add(lblNewLabel);

		button = new RoundButton("회원탈퇴");
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		button.setBounds(616, 607, 136, 40);
		button.setForeground(new Color(255, 255, 255));
		button.setColorNormal(new Color(31, 78, 121));
		button.addActionListener(this);
		add(button);

		button_1 = new RoundButton("변경");
		button_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		button_1.setBounds(761, 607, 100, 40);
		button_1.addActionListener(this);
		add(button_1);

		button_2 = new RoundButton("취소");
		button_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		button_2.setBounds(870, 607, 100, 40);
		button_2.addActionListener(this);
		add(button_2);

		tglbtnNewToggleButton = new JToggleButton("남자");
		tglbtnNewToggleButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tglbtnNewToggleButton.setBounds(338, 345, 76, 50);
		tglbtnNewToggleButton.setForeground(new Color(0, 0, 0));
		tglbtnNewToggleButton.setBackground(new Color(255, 255, 255));
		tglbtnNewToggleButton.setFocusPainted(false);
		tglbtnNewToggleButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(tglbtnNewToggleButton);
		add(tglbtnNewToggleButton);

		tglbtnNewToggleButton_1 = new JToggleButton("여자");
		tglbtnNewToggleButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tglbtnNewToggleButton_1.setBounds(426, 345, 76, 50);
		tglbtnNewToggleButton_1.setForeground(new Color(0, 0, 0));
		tglbtnNewToggleButton_1.setBackground(new Color(255, 255, 255));
		tglbtnNewToggleButton_1.setFocusPainted(false);
		tglbtnNewToggleButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(tglbtnNewToggleButton_1);
		add(tglbtnNewToggleButton_1);

		btnNewButton = new JButton("인증");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(426, 464, 76, 50);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		add(btnNewButton);

		btnNewButton_1 = new JButton("인증");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_1.setBounds(876, 227, 76, 50);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		add(btnNewButton_1);

	}

	public ProfilePanel(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	public void setPanel(Vector<String> v) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			textFields[i].setInit(v.get(i));
		}
		textFields[0].disable();
		textFields[8].disable();
		textFields[9].disable();
	}
	/*
	 * textField 번호
	 * 1: ID / 비활성화
	 * 2: Password
	 * 3: 별명
	 * 4: 이름
	 * 5: 생년원일
	 * 6: 주소
	 * 7: 전화번호
	 * 8: e-mail
	 * 9: 은행 / 비활성화
	 * 10: 계좌번호 / 비활성화
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) { // 회원탈퇴 동작
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == button_1) { // 변경 동작
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == button_2) { // 취소 동작
			System.out.println(((JButton) (e.getSource())).getText());
			mpp.Open_My_Page();
		}

	}
}
