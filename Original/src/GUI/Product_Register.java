package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.DropMode;

public class Product_Register extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel BP = new Baener_pane();
	private JTextField PdName_text;
	private JTextField LentDate_text;
	private JTextField Model_text;
	private JTextField Desposit_text;
	private JTextField LentalFee_text;
	private JTextField Attachment_text;
	private JTextField Phone_text;
	
	public Product_Register() {
		getContentPane().setBackground(new Color(244, 244, 244));
		getContentPane().setForeground(new Color(255, 255, 255));
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//패널 크기 및 배경색
		setBackground(Color.white);
		setBounds(0, BP.getHeight(), 921, 743);
		setTitle("상품등록창");
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		//라벨
		JLabel PdName_Label = new JLabel("품 목 명");
		PdName_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PdName_Label.setBounds(69, 111, 91, 38);
		getContentPane().add(PdName_Label);
		
		JLabel Lentdate_Label = new JLabel("렌트기한");
		Lentdate_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Lentdate_Label.setBounds(69, 159, 76, 47);
		getContentPane().add(Lentdate_Label);
		
		JLabel Deposit_Label = new JLabel("보 증 금");
		Deposit_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Deposit_Label.setBounds(69, 216, 155, 32);
		getContentPane().add(Deposit_Label);
		
		JLabel Attachment_Label = new JLabel("첨     부");
		Attachment_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Attachment_Label.setBounds(68, 270, 58, 24);
		getContentPane().add(Attachment_Label);
		
		JLabel Description_Label = new JLabel("설     명");
		Description_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Description_Label.setBounds(68, 308, 148, 24);
		getContentPane().add(Description_Label);
		
		JLabel Modelname_Label = new JLabel("모 델 명");
		Modelname_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Modelname_Label.setBounds(587, 167, 66, 31);
		getContentPane().add(Modelname_Label);
		
		JLabel Percent_Label = new JLabel("%");
		Percent_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Percent_Label.setBounds(488, 216, 50, 31);
		getContentPane().add(Percent_Label);
		
		JLabel LentalFee_Label = new JLabel("대여료(1일)");
		LentalFee_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		LentalFee_Label.setBounds(563, 217, 83, 31);
		getContentPane().add(LentalFee_Label);
		
		JLabel Phone_Label = new JLabel("전화번호");
		Phone_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Phone_Label.setBounds(503, 265, 66, 31);
		getContentPane().add(Phone_Label);
		
		
		//텍스트 필드
		JTextArea Description_text = new JTextArea();
		Description_text.setBackground(new Color(255, 255, 255));
		Description_text.setBounds(69, 343, 769, 271);
		Description_text.setBorder(new LineBorder(Color.BLACK));
		getContentPane().add(Description_text);
		
		PdName_text = new JTextField();
		PdName_text.setBounds(143, 115, 520, 32);
		getContentPane().add(PdName_text);
		PdName_text.setColumns(10);
		
		LentDate_text = new JTextField();
		LentDate_text.setColumns(10);
		LentDate_text.setBounds(143, 167, 337, 32);
		getContentPane().add(LentDate_text);
		
		Model_text = new JTextField();
		Model_text.setColumns(10);
		Model_text.setBounds(655, 167, 183, 32);
		getContentPane().add(Model_text);
		
		Desposit_text = new JTextField();
		Desposit_text.setColumns(10);
		Desposit_text.setBounds(143, 216, 337, 32);
		getContentPane().add(Desposit_text);
		
		LentalFee_text = new JTextField();
		LentalFee_text.setColumns(10);
		LentalFee_text.setBounds(655, 216, 183, 32);
		getContentPane().add(LentalFee_text);
		
		Attachment_text = new JTextField();
		Attachment_text.setColumns(10);
		Attachment_text.setBounds(261, 265, 219, 32);
		getContentPane().add(Attachment_text);
		
		Phone_text = new JTextField();
		Phone_text.setColumns(10);
		Phone_text.setBounds(575, 265, 181, 32);
		getContentPane().add(Phone_text);
		
		
		//콤보박스
		JComboBox Categori_combox = new JComboBox();
		Categori_combox.setBackground(new Color(255, 255, 255));
		Categori_combox.setBounds(675, 115, 163, 32);
		Categori_combox.setModel(new DefaultComboBoxModel(new String[] { "카테고리", "전자기기", "가구/인테리어", "유아용품", "뷰티", "패션잡화",
				"가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타" }));
		getContentPane().add(Categori_combox);
		
		
		//체크박스
		JCheckBox Discussion_Check = new JCheckBox("협의");
		Discussion_Check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Discussion_Check.setBackground(new Color(244, 244, 244));
		Discussion_Check.setBounds(488, 171, 66, 23);
		getContentPane().add(Discussion_Check);
		
		JCheckBox SafeNumber_Check = new JCheckBox("안심번호");
		SafeNumber_Check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		SafeNumber_Check.setBackground(new Color(244, 244, 244));
		SafeNumber_Check.setBounds(758, 268, 91, 23);
		getContentPane().add(SafeNumber_Check);
		
		
		//버튼
		JButton Attachment_btn = new JButton("첨부하기");
		Attachment_btn.setBackground(new Color(255, 255, 255));
		Attachment_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Attachment_btn.setBounds(143, 265, 106, 33);
		getContentPane().add(Attachment_btn);
		
		JButton Register_btn = new JButton("등록");
		Register_btn.setForeground(new Color(255, 255, 255));
		Register_btn.setBackground(new Color(41, 76, 121));
		Register_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Register_btn.setBounds(663, 642, 83, 42);
		getContentPane().add(Register_btn);
		
		JButton Cancel_btn = new JButton("취소");
		Cancel_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Cancel_btn.setBackground(Color.white);
		Cancel_btn.setBounds(757, 642, 83, 42);
		
		getContentPane().add(Cancel_btn);
		
		JLabel lblNewLabel = new JLabel("상품등록");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(46, 44, 89, 38);
		getContentPane().add(lblNewLabel);
		Cancel_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		
		
		setVisible(true);

	}
}
