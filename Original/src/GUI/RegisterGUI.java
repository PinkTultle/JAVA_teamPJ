package GUI;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import GUI.C_Component.MyFL;
import GUI.C_Component.MyJT;
import GUI.C_Component.MyJT_TEL;
import GUI.C_Component.MyKA_Num;
import GUI.C_Component.MyPT;

// 주석 및 추가 작업 필요
public class RegisterGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT textField;
	private MyPT textField_1;
	private MyJT textField_2;
	private MyJT textField_3;
	private MyJT textField_4;
	private MyJT textField_5;
	private MyJT textField_6;

	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;

	private JToggleButton btnNewButton;
	private JToggleButton btnNewButton_1;
	private ButtonGroup BG = new ButtonGroup();

	private BorderFactory bf;
	private JTextField removefirstfocus;

	private MyJT_TEL textField_TEL[] = new MyJT_TEL[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		MyFL FL = new MyFL();

		KeyAdapter KA = new KeyAdapter() {
			public void keyTyped(KeyEvent k) {
				JTextField jt = (JTextField) k.getSource();
				if ("1234567890".indexOf(k.getKeyChar()) == -1) { // 숫자로 입력 제한
					k.consume();
				}
				if (jt.getText().length() == 3 && "1234567890".indexOf(k.getKeyChar()) != -1) { // 포커스 이동
					if (k.getSource() == textField_TEL[0]) {
						textField_TEL[1].requestFocus();
					} else {
						removefirstfocus.requestFocus();
					}
				}
				if (jt.getText().length() > 3) { // 글자 수 제한
					k.consume();
				}
			}
		};

		Font slotFont = new Font("맑은 고딕", Font.PLAIN, 15);

		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 34));
		lblNewLabel.setBounds(375, 10, 298, 66);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(292, 73, 470, 474);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBorder(new LineBorder(new Color(255, 255, 255), 25, true));
		panel_1.setBounds(10, 10, 450, 454);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(12, 10, 426, 434);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		textField = new MyJT("아이디");
		textField.setFont(slotFont);
		textField.setBounds(28, 10, 282, 38);
		textField.addFocusListener(FL);
		panel_2.add(textField);
		textField.setColumns(10);

		textField_1 = new MyPT("비밀번호");
		textField_1.setFont(slotFont);
		textField_1.setColumns(10);
		textField_1.setBounds(28, 58, 360, 38);
		textField_1.addFocusListener(FL);
		panel_2.add(textField_1);

		textField_2 = new MyJT("별명");
		textField_2.setFont(slotFont);
		textField_2.setColumns(10);
		textField_2.setBounds(28, 106, 360, 38);
		textField_2.addFocusListener(FL);
		panel_2.add(textField_2);

		textField_3 = new MyJT("이름");
		textField_3.setFont(slotFont);
		textField_3.setColumns(10);
		textField_3.setBounds(28, 154, 360, 38);
		textField_3.addFocusListener(FL);
		panel_2.add(textField_3);

		textField_4 = new MyJT("생년월일 8자리");
		textField_4.setFont(slotFont);
		textField_4.setColumns(10);
		textField_4.setBounds(28, 202, 184, 38);
		textField_4.addFocusListener(FL);

		textField_4.addKeyListener(new MyKA_Num(8));

		panel_2.add(textField_4);

		textField_5 = new MyJT("주소");
		textField_5.setFont(slotFont);
		textField_5.setText("주소");
		textField_5.setColumns(10);
		textField_5.setBounds(28, 250, 282, 38);
		textField_5.addFocusListener(FL);
		panel_2.add(textField_5);

		textField_6 = new MyJT("이메일");
		textField_6.setFont(slotFont);
		textField_6.setText("이메일");
		textField_6.setColumns(10);
		textField_6.setBounds(28, 346, 360, 38);
		textField_6.addFocusListener(FL);
		panel_2.add(textField_6);

		btnNewButton = new JToggleButton("남자");
		btnNewButton.setFont(slotFont);
		btnNewButton.setBounds(224, 202, 76, 38);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(btnNewButton);
		panel_2.add(btnNewButton);

		btnNewButton_1 = new JToggleButton("여자");
		btnNewButton_1.setFont(slotFont);
		btnNewButton_1.setBounds(312, 202, 76, 38);
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		BG.add(btnNewButton_1);
		panel_2.add(btnNewButton_1);

		btnNewButton_2 = new JButton("검색");
		btnNewButton_2.setFont(slotFont);
		btnNewButton_2.setBounds(322, 250, 66, 38);
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_2.addActionListener(this);
		panel_2.add(btnNewButton_2);

		btnNewButton_3 = new JButton("인증");
		btnNewButton_3.setFont(slotFont);
		btnNewButton_3.setBounds(322, 298, 66, 38);
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_3.addActionListener(this);
		panel_2.add(btnNewButton_3);

		btnNewButton_4 = new JButton("가입");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setBorder(bf.createEmptyBorder());
		btnNewButton_4.setBackground(new Color(31, 66, 121));
		btnNewButton_4.setBounds(332, 395, 75, 30);
		btnNewButton_4.addActionListener(this);
		panel_2.add(btnNewButton_4);

		btnNewButton_5 = new JButton("중복");
		btnNewButton_5.setForeground(Color.BLACK);
		btnNewButton_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setBorder(bf.createLineBorder(new Color(128, 128, 128)));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(322, 10, 66, 38);
		btnNewButton_5.addActionListener(this);
		panel_2.add(btnNewButton_5);

		JTextField textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setFont(slotFont);
		textField_8.setBounds(28, 298, 60, 38);
		textField_8.setText("010");
		textField_8.setHorizontalAlignment(JTextField.CENTER);
		panel_2.add(textField_8);

		textField_TEL[0] = new MyJT_TEL("");
		textField_TEL[0].setFont(slotFont);
		textField_TEL[0].setColumns(10);
		textField_TEL[0].setBounds(117, 298, 82, 38);
		textField_TEL[0].addFocusListener(FL);
		textField_TEL[0].addKeyListener(KA);
		panel_2.add(textField_TEL[0]);

		textField_TEL[1] = new MyJT_TEL("");
		textField_TEL[1].setFont(slotFont);
		textField_TEL[1].setColumns(10);
		textField_TEL[1].setBounds(228, 298, 82, 38);
		textField_TEL[1].addFocusListener(FL);
		textField_TEL[1].addKeyListener(KA);
		panel_2.add(textField_TEL[1]);

		JLabel lblNewLabel_1 = new JLabel("-");
		lblNewLabel_1.setFont(slotFont);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(93, 312, 19, 15);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("-");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(slotFont);
		lblNewLabel_1_1.setBounds(204, 312, 19, 15);
		panel_2.add(lblNewLabel_1_1);

		removefirstfocus = new JTextField();
		removefirstfocus.setBounds(-200, 10, 116, 21);
		panel_2.add(removefirstfocus);
		removefirstfocus.setColumns(10);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton_2) {
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == btnNewButton_3) {
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == btnNewButton_4) {
			System.out.println(((JButton) (e.getSource())).getText());
		} else if (e.getSource() == btnNewButton_5) {
			System.out.println(((JButton) (e.getSource())).getText());
		}
	}

}
