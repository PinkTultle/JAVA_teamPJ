package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;


public class item_detail  {

	private JFrame frame;
	private JTextField Name_text;
	private JTextField 물건_설명창;
	private JTextField Price_text;
	private JTextField Regi_data_text;
	private JTextField Return_data_text;
	private JTextField Contact_text;
	private JTextField Image;
	private JRadioButton Rental_possible_box;
	private JRadioButton Rental_impossible_box;
	private JLabel Rental_possible;
	private JLabel Rental_impossible;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					item_detail window = new item_detail();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public item_detail()  {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 464, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setSize(450, 384);
		panel.setLocation(0, -23);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Name_text = new JTextField();
		Name_text.setEnabled(false);
		Name_text.setBounds(99, 44, 96, 21);
		Name_text.setColumns(10);
		
		JLabel item_name = new JLabel("물건명     :");
		item_name.setBounds(22, 47, 70, 15);
		
		JLabel Item_price = new JLabel("가격ㅤ     :");
		Item_price.setBounds(22, 72, 70, 15);
		
		JLabel Item_regi_date = new JLabel("등록일     :");
		Item_regi_date.setBounds(22, 97, 70, 15);
		
		JLabel Item_return_date = new JLabel("반납기한 :");
		Item_return_date.setBounds(22, 123, 70, 15);
		
		물건_설명창 = new JTextField();
		물건_설명창.setEnabled(false);
		물건_설명창.setBounds(21, 255, 404, 107);
		물건_설명창.setColumns(10);
		
		Price_text = new JTextField();
		Price_text.setEnabled(false);
		Price_text.setBounds(99, 69, 96, 21);
		Price_text.setColumns(10);
		
		Regi_data_text = new JTextField();
		Regi_data_text.setEnabled(false);
		Regi_data_text.setBounds(99, 94, 96, 21);
		Regi_data_text.setColumns(10);
		
		Return_data_text = new JTextField();
		Return_data_text.setEnabled(false);
		Return_data_text.setBounds(99, 120, 96, 21);
		Return_data_text.setColumns(10);
		
		JLabel Contact = new JLabel("연락처     :");
		Contact.setBounds(22, 148, 62, 15);
		frame.getContentPane().setLayout(null);
		panel.add(item_name);
		panel.add(Name_text);
		panel.add(Item_price);
		panel.add(Price_text);
		panel.add(Item_regi_date);
		panel.add(Regi_data_text);
		panel.add(Item_return_date);
		panel.add(Return_data_text);
		panel.add(Contact);
		panel.add(물건_설명창);
		
		Contact_text = new JTextField();
		Contact_text.setEnabled(false);
		Contact_text.setBounds(99, 145, 96, 21);
		Contact_text.setColumns(10);
		panel.add(Contact_text);
		
		Image = new JTextField();
		Image.setForeground(new Color(0, 0, 0));
		Image.setFont(new Font("굴림", Font.BOLD, 12));
		Image.setBounds(299, 106, 49, 49);
		Image.setText("이미지");
		panel.add(Image);
		Image.setColumns(10);
		
		
		Rental_possible = new JLabel("대여 가능");
		Rental_possible.setBounds(46, 195, 62, 15);
		panel.add(Rental_possible);
		
		Rental_impossible = new JLabel("대여 불가");
		Rental_impossible.setBounds(46, 220, 62, 15);
		panel.add(Rental_impossible);
		
		//대여여부 변수 test 값에 따라 대여 불/가능 라디오버튼 체크 여부
		//가능 여부를 사용자가 등록할때 설정, 반납기한 지났을 때, 관리자가 설정
		int test = 1;
		
		/*
		 * 
		 */
		Rental_possible_box = new JRadioButton("");
		Rental_possible_box.setBounds(100, 192, 21, 23);
		Rental_possible_box.setSelected(test == 1);
		Rental_possible_box.setEnabled(false);
		panel.add(Rental_possible_box);
		
		Rental_impossible_box = new JRadioButton("");
		Rental_impossible_box.setBounds(100, 217, 21, 23);
		Rental_impossible_box.setSelected(test == 0);
		Rental_impossible_box.setEnabled(false);
		panel.add(Rental_impossible_box);
		
	}
}
