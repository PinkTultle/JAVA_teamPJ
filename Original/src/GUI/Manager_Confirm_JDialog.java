package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class Manager_Confirm_JDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	
	public static void main(String[] args) {
		try {
			Manager_Confirm_JDialog dialog = new Manager_Confirm_JDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("확인");   // 다이어로그 창 이름
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Manager_Confirm_JDialog() {
		setBounds(100, 100, 339, 282);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);
		
		
		// 확인 문구 출력
		JLabel lblNewLabel = new JLabel("해당 신고 건을 처리 완료하시겠습니까?");
		lblNewLabel.setBounds(29, 21, 315, 44);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 14));
		contentPanel.add(lblNewLabel);
		
		JLabel matter_Label = new JLabel("내  용");
		matter_Label.setBounds(29, 77, 57, 25);
		matter_Label.setFont(new Font("굴림", Font.BOLD, 13));
		contentPanel.add(matter_Label);
		
		
		// 관리자가 코멘트를 입력하는 칸
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 102, 264, 89);
		contentPanel.add(textArea);
		
		
		// 확인, 닫기 버튼과 버튼 위치 패널
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 201, 325, 44);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton approve = new JButton("확인");
				approve.setForeground(new Color(255, 255, 255));
				approve.setBounds(91, 10, 63, 23);
				approve.setBackground(new Color(59, 56, 56));
				buttonPane.add(approve);
				approve.setActionCommand("Ok");
				getRootPane().setDefaultButton(approve);
			}
			{
				JButton cancel = new JButton("취소");
				cancel.setBounds(175, 10, 63, 23);
				cancel.setBackground(Color.white);
				buttonPane.add(cancel);
				cancel.setActionCommand("cancel");
				cancel.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // 닫기 버튼이 클릭되었을 때의 동작
		            	dispose(); // 창을 닫음
		            }
		        });
			}
		}
	}
}
