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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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

	static interface BaseTableComponent {
		abstract void goDetail();

		abstract void focusLost();
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
			if (e.getSource() instanceof BaseTextComponent) {
				BaseTextComponent baseTextComponent;
				baseTextComponent = (BaseTextComponent) e.getSource();
				baseTextComponent.focusGained();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() instanceof BaseTextComponent) {
				BaseTextComponent baseTextComponent;
				baseTextComponent = (BaseTextComponent) e.getSource();
				baseTextComponent.focusLost();
			} else if (e.getSource() instanceof BaseTableComponent) {
				BaseTableComponent baseTableComponent;
				baseTableComponent = (BaseTableComponent) e.getSource();
				baseTableComponent.focusLost();
			}
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

	public static class ProxyCellRenderer implements TableCellRenderer { // 자동으로 모든 셀에 적용시켜줌 | 포커스 디자인을 없앰

		private TableCellRenderer renderer;
		final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);

		public ProxyCellRenderer(TableCellRenderer renderer) {
			this.renderer = renderer;
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component comp = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			if (comp instanceof JComponent) {
				((JComponent) comp).setBorder(DEFAULT_BORDER);
			}
			return comp;
		}
	}

	static void initJTableStyle(JTable jt, int height, int rowCount) { // JTable 클래스들의 기본 설정
		final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);

		// Enter 키 이벤트 제거
		InputMap iMap = jt.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		KeyStroke stroke = KeyStroke.getKeyStroke("ENTER");
		jt.addFocusListener(new MyFL());
		iMap.put(stroke, "null");

		// 테이블 설정
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(renderer.CENTER);
		jt.setDefaultRenderer(String.class, renderer); // 중앙 정렬
		jt.setRowHeight((height - 25) / rowCount); // JTable의 헤더의 높이는 25임
		jt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jt.setSelectionBackground(new Color(106, 172, 208));
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt.setDefaultRenderer(String.class, new ProxyCellRenderer(jt.getDefaultRenderer(String.class)));
		jt.setDefaultRenderer(Boolean.class, new ProxyCellRenderer(jt.getDefaultRenderer(Boolean.class)));
		jt.addMouseListener(new My_ML());
		jt.addKeyListener(new My_KL());

		// 헤더 설정
		DefaultTableCellRenderer renderer_header = new DefaultTableCellRenderer();
		renderer_header.setBorder(DEFAULT_BORDER);
		renderer_header.setBackground(new Color(0, 140, 200));
		renderer_header.setForeground(new Color(255, 255, 255));
		renderer_header.setHorizontalAlignment(renderer_header.CENTER);
		renderer_header.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jt.getTableHeader().setDefaultRenderer(renderer_header);
		jt.getTableHeader().setResizingAllowed(false);
		jt.getTableHeader().setReorderingAllowed(false);

	}

	static class MyTA extends JTable implements BaseTableComponent {
		@Override
		public void goDetail() { // 마우스나 키보드 이벤트 발생시 실행하는 메소드
			// TODO Auto-generated method stub
			int selectedRow = this.getSelectedRow(); // 행 정보를 받아옴
			System.out.println(selectedRow);
		}

		@Override
		public void focusLost() {
			// TODO Auto-generated method stub
			this.clearSelection();
		}

	}

	static class itemSlot_list extends JScrollPane {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private MyTA table;

		public itemSlot_list(int x, int y, int width, int height) {
			// TODO Auto-generated constructor stub
			this.setBounds(x, y, width, height);
			table = new MyTA();
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

			// 행과 열 설정
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			table.getColumnModel().getColumn(2).setMinWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(60);
			table.getColumnModel().getColumn(4).setPreferredWidth(60);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);

			// 테이블 디자인
			initJTableStyle(table, height, 15);

			// 스크롤팬에 테이블 추가
			this.setViewportView(table);

		}

		public void setItem(int rowNum, String[] value) { // 목록의 아이템을 바꾸는 메소드 | 추가 필요
			for (int i = 0; i < 6; i++) {
				table.setValueAt(value[i], rowNum, i);
			}
		}

		public void setPage(Vector<String[]> v) { // 페이지 변경시 목록 변경 | String[] vector 로 임시 설정 : 클래스 추가시 변경 필요 | row 단위로
													// 변경 ( 최대 15개
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			System.out.println(tableModel.getRowCount() + " " + v.size());
			if (tableModel.getRowCount() < v.size()) {
				for (int i = v.size() - tableModel.getRowCount(); i > 0; i--) {
					tableModel.addRow(new Object[] { null, null, null, null, null, null });
				}
			} else {
				for (int i = tableModel.getRowCount() - v.size(); i > 0; i--) {
					System.out.println(tableModel.getRowCount() - v.size());
					tableModel.removeRow(0);
				}
			}
			for (int i = 0; i < v.size(); i++) {
				setItem(i, v.elementAt(i));
			}
		}

	}

	static public class itemSlot_offer extends JScrollPane {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private MyTA table;

		public itemSlot_offer(int x, int y, int width, int height, int mode) {
			setBounds(x, y, width, height);
			getViewport().setBackground(Color.white);
			table = new MyTA();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "\uBB3C\uD488\uCF54\uB4DC", "\uBB3C\uD488\uBA85", "\uC694\uCCAD\uAE30\uD55C" }) {
				Class[] columnTypes = new Class[] { String.class, String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});

			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(0).setMinWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(1).setMinWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			table.getColumnModel().getColumn(2).setMinWidth(15);

			initJTableStyle(table, height, 10);

			this.setViewportView(table);

		}

		void setItem(Vector<Object[]> v) { // String.Object 3개를 벡터를 이용해서 전달 받음
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			for (int i = 0; i < v.size(); i++) {
				tableModel.addRow(v.elementAt(i));
			}
		}

		void setHeaderColor(Color color) {
			DefaultTableCellRenderer defaultTableCellRenderer = (DefaultTableCellRenderer) table.getTableHeader()
					.getDefaultRenderer();
			defaultTableCellRenderer.setBackground(color);
		}
	}

	static public class itemSlot_history extends JScrollPane {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private MyTA table;
		private int selectedIndex = -1;

		public itemSlot_history(int x, int y, int width, int height) {
			setBounds(x, y, width, height);
			getViewport().setBackground(Color.white);
			table = new MyTA();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "", "\ubb3c\ud488\ucf54\ub4dc", "\uac70\ub798\uc790", "\ubb3c\ud488\uba85",
							"\ub0a8\uc740\u0020\uae30\uac04", "\uc774\uc6a9\uc0c1\ud0dc",
							"\ubc18\ub0a9\u002f\uc5f0\uc7a5\uc0c1\ud0dc" }) {
				Class[] columnTypes = new Class[] { Boolean.class, String.class, String.class, String.class,
						String.class, String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { true, false, false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});

			initJTableStyle(table, height, 10);

			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(0).setMinWidth(20);
			table.getColumnModel().getColumn(0).setMaxWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(60);
			table.getColumnModel().getColumn(3).setPreferredWidth(300);
			table.getColumnModel().getColumn(3).setMinWidth(200);
			table.getColumnModel().getColumn(4).setPreferredWidth(40);
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
			table.getColumnModel().getColumn(6).setPreferredWidth(40);

			table.getModel().addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent e) {
					// TODO Auto-generated method stub
					handleTableChangedEvent(e);
				}
			});

			this.setViewportView(table);

		}

		void setItem(Vector<Object[]> v) { // boolean 1개와 String 6개로 값을 변경
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			for (int i = 0; i < v.size(); i++) {
				tableModel.addRow(v.elementAt(i));
			}
		}

		void setHeaderColor(Color color) {
			DefaultTableCellRenderer defaultTableCellRenderer = (DefaultTableCellRenderer) table.getTableHeader()
					.getDefaultRenderer();
			defaultTableCellRenderer.setBackground(color);
		}

		int getSelectItemNum() {
			int returnItemNum = -1;
			if (selectedIndex != -1 && (boolean) table.getValueAt(selectedIndex, 0)) {
				returnItemNum = Integer.parseInt(table.getValueAt(selectedIndex, 1).toString());
			}
			return returnItemNum;
		}

		protected void handleTableChangedEvent(TableModelEvent e) {
			int tempIndex = e.getFirstRow();
			if (tempIndex != -1) {
				if ((Boolean) table.getValueAt(tempIndex, 0) == true) {
					if (selectedIndex != -1 && selectedIndex != tempIndex)
						table.setValueAt(false, selectedIndex, 0);
					selectedIndex = tempIndex;

				}
			}
		}
	}

	static class My_KL implements KeyListener {

		boolean pressed = false;

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyChar() == '\n' && !pressed) { // Enter 키를 누른 경우
				if (e.getSource() instanceof BaseTableComponent) { // JTable 인 경우
					BaseTableComponent baseTableComponent = (BaseTableComponent) e.getSource();
					baseTableComponent.goDetail();
					pressed = true;
				}
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

	static class My_ML implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getClickCount() == 2) { // 더블 클릭했을 경우
				if (e.getSource() instanceof BaseTableComponent) { // JTable 인 경우
					BaseTableComponent baseTableComponent = (BaseTableComponent) e.getSource();
					baseTableComponent.goDetail();
				}
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
	}
}