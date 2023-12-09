package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

class popup_JDialog extends JDialog {

	public popup_JDialog(String Title,String text) {

		setSize(300, 150);
		setTitle(Title);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// 사이즈 조절 off
		setResizable(false);
		// 화면 중앙에 출력
		setLocationRelativeTo(null);

		JPanel jp = (JPanel) getContentPane();
		jp.setLayout(new BorderLayout(10, 10));
		setContentPane(jp);

		JLabel jl = new JLabel(text);
		jl.setFont(new Font("맑은 고딕", Font.BOLD | Font.PLAIN, 25));

		jl.setHorizontalAlignment(JLabel.CENTER);

		JButton jb = new JButton("확인");
		jb.setBorderPainted(false);
		jb.setFocusPainted(false);
		jb.setBackground(Color.darkGray);
		jb.setFont(new Font("맑은 고딕", Font.BOLD | Font.PLAIN, 22));
		jb.setForeground(Color.white);

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		add(jb, BorderLayout.SOUTH);
		add(jl, BorderLayout.CENTER);

		setVisible(rootPaneCheckingEnabled);
	}

}