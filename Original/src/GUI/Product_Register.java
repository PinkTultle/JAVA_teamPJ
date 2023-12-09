package GUI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

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
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		//패널 크기 및 배경색
		setBackground(new Color(255, 255, 255));
		setBounds(0, BP.getHeight(), 1050, 700);
		setLayout(null);
		
		//라벨
		JLabel PdName_Label = new JLabel("품 목 명");
		PdName_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		PdName_Label.setBounds(140, 82, 91, 38);
		add(PdName_Label);
		
		JLabel Lentdate_Label = new JLabel("렌트기한");
		Lentdate_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Lentdate_Label.setBounds(140, 130, 76, 47);
		add(Lentdate_Label);
		
		JLabel Deposit_Label = new JLabel("보 증 금");
		Deposit_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Deposit_Label.setBounds(140, 187, 155, 32);
		add(Deposit_Label);
		
		JLabel Attachment_Label = new JLabel("첨     부");
		Attachment_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Attachment_Label.setBounds(139, 241, 58, 24);
		add(Attachment_Label);
		
		JLabel Description_Label = new JLabel("설     명");
		Description_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Description_Label.setBounds(139, 308, 148, 24);
		add(Description_Label);
		
		JLabel Modelname_Label = new JLabel("모 델 명");
		Modelname_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Modelname_Label.setBounds(658, 138, 66, 31);
		add(Modelname_Label);
		
		JLabel Percent_Label = new JLabel("%");
		Percent_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Percent_Label.setBounds(559, 187, 50, 31);
		add(Percent_Label);
		
		JLabel LentalFee_Label = new JLabel("대여료(1일)");
		LentalFee_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		LentalFee_Label.setBounds(634, 188, 83, 31);
		add(LentalFee_Label);
		
		JLabel Phone_Label = new JLabel("전화번호");
		Phone_Label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Phone_Label.setBounds(574, 236, 66, 31);
		add(Phone_Label);
		
		
		//텍스트 필드
		JTextArea Description_text = new JTextArea();
		Description_text.setBackground(new Color(255, 255, 255));
		Description_text.setBounds(140, 343, 769, 271);
		add(Description_text);
		
		PdName_text = new JTextField();
		PdName_text.setBounds(214, 86, 520, 32);
		add(PdName_text);
		PdName_text.setColumns(10);
		
		LentDate_text = new JTextField();
		LentDate_text.setColumns(10);
		LentDate_text.setBounds(214, 138, 337, 32);
		add(LentDate_text);
		
		Model_text = new JTextField();
		Model_text.setColumns(10);
		Model_text.setBounds(726, 138, 183, 32);
		add(Model_text);
		
		Desposit_text = new JTextField();
		Desposit_text.setColumns(10);
		Desposit_text.setBounds(214, 187, 337, 32);
		add(Desposit_text);
		
		LentalFee_text = new JTextField();
		LentalFee_text.setColumns(10);
		LentalFee_text.setBounds(726, 187, 183, 32);
		add(LentalFee_text);
		
		Attachment_text = new JTextField();
		Attachment_text.setColumns(10);
		Attachment_text.setBounds(332, 236, 219, 32);
		add(Attachment_text);
		
		Phone_text = new JTextField();
		Phone_text.setColumns(10);
		Phone_text.setBounds(646, 236, 181, 32);
		add(Phone_text);
		
		
		//콤보박스
		JComboBox Categori_combox = new JComboBox();
		Categori_combox.setBounds(746, 86, 163, 32);
		Categori_combox.setModel(new DefaultComboBoxModel(new String[] { "카테고리", "전자기기", "가구/인테리어", "유아용품", "뷰티", "패션잡화",
				"가전/생활", "스포츠/레져", "도서", "취미/게임", "동물용품", "기타" }));
		add(Categori_combox);
		
		
		//체크박스
		JCheckBox Discussion_Check = new JCheckBox("협의");
		Discussion_Check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Discussion_Check.setBackground(new Color(255, 255, 255));
		Discussion_Check.setBounds(559, 142, 66, 23);
		add(Discussion_Check);
		
		JCheckBox SafeNumber_Check = new JCheckBox("안심번호");
		SafeNumber_Check.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		SafeNumber_Check.setBackground(Color.WHITE);
		SafeNumber_Check.setBounds(829, 239, 91, 23);
		add(SafeNumber_Check);
		
		
		//버튼
		JButton Attachment_btn = new JButton("첨부하기");
		Attachment_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		Attachment_btn.setBounds(214, 236, 106, 33);
		add(Attachment_btn);
		
		JButton Register_btn = new JButton("등록");
		Register_btn.setForeground(new Color(255, 255, 255));
		Register_btn.setBackground(new Color(41, 76, 121));
		Register_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Register_btn.setBounds(807, 641, 83, 42);
		add(Register_btn);
		
		JButton Cancel_btn = new JButton("취소");
		Cancel_btn.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Cancel_btn.setBounds(901, 641, 83, 42);
		add(Cancel_btn);
		
		setVisible(true);

	}
	
}
