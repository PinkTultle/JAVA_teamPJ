package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import GUI.C_Component.MyJT;
import GUI.C_Component.MyJT_TEL;
import GUI.C_Component.MyKA_Num;
import GUI.C_Component.MyPT;
import JDBC.UserDAO;
import JDBC.UserDTO;

public class ProfilePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	Baener_pane BP = new Baener_pane();
	private MyJT[] textFields = new MyJT[7];
	private MyPT passwordField;
	private MyJT_TEL[] textFields_TEL = new MyJT_TEL[3];
	private RoundButton button;
	private RoundButton button_1;
	private RoundButton button_2;
	private JButton btnNewButton;
	private JToggleButton tglbtnNewToggleButton;
	private JToggleButton tglbtnNewToggleButton_1;
	private ButtonGroup BG = new ButtonGroup();
	private BorderFactory bf;

	protected My_Page_Panel mpp;
	protected boolean mode = false; // true: 수정 | false: 일반

	/**
	 * Create the panel.
	 */
	public ProfilePanel() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1034, 700);
		setLayout(null);

		int[] loc = { 105, 217, 273, 329, 441, 497 };
		Font slotFont = new Font("맑은 고딕", Font.PLAIN, 18);

		for (int i = 0; i < 6; i++) {
			int width = 420;
			if (i == 3)
				width = 244;
			textFields[i] = new MyJT();
			textFields[i].setFont(slotFont);
			textFields[i].setBounds(307, loc[i], width, 47);
			add(textFields[i]);
		}

		textFields[3].addKeyListener(new MyKA_Num(8));

		passwordField = new MyPT("Password");
		passwordField.setBounds(307, 161, 420, 47);
		add(passwordField);

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
		tglbtnNewToggleButton.setBounds(563, 329, 76, 47);
		tglbtnNewToggleButton.setForeground(new Color(0, 0, 0));
		tglbtnNewToggleButton.setBackground(new Color(255, 255, 255));
		tglbtnNewToggleButton.setFocusPainted(false);
		tglbtnNewToggleButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(tglbtnNewToggleButton);
		add(tglbtnNewToggleButton);

		tglbtnNewToggleButton_1 = new JToggleButton("여자");
		tglbtnNewToggleButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tglbtnNewToggleButton_1.setBounds(651, 329, 76, 47);
		tglbtnNewToggleButton_1.setForeground(new Color(0, 0, 0));
		tglbtnNewToggleButton_1.setBackground(new Color(255, 255, 255));
		tglbtnNewToggleButton_1.setFocusPainted(false);
		tglbtnNewToggleButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(tglbtnNewToggleButton_1);
		add(tglbtnNewToggleButton_1);

		btnNewButton = new JButton("인증");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton.setBounds(651, 384, 76, 47);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		add(btnNewButton);

		int[] loc_TEL = { 307, 416, 544 };

		KeyAdapter KA = new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				JTextField jt = (JTextField) k.getSource();
				if ("1234567890".indexOf(k.getKeyChar()) == -1) { // 숫자로 입력 제한
					k.consume();
				}
				if (jt.getText().length() == 3 && "1234567890".indexOf(k.getKeyChar()) != -1) { // 포커스 이동
					if (k.getSource() == textFields_TEL[1]) {
						textFields_TEL[2].requestFocus();
					}
				}
				if (jt.getText().length() > 3) { // 글자 수 제한
					k.consume();
				}
			}
		};

		for (int i = 0; i < 3; i++) {
			textFields_TEL[i] = new MyJT_TEL("");
			textFields_TEL[i].setHorizontalAlignment(SwingConstants.CENTER);
			textFields_TEL[i].setFont(slotFont);
			textFields_TEL[i].setBounds(loc_TEL[i], 384, (i == 0) ? 76 : 95, 47);
			textFields_TEL[i].addKeyListener(KA);
			add(textFields_TEL[i]);
		}

		textFields_TEL[0].setText("010");

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(383, 384, 33, 50);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(511, 384, 33, 50);
		add(lblNewLabel_1_1);

		setPanel();
	}

	public ProfilePanel(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	public void setPanel() {
		try {
			UserDAO userDAO = new UserDAO();
			UserDTO data = userDAO.userSelect(UserDAO.user_cur);
			passwordField.clear();
			textFields[0].setInit(data.getId());
			textFields[1].setInit(data.getNickname());
			textFields[2].setInit(data.getName());
			textFields[3].setInit(Integer.toString(data.getBirth()));
			textFields[4].setInit(data.getAddress());
			textFields[5].setInit(data.getEmail());
			String temp = Integer.toString(data.getTel());
			textFields_TEL[1].setInit(temp.substring(2, 6));
			textFields_TEL[2].setInit(temp.substring(6, 10));

			if (data.getGender().equals("남성")) {
				tglbtnNewToggleButton.setSelected(true);
			} else {
				tglbtnNewToggleButton_1.setSelected(false);
			}

			textFields[0].setEnabled(false);
			textFields_TEL[0].setEnabled(false);
			setEditable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		textFields[0].setEnabled(false);
		textFields_TEL[0].setEnabled(false);
		setEditable(false);
	}
	/*
	 * textField 번호 0: ID / 비활성화 1: Password 2: 별명 3: 이름 4: 생년원일 5: 주소 6: e-mail 7:
	 * 은행 / 비활성화 8: 계좌번호 / 비활성화
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) { // 회원탈퇴 동작
			int sel = JOptionPane.showConfirmDialog(null, "계정을 삭제하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (sel == JOptionPane.YES_OPTION) {
				UserDAO userDAO = new UserDAO();
				int result = userDAO.userDelete();
				if (result == 0) {
					LoginGUI.loginFrame.setVisible(true);
					Main_frame.mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Main_frame.mainFrame.dispose();
				} else {

				}
			}
		} else if (e.getSource() == button_1) { // 변경 동작
			changeMode(true);
		} else if (e.getSource() == button_2) { // 취소 동작
			if (mpp.Close_profile())
				mpp.Open_My_Page();
		}

	}

	void setEditable(boolean v) {
		for (int i = 1; i < 6; i++) {
			textFields[i].setEnabled(v);
		}
		for (int i = 1; i < 3; i++) {
			textFields_TEL[i].setEnabled(v);
		}
		passwordField.setEnabled(v);
		tglbtnNewToggleButton.setEnabled(v);
		tglbtnNewToggleButton_1.setEnabled(v);
		btnNewButton.setEnabled(v);
	}

	void changeMode(boolean write) {
		if (mode) { // write 가 true 인 경우 DB에 작성 필요
			mode = false;
			setEditable(false);
			button.setVisible(true);
			update();
			if (write) {
			}
		} else {
			mode = true;
			setEditable(true);
			button.setVisible(false);
		}
	}

	public boolean getMode() {
		return mode;
	}

	void update() {
		try {
			UserDAO userDAO = new UserDAO();
			String[] data = new String[8];
			if (!tglbtnNewToggleButton.isSelected() && !tglbtnNewToggleButton_1.isSelected()) {
				data[7] = null;
			} else if (tglbtnNewToggleButton.isSelected()) {
				data[7] = "남성";
			} else {
				data[7] = "여성";
			}
			for (int i = 1; i < 6; i++) {
				if (i == 5) {
					// 전화번호 처리
					if (!textFields_TEL[1].isTyped && !textFields_TEL[2].isTyped) {
						data[i] = null;
					} else {
						data[i] = "010-" + textFields_TEL[1].getText() + "-" + textFields_TEL[2].getText();
						for (int j = 1; j < 3; j++) {
							textFields_TEL[j].setInit(textFields_TEL[j].getText());
							textFields_TEL[j].isTyped = false;
						}
					}
				} else if (i == 3) {
					// 생년월일 처리
					if (!textFields[i].isTyped) {
						data[i] = null;
					} else {
						String bir = textFields[i].getString();
						data[i] = bir.substring(0, 4) + "-" + bir.substring(4, 6) + "-" + bir.substring(6, 8);
						textFields[i].setInit(textFields[i].getText());
						textFields[i].isTyped = false;
					}

				} else {
					if (!textFields[i].isTyped) {
						data[i] = null;
					} else {
						data[i] = textFields[i].getText();
						textFields[i].setInit(textFields[i].getText());
						textFields[i].isTyped = false;
					}
				}
			}
			if (passwordField.isTyped) {
				data[0] = passwordField.getText();
				passwordField.clear();
			}
			userDAO.userUpdate(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void delete() {

	}
}
