package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ItemDetail extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundButton btnNewButton;
	private RoundButton btnNewButton_1;
	private RoundButton btnNewButton_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;

	private Font nF = new Font("맑은 고딕", Font.PLAIN, 14);
	private boolean isWriter;

	public String Description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ItemDetail frame = new ItemDetail(false);
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
	public ItemDetail(boolean isWriter) { // 글쓴이인지 확인하는 boolean 을 매개 변수로 받음
		setBounds(100, 100, 1050, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.isWriter = isWriter;

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1034, 531);
		contentPane.add(panel);
		panel.setLayout(null);

		btnNewButton = new RoundButton("뒤로");
		btnNewButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		btnNewButton.setBounds(900, 466, 75, 40);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setColorNormal(new Color(31, 78, 121));
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);

		btnNewButton_1 = new RoundButton("수정");
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		if (!isWriter) {
			btnNewButton_1.setText("신고");
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setColorNormal(new Color(31, 78, 121));
		}
		btnNewButton_1.setBounds(813, 466, 75, 40);
		btnNewButton_1.addActionListener(this);
		panel.add(btnNewButton_1);

		btnNewButton_2 = new RoundButton("삭제");
		btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		if (!isWriter)
			btnNewButton_2.setText("예약");
		btnNewButton_2.setBounds(726, 466, 75, 40);
		btnNewButton_2.addActionListener(this);
		panel.add(btnNewButton_2);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(104, 20, 836, 62);
		panel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(200, 200, 200)));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("image");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 10, 42, 42);
		panel_1.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("별명");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(66, 10, 247, 42);
		panel_1.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("물품 이름");
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_6.setBounds(389, 10, 435, 42);
		panel_1.add(lblNewLabel_6);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(104, 92, 354, 414);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("image");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 329, 185);
		panel_2.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(new SwingCRLF().CRLF_ln("설	명\n" + Description));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(nF);
		lblNewLabel_1.setBounds(12, 205, 330, 199);
		panel_2.add(lblNewLabel_1);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(510, 92, 430, 220);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("물 품 코 드");
		lblNewLabel_2.setFont(nF);
		lblNewLabel_2.setBounds(12, 10, 105, 25);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("모 델 명");
		lblNewLabel_2_1.setFont(nF);
		lblNewLabel_2_1.setBounds(12, 50, 105, 25);
		panel_3.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("렌 트 기 한");
		lblNewLabel_2_2.setFont(nF);
		lblNewLabel_2_2.setBounds(12, 90, 105, 25);
		panel_3.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("금액(일)/보증금");
		lblNewLabel_2_3.setFont(nF);
		lblNewLabel_2_3.setBounds(12, 130, 105, 25);
		panel_3.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("전 화 번 호");
		lblNewLabel_2_4.setFont(nF);
		lblNewLabel_2_4.setBounds(12, 170, 105, 25);
		panel_3.add(lblNewLabel_2_4);

		lblNewLabel_3 = new JLabel("물품 코드 입력");
		lblNewLabel_3.setFont(nF);
		lblNewLabel_3.setBounds(154, 10, 250, 25);
		panel_3.add(lblNewLabel_3);

		lblNewLabel_3_1 = new JLabel("모델명 입력");
		lblNewLabel_3_1.setFont(nF);
		lblNewLabel_3_1.setBounds(154, 50, 250, 25);
		panel_3.add(lblNewLabel_3_1);

		lblNewLabel_3_2 = new JLabel("렌트기한 입력");
		lblNewLabel_3_2.setFont(nF);
		lblNewLabel_3_2.setBounds(154, 90, 250, 25);
		panel_3.add(lblNewLabel_3_2);

		lblNewLabel_3_3 = new JLabel("금액/보증금 입력");
		lblNewLabel_3_3.setFont(nF);
		lblNewLabel_3_3.setBounds(154, 130, 250, 25);
		panel_3.add(lblNewLabel_3_3);

		lblNewLabel_3_4 = new JLabel("전화번호");
		lblNewLabel_3_4.setFont(nF);
		lblNewLabel_3_4.setBounds(154, 170, 250, 25);
		panel_3.add(lblNewLabel_3_4);
	}

	public void setItem(String testTitle) { // 패널안의 내용을 바꾸는 메소드
		lblNewLabel_5.setText(testTitle);
		lblNewLabel_6.setText(testTitle);
		lblNewLabel_3.setText(testTitle);
	}
	/*
	 * 타이틀 바 
	 * lblNewLabel_5 : 타이틀 바 별명 JLable 
	 * lblNewLabel_6 : 타이틀 바 물품이름 JLable 
	 * 메인 화면
	 * String Description : 설명 내용을 받는 String 
	 * lblNewLabel : 메인 화면 물품 이미지 JLable
	 * lblNewLabel_3 : 물품코드 JLable 
	 * lblNewLabel_3_1 : 모델명 JLable 
	 * lblNewLabel_3_2 : 렌트기한 JLable 
	 * lblNewLable_3_3 : 금액/보증금 JLable 
	 * lblNewLabel_3_4 : 전화번호 JLable
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) { // 뒤로 버튼 동작
			System.out.println(((JButton) (e.getSource())).getText());
			dispose();
		} else if (e.getSource() == btnNewButton_1) { // 수정/신고 버튼 동작
			if (isWriter) { // 수정 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
			} else { // 신고 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
			}
		} else if (e.getSource() == btnNewButton_2) { // 삭제/예약 버튼 동작
			if (isWriter) { // 삭제 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
			} else { // 예약 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
			}
		}
	}

}
