package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUI.C_Component.itemSlot_history;

public class RentHistory extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel BP = new Baener_pane();
	private RoundButton btnNewButton;
	private RoundButton btnNewButton_1;
	private RoundButton btnNewButton_2;
	private itemSlot_history is;
	private JLabel[] tableHeader = new JLabel[6];

	protected My_Page_Panel mpp;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public RentHistory() {

		setLayout(null);

		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1050, 700);

		JLabel lblNewLabel = new JLabel("렌트 내역");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 29, 162, 62);
		add(lblNewLabel);

		is = new itemSlot_history(38, 140, 960, 425);
		add(is);

		btnNewButton = new RoundButton("연장 요청");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(671, 600, 104, 33);
		add(btnNewButton);

		btnNewButton_1 = new RoundButton("반납");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(787, 600, 104, 33);
		add(btnNewButton_1);

		btnNewButton_2 = new RoundButton("뒤로");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setColorNormal(new Color(31, 78, 121));
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(903, 600, 104, 33);
		add(btnNewButton_2);

		String[] headerText = { "물품코드", "거래자", "물품명", "남은 기간", "이용 상태", "반납/연장 상태" };
		int[] xLoc = { 55, 175, 425, 665, 775, 885 };
		Font hFont = new Font("맑은 고딕", Font.PLAIN, 16);

		for (int i = 0; i < 6; i++) {
			tableHeader[i] = new JLabel(headerText[i]);
			tableHeader[i].setFont(hFont);
			tableHeader[i].setHorizontalAlignment(SwingConstants.CENTER);
			tableHeader[i].setBounds(xLoc[i], 105, 115, 40);
			add(tableHeader[i]);
		}

		is.setItem();
	}

	public RentHistory(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNewButton) { // 연장 요청 동작
			System.out.println(((JButton) (e.getSource())).getText());
			if (is.getSelectItemNum() != -1) {
				// 거래 번호 추가 필요
				JFrame eO = new extendOffer(1);
				eO.setVisible(true);
			}

		} else if (e.getSource() == btnNewButton_1) { // 반납 동작
			System.out.println(((JButton) (e.getSource())).getText());
			returnItem();
			if (is.getSelectItemNum() != -1)
				System.out.println("물품 번호: " + is.getSelectItemNum());
		} else if (e.getSource() == btnNewButton_2) { // 뒤로 동작
			System.out.println(((JButton) (e.getSource())).getText());
			mpp.Open_My_Page();
		}
	}

	int returnItem() {
		if (is.getSelectItemNum() != -1) {
			int closeProfile = JOptionPane.showConfirmDialog(null, "반납하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
			if (closeProfile == JOptionPane.YES_OPTION) {
				System.out.println("물품 반납 메소드 필요");
				return 0;
			}
		}
		return 1;
	}

	public void refresh() {
		is.setItem();
	}
}
