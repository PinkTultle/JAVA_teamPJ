package GUI;

import javax.swing.JPanel;

public class Main_home extends Function_pane {

	private JPanel Home_1, Home2;
	
	public Main_home() {
		// TODO Auto-generated constructor stub
		
		//마우스 올리면 출력되는 문구 이후 삭제
		setToolTipText("홈 패널");
		
		Home_1 = new Home_left_pane();
		add(Home_1);
		
	}
	
}
