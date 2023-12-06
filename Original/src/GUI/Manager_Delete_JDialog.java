package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Manager_Delete_JDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	public static void main(String[] args) {
		try {
			Manager_Delete_JDialog dialog = new Manager_Delete_JDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("삭제");   // 다이어로그 창 이름
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Manager_Delete_JDialog() {
		setBounds(100, 100, 273, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("삭제하시겠습니까?");
		lblNewLabel.setBounds(73, 27, 113, 15);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 13));
		contentPanel.add(lblNewLabel);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 68, 259, 36);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton approve = new JButton("확인");
				approve.setForeground(new Color(255, 255, 255));
				approve.setBounds(61, 0, 59, 23);
				approve.setBackground(new Color(59, 56, 56));
				approve.setActionCommand("OK");
				buttonPane.add(approve);
				getRootPane().setDefaultButton(approve);
			}
			{
				JButton cancel = new JButton("취소");
				cancel.setBounds(140, 0, 59, 23);
				cancel.setBackground(Color.white);
				cancel.setActionCommand("Cancel");
				cancel.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                // 닫기 버튼이 클릭되었을 때의 동작
		            	dispose(); // 창을 닫음
		            }
		        });
				buttonPane.add(cancel);
			}
		}
	}

}
