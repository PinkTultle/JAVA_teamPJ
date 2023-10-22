package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import GUI.RegisterGUI.MyFL_T;
import GUI.RegisterGUI.MyJT;

public class ListPanel extends JFrame implements AdjustmentListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MyJT textField;
	private JPanel panel_2; // 아이템 목록
	private JScrollBar scrollBar;
	private JPanel panel_5;
	private itemSlot is[]; // 아이템 목록 클래스
	private int lastLoc = -1; // 스크롤 확인용 변수

	private int itemCount = 40; // 아이템 갯수 | 테스트용 값 : 40

	String item[] = { "", "asdf", "asdf", "asdf", "asdf", "asdf" }; // 테스트용

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPanel frame = new ListPanel();
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
	public ListPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 521);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 23, 1034, 420);
		panel.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				if (e.getWheelRotation() < 0) { // scrollBar.setvalue(scollBar.getValue()-10) 도 가능함 | 페이지 기능과 문제가 있는지는
												// 확인되지 않음
					for (int i = 0; i < 10; i++) {
						scrollBar.setValue(scrollBar.getValue() - 1);
					}

				} else {
					for (int i = 0; i < 10; i++) {
						scrollBar.setValue(scrollBar.getValue() + 1);
					}
				}
			}
		});

		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "전자기기", "가구/인테리어", "유아용품", "뷰티/패션잡화",
				"가전/생활/주방", "스포츠/레저", "취미/게임/도서", "동물용품", "렌트 원해요" }));
		comboBox.setBounds(62, 46, 110, 35);
		panel.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "전체", "대여가능", "예약중", "대여중" }));
		comboBox_1.setBounds(184, 46, 110, 35);
		panel.add(comboBox_1);

		textField = new MyJT("검색어를 입력하세요");
		textField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textField.addFocusListener(new MyFL_T(textField));
		textField.setBounds(316, 46, 200, 35);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(528, 46, 33, 35);
		panel.add(btnNewButton);

		RoundButton btnNewButton_1 = new RoundButton("상품 등록하기");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btnNewButton_1.setColorNormal(new Color(41, 76, 121));
		btnNewButton_1.setBounds(842, 31, 154, 45);
		panel.add(btnNewButton_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(200, 150, 600, 240);
		panel.add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 600, 720);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		is = new itemSlot[12];

		for (int i = 0; i < 12; i++) {
			item[0] = String.valueOf(i + 1);
			is[i] = new itemSlot(i);
			is[i].setItem(item);
			panel_2.add(is[i].getPanel());
		}

		scrollBar = new JScrollBar();
		scrollBar.setMaximum((itemCount - 4) * 60);
		scrollBar.addAdjustmentListener(this);
		scrollBar.setBounds(802, 150, 17, 249);
		panel.add(scrollBar);

		panel_5 = new JPanel();
		panel_5.setForeground(Color.BLACK);
		panel_5.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(200, 200, 200)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(200, 95, 600, 54);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel = new JLabel("물품코드");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 23, 63, 21);
		panel_5.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("카테고리");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(103, 23, 63, 21);
		panel_5.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("물품명");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(240, 23, 52, 21);
		panel_5.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("렌트기한");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(435, 23, 68, 21);
		panel_5.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("등록자");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(370, 23, 48, 21);
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("처리상태");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(510, 23, 78, 21);
		panel_5.add(lblNewLabel_5);
	}

	class itemSlot { // 별도의 패널과 레이블들을 이용해서 아이템 슬롯을 하나의 객체로 만들었음
		JPanel panel;
		JLabel jlabel[];
		int w[] = { 60, 60, 162, 60, 60, 60 }, h = 30, x[] = { 12, 103, 185, 366, 435, 517 }, y = 15; // 위치 값,

		public itemSlot(int idx) {
			// TODO Auto-generated constructor stub
			panel = new JPanel();
			jlabel = new JLabel[6];
			panel.setBounds(0, idx * 60, 600, 60);
			panel.setBackground(new Color(255, 255, 255));
			panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(200, 200, 200)));
			panel.setLayout(null);
			for (int i = 0; i < 6; i++) {
				jlabel[i] = new JLabel();
				jlabel[i].setBounds(x[i], y, w[i], h);
				panel.add(jlabel[i]);
			}
			panel.addMouseListener(new ML_IS(panel)); // 마우스 클릭을 위한 리스너 추가 | 기능 구현은 없음
		}

		public JPanel getPanel() { // 다른 패널에 추가하기 위해 현재 클래스의 패널을 반환함
			return panel;
		}

		public void setItem(String item[]) { // 스트링 배열을 이용해서 초기화 함
			try {
				panel.setToolTipText(item[0]); // 물품 ID 저장 및 클릭 이벤트용
				for (int i = 0; i < 6; i++) {
					jlabel[i].setText(item[i]);
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		}

		public int getItemNum() { // 아이템 넘버를 반환 (물품코드)
			return Integer.parseInt(jlabel[0].getText());
		}
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) { // 순간이동 값 이동 처리 필요
		// TODO Auto-generated method stub
		int Y = -scrollBar.getValue() % 480; // 전체 페이지의 크기 60*12 이지만 한 화면의 4개의 항목을 표시 함으로 480 이 크기가 됨
		// 스크롤바 사용시 값이 일정하게 변하지 않을 수 있음 따라서 범위로 설정
		if (Y > -20 && lastLoc < -460) { // 페이지 다운
			pageChange(true);
			System.out.println("page down");
		} else if (Y < -460 && lastLoc > -20) { // 페이지 업
			pageChange(false);
			System.out.println("page up");
		}
		panel_2.setLocation(panel_2.getX(), Y);
		lastLoc = Y; // 마지막 위치 값 저장
	}

	class ML_IS implements MouseListener {
		JPanel panel;

		public ML_IS(JPanel panel) {
			// TODO Auto-generated constructor stub
			this.panel = panel;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.print(panel.getToolTipText()); // 테스트용 코드 데이터 연결 시 변경 필요
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}
	}

	// 페이지 변경용 메소드
	void pageChange(boolean down) {
		int startNum;
		if (down) { // 페이지 다운
			startNum = is[11].getItemNum() - 3;
		} else { // 페이지 업
			startNum = is[0].getItemNum() - 8;
		}
		// 아이템 슬롯들의 위치는 고정이나 값들은 변경
		for (int i = 0; i < 12; i++) {
			item[0] = String.valueOf(startNum + i);
			is[i].setItem(item);
		}
	}
}
