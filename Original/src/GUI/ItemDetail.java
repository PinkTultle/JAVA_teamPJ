package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	private Font nF = new Font("맑은 고딕", Font.PLAIN, 14);
	private boolean isWriter;
	private int itemNum;
	private ItemDTO itemdto = null;

	public String Description;
	public boolean isOpen = true;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ItemDetail(int itemNum) { // 글쓴이인지 확인하는 boolean 을 매개 변수로 받음
		this.itemNum = itemNum;

		ItemDAO itemdao = new ItemDAO(), itemDAO = new ItemDAO();
		itemdto = null;
		itemdto = itemdao.itemdetail(itemNum);

		if (itemdto.getState().equals("삭제")) {
			JOptionPane.showMessageDialog(null, "삭제된 게시글입니다.");
			dispose();
		} else {

			isWriter = itemdto.getPerson().equals(UserDAO.user_cur);

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

			btnNewButton_1 = new RoundButton("신고");
			btnNewButton_1.setVisible(false);
			if (!isWriter) {
				btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
				btnNewButton_1.setForeground(new Color(255, 255, 255));
				btnNewButton_1.setColorNormal(new Color(31, 78, 121));
				btnNewButton_1.setVisible(true);
			}
			btnNewButton_1.setBounds(813, 466, 75, 40);
			btnNewButton_1.addActionListener(this);
			panel.add(btnNewButton_1);

			btnNewButton_2 = new RoundButton("삭제", Color.black);
			btnNewButton_2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
			String state = itemdto.getState();
			if (!isWriter && state.equals("대여가능"))
				btnNewButton_2.setText("대여");
			else if (!isWriter) {
				btnNewButton_2.setVisible(false);
			}
			int xLoc = 726;
			if (isWriter)
				xLoc = 813;
			btnNewButton_2.setBounds(xLoc, 466, 75, 40);
			btnNewButton_2.addActionListener(this);
			panel.add(btnNewButton_2);

			panel_1 = new JPanel();
			panel_1.setBackground(new Color(255, 255, 255));
			panel_1.setBounds(104, 20, 836, 62);
			panel_1.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(200, 200, 200)));
			panel.add(panel_1);
			panel_1.setLayout(null);

			ImageIcon user_img = new ImageIcon(ItemDetail.class.getResource("../COMP_IMG/user.png"));
			Image img = user_img.getImage();
			user_img.setImage(img.getScaledInstance(35, 35, Image.SCALE_SMOOTH));

			JLabel lblNewLabel_4 = new JLabel(user_img);
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setBounds(18, 16, 35, 35);
			panel_1.add(lblNewLabel_4);

			lbl[0] = new JLabel(itemdto.getNickname());
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
			String path = "../COMP_IMG/Img_";
			switch (itemdto.getCategory()) {
			case "유아용품":
				path += "Baby_Products";
				break;
			case "도서":
				path += "Book";
				break;
			case "기타":
				path += "Box";
				break;
			case "요청":
				path += "chat";
				break;
			case "뷰티":
				path += "Cosmetics";
				break;
			case "전자기기":
				path += "Electronics";
				break;
			case "패션잡화":
				path += "Fashion";
				break;
			case "가전/생활":
				path += "Fridge";
				break;
			case "가구/인테리어":
				path += "Furniture";
				break;
			case "취미/게임":
				path += "Game";
				break;
			case "동물용품":
				path += "Petfood";
				break;
			case "스포츠/레져":
				path += "Sports";
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + itemdto);
			}
			path += ".png";
			ImageIcon img_p = new ImageIcon(ItemDetail.class.getResource(path));
			img = img_p.getImage();
			img_p.setImage(img.getScaledInstance(185, 185, Image.SCALE_SMOOTH));
			lblNewLabel.setIcon(img_p);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(12, 10, 185, 185);
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
			lbl[4].setText(itemdto.getRentdate().substring(0, 10));
			lbl[4].setFont(nF);
			lbl[4].setBounds(154, 90, 250, 25);
			panel_3.add(lbl[4]);

			lbl[5] = new JLabel("금액/보증금 입력");
			lbl[5].setText(itemdto.getRentalfee() + "/" + itemdto.getDeposit());
			lbl[5].setFont(nF);
			lbl[5].setBounds(154, 130, 250, 25);
			panel_3.add(lbl[5]);

			lbl[6] = new JLabel("전화번호");
			if (!itemdto.getSafeTEL()) {
				lbl[6].setText(itemdto.getPhonenumber());
			} else {
				lbl[6].setText("010-XXXX-XXXX");
			}
			lbl[6].setFont(nF);
			lbl[6].setBounds(154, 170, 250, 25);
			panel_3.add(lbl[6]);
		}
	}

	/*
	 * 타이틀 바 lbl[0] : 타이틀 바 별명 JLable lbl[1] : 타이틀 바 물품이름 JLable 메인 화면 String
	 * Description : 설명 내용을 받는 String lbl[2] : 물품코드 JLable lbl[3] : 모델명 JLable
	 * lbl[4] : 렌트기한 JLable lbl[5] : 금액/보증금 JLable lbl[6] : 전화번호 JLable
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) { // 뒤로 버튼 동작
			dispose();
		} else if (e.getSource() == btnNewButton_1) { // 수정/신고 버튼 동작
			if (isWriter) { // 수정 버튼 동작
			} else { // 신고 버튼 동작
				Report_Window_Write rw = new Report_Window_Write(lbl[2].getText(), lbl[1].getText());

			}
		} else if (e.getSource() == btnNewButton_2) { // 삭제/예약 버튼 동작
			if (isWriter) { // 삭제 버튼 동작
				if (delete()) {
					// 삭제 확인한 경우 | DB 에서 DELETE 필요
					ItemDAO itemDAO = new ItemDAO();
					if (itemDAO.deleteItem(itemNum)) {
						JOptionPane.showMessageDialog(null, "삭제했습니다.");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "삭제할 수 없습니다.");
					}
				}
			} else { // 예약 버튼 동작
				sending_offer so = new sending_offer(itemdto);
				so.setVisible(true);
			}
		}
	}

	boolean delete() {
		int closeProfile = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
		if (closeProfile == JOptionPane.NO_OPTION)
			return false;
		return true;
	}

}
