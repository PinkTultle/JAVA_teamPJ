package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class C_Component {
	static interface BaseTextComponent { // JTextComponent 상속받는 클래스들을 처리하기 위한 인터페이스
		/**
		 * 
		 */

		abstract void focusGained();

		abstract void focusLost();

		abstract String getString(); // 기능은 getText와 동일

		abstract boolean isTyped();

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

		@Override
		public boolean isTyped() {
			// TODO Auto-generated method stub
			return isTyped;
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

		@Override
		public boolean isTyped() {
			// TODO Auto-generated method stub
			return isTyped;
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

	static class itemSlot extends JScrollPane implements MouseListener, KeyListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected static final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);

		private JTable table;
		private int selectedRow;

		public itemSlot(int x, int y, int width, int height) {
			// TODO Auto-generated constructor stub
			this.setBounds(x, y, width, height);
			table = new JTable();
			table.setModel(new DefaultTableModel(
					new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, { null, null, null, null, null, null },
							{ null, null, null, null, null, null }, },
					new String[] { "\uBB3C\uD488\uCF54\uB4DC", "\uCE74\uD14C\uACE0\uB9AC", "\uBB3C\uD488\uBA85",
							"\uB4F1\uB85D\uC790", "\uB80C\uD2B8\uAE30\uD55C", "\uCC98\uB9AC\uC0C1\uD0DC" }) {
				Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class,
						String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});

			// 엔터 입력 설정 | 이벤트 리스너랑 연동시킬 예정
			InputMap iMap = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
			KeyStroke stroke = KeyStroke.getKeyStroke("ENTER");
			iMap.put(stroke, "null");

			// 테이블 기본 설정
			DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
			renderer.setHorizontalAlignment(renderer.CENTER);
			table.setDefaultRenderer(String.class, renderer); // 중앙 정렬
			table.setRowHeight((this.getHeight() - 25) / table.getRowCount()); // JTable의 헤더의 높이는 25임
			table.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			table.setSelectionBackground(new Color(106, 172, 208));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(this);
			table.addKeyListener(this);

			// 행과 열 설정
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			table.getColumnModel().getColumn(2).setMinWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
			table.setSelectionBackground(new Color(106, 172, 208));
			table.setDefaultRenderer(String.class, new ProxyCellRenderer(table.getDefaultRenderer(String.class)));

			// 헤더 설정
			DefaultTableCellRenderer renderer_header = new DefaultTableCellRenderer();
			renderer_header.setBorder(DEFAULT_BORDER);
			renderer_header.setBackground(new Color(0, 140, 200));
			renderer_header.setForeground(new Color(255, 255, 255));
			renderer_header.setHorizontalAlignment(renderer_header.CENTER);
			renderer_header.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			table.getTableHeader().setDefaultRenderer(renderer_header);
			table.getTableHeader().setResizingAllowed(false);
			table.getTableHeader().setReorderingAllowed(false);

			// 스크롤팬에 테이블 추가
			this.setViewportView(table);

		}

		public static class ProxyCellRenderer implements TableCellRenderer { // 자동으로 모든 셀에 적용시켜줌 | 헤더를 접근하는 방법은 아직 모르겠음

			private TableCellRenderer renderer;

			public ProxyCellRenderer(TableCellRenderer renderer) {
				this.renderer = renderer;
			}

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Component comp = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				if (comp instanceof JComponent) {
					((JComponent) comp).setBorder(DEFAULT_BORDER);
				}
				return comp;
			}
		}

		public void setItem(int rowNum, String[] value) { // 목록의 아이템을 바꾸는 메소드 | 추가 필요
			for (int i = 0; i < 6; i++) {
				table.setValueAt(value[i], rowNum, i);
			}
		}

		public void setPage(Vector<String[]> v) { // 페이지 변경시 목록 변경 | String[] vector 로 임시 설정 : 클래스 추가시 변경 필요 | row
													// 단위로 변경
			for (int i = 0; i < 15; i++) {
				setItem(i, v.elementAt(i));
			}
		}

		// 마우스 리스너와 키 리스너 선언
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount() == 2) { // 더블 클릭했을 경우
				System.out.println("double clicked");
				selectedRow = table.getSelectedRow(); // 행 정보를 받아옴
				System.out.println(selectedRow);
			}
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

		boolean pressed = false;

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == '\n' && !pressed) { // Enter 를 눌렀을 경우
				System.out.println("Key_Enter");
				selectedRow = table.getSelectedRow(); // 행 정보를 받아옴
				System.out.println(selectedRow);
				pressed = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == '\n' && pressed) {
				pressed = false;
			}
		}
	}
}
