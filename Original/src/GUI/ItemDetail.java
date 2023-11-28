package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import JDBC.ItemDAO;
import JDBC.ItemDTO;
import JDBC.UserDAO;

public class ItemDetail extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RoundButton btnNewButton;
	private RoundButton btnNewButton_1;
	private RoundButton btnNewButton_2;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lbl[] = new JLabel[7];
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;

	private Font nF = new Font("맑은 고딕", Font.PLAIN, 14);
	private boolean isWriter;
	private int itemNum;

	public String Description;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ItemDetail(int itemNum) { // 글쓴이인지 확인하는 boolean 을 매개 변수로 받음
		/*
		 * public ItemDetail(boolean isWriter) throws SQLException { // 글쓴이인지 확인하는
		 * boolean 을 매개 변수로 받음 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		this.itemNum = itemNum;

		ItemDAO itemdao = new ItemDAO(), itemDAO = new ItemDAO();
		ItemDTO itemdto = null;
		try {
			itemdto = itemdao.itmedetail(itemNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 클릭한 물품번호 넘겨 받기

		isWriter = itemdto.getPerson().equals(UserDAO.user_cur);
		System.out.println(itemdto.getPerson());
		System.out.println(UserDAO.user_cur);

		setBounds(100, 100, 1050, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		lbl[0] = new JLabel(itemdto.getPerson());
		lbl[0].setHorizontalAlignment(SwingConstants.LEFT);
		lbl[0].setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		lbl[0].setBounds(66, 10, 247, 42);
		panel_1.add(lbl[0]);

		lbl[1] = new JLabel(itemdto.getItemname());
		lbl[1].setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl[1].setBounds(389, 10, 435, 42);
		panel_1.add(lbl[1]);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(104, 92, 354, 414);
		panel.add(panel_2);
		panel_2.setLayout(null);

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

		lblNewLabel = new JLabel(); // 물품 사진 라벨
		itemDAO.displayImage(itemdto.getImage(), lblNewLabel); // 사진 표시
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 329, 185);
		panel_2.add(lblNewLabel);

		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(new SwingCRLF().CRLF_ln("설	명\n" + itemdto.getExplanation()));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setFont(nF);
		lblNewLabel_1.setBounds(12, 205, 330, 199);
		panel_2.add(lblNewLabel_1);

		lbl[2] = new JLabel("물품 코드 입력");
		lbl[2].setText(Integer.toString(itemdto.getItemnumber()));
		lbl[2].setFont(nF);
		lbl[2].setBounds(154, 10, 250, 25);
		panel_3.add(lbl[2]);

		lbl[3] = new JLabel("모델명 입력");
		lbl[3].setText(itemdto.getModelname());
		lbl[3].setFont(nF);
		lbl[3].setBounds(154, 50, 250, 25);
		panel_3.add(lbl[3]);

		lbl[4] = new JLabel("렌트기한 입력");
		lbl[4].setText(itemdto.getRentdate());
		lbl[4].setFont(nF);
		lbl[4].setBounds(154, 90, 250, 25);
		panel_3.add(lbl[4]);

		lbl[5] = new JLabel("금액/보증금 입력");
		lbl[5].setText(itemdto.getRentalfee() + "/" + itemdto.getDeposit());
		lbl[5].setFont(nF);
		lbl[5].setBounds(154, 130, 250, 25);
		panel_3.add(lbl[5]);

		lbl[6] = new JLabel("전화번호");
		lbl[6].setText(itemdto.getPhonenumber());
		lbl[6].setFont(nF);
		lbl[6].setBounds(154, 170, 250, 25);
		panel_3.add(lbl[6]);
	}

	/*
	 * 타이틀 바 
	 * lbl[0] : 타이틀 바 별명 JLable
	 * lbl[1] : 타이틀 바 물품이름 JLable
	 * 메인 화면
	 * String Description : 설명 내용을 받는 String 
	 * lbl[2] : 물품코드 JLable 
	 * lbl[3] : 모델명 JLable 
	 * lbl[4] : 렌트기한 JLable 
	 * lbl[5] : 금액/보증금 JLable 
	 * lbl[6] : 전화번호 JLable 
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
				Report_Window rw = new Report_Window(lbl[2].getText(), lbl[1].getText());

			}
		} else if (e.getSource() == btnNewButton_2) { // 삭제/예약 버튼 동작
			/*
			if (isWriter) { // 삭제 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
				if (delete()) {
					// 삭제 확인한 경우 | DB 에서 DELETE 필요
					ItemDAO itemDAO = new ItemDAO();
					if (itemDAO.deleteItem(itemNum)) {
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "삭제할 수 없습니다.");
					}
				}
			} else { // 예약 버튼 동작
				System.out.println(((JButton) (e.getSource())).getText());
			}*/
		}
	}

	boolean delete() {
		int closeProfile = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
		if (closeProfile == JOptionPane.NO_OPTION)
			return false;
		return true;
	}

}
