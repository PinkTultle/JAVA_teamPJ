package GUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class C_Component {
	static interface BaseTextComponent { // JTextComponent 상속받는 클래스들을 처리하기 위한 인터페이스
		/**
		 * 
		 */

		abstract void focusGained();

		abstract void focusLost();

		abstract String getString(); // 기능은 getText와 동일
	}

	static class MyJT extends JTextField implements BaseTextComponent { // JTextField 에 사용자 기능 추가
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected boolean isTyped = false;
		protected String init;

		public MyJT(String s) {
			// TODO Auto-generated constructor stub
			init = s;
			setText(s);
		}

		@Override
		public void focusGained() {
			// TODO Auto-generated method stub
			if (!isTyped) {
				setText("");
			}
		}

		@Override
		public void focusLost() {
			// TODO Auto-generated method stub
			if (!getText().isEmpty()) {
				isTyped = true;
			} else {
				isTyped = false;
			}
			if (!isTyped) {
				setText(init);
			}
		}

		@Override
		public String getString() {
			// TODO Auto-generated method stub
			return getText();
		}
	}

	static class MyJT_TEL extends MyJT { // MyJT 에서 전화번호 용

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyJT_TEL(String s) {
			super(s);
		}

		@Override
		public void focusGained() {
			// TODO Auto-generated method stub
			super.focusGained();
			setHorizontalAlignment(JTextField.LEFT);
		}

		@Override
		public void focusLost() {
			super.focusLost();
			setHorizontalAlignment(JTextField.CENTER);
		}
	}

	static class MyPT extends JPasswordField implements BaseTextComponent { // JPasswordField 에 사용자 기능 추가
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected boolean isTyped = false;
		protected String init;

		public MyPT(String s) {
			// TODO Auto-generated constructor stub
			init = s;
			setText(s);
			setEchoChar((char) 0);
		}

		@Override
		public void focusGained() {
			// TODO Auto-generated method stub
			if (!isTyped) {
				setText("");
				setEchoChar('*');
			}
		}

		@Override
		public void focusLost() {
			// TODO Auto-generated method stub
			if (!getText().isEmpty()) {
				isTyped = true;
			} else {
				isTyped = false;
				setEchoChar((char) 0);
			}
			if (!isTyped) {
				setText(init);
			}
		}

		@Override
		public String getString() {
			// TODO Auto-generated method stub
			return getText();
		}
	}

	static class MyFL implements FocusListener { // MyPT, MyJT 용 포커스 리스터
		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			BaseTextComponent baseTextComponent;
			baseTextComponent = (BaseTextComponent) e.getSource();
			baseTextComponent.focusGained();
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			BaseTextComponent baseTextComponent;
			baseTextComponent = (BaseTextComponent) e.getSource();
			baseTextComponent.focusLost();
		}
	}

	static class MyKA_Num extends KeyAdapter { // limit 까지의 숫자를 입력받을수 있게 하는 키 리스터
		int limit;

		public MyKA_Num(int limit) {
			// TODO Auto-generated constructor stub
			this.limit = limit - 1;
		}

		public void keyTyped(KeyEvent k) {
			BaseTextComponent baseTextComponent = (BaseTextComponent) k.getSource();
			if (baseTextComponent.getString().length() > limit || "1234567890".indexOf(k.getKeyChar()) == -1) {
				k.consume();
			}
		}
	}
}
