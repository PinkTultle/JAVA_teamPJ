package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import JDBC.ItemDAO;
import JDBC.ItemDTO;
import JDBC.ReportDAO;
import JDBC.ReportDTO;

public class C_Component {
	static private MyFL myFL = new MyFL();

	static interface BaseTextComponent { // JTextComponent 상속받는 클래스들을 처리하기 위한 인터페이스
		/**
		 * 
		 */

		abstract void focusGained();

		abstract void focusLost();

		abstract String getString(); // 기능은 getText와 동일

		abstract boolean isTyped();

		abstract boolean isEnable();

		abstract void clear();

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

		public MyJT() {
			init = null;
			addFocusListener(myFL);
		}

		public MyJT(String s) {
			this();
			init = s;
			setText(s);
		}

		@Override
		public void focusGained() {
			if (!isTyped) {
				setText("");
			}
		}

		@Override
		public void focusLost() {
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
			return getText();
		}

		@Override
		public boolean isTyped() {
			return isTyped;
		}

		public void setInit(String s) {
			init = s;
			setText(s);
		}

		@Override
		public boolean isEnable() {
			return isEnabled();
		}

		@Override
		public void clear() {
			setText(init);
			isTyped = false;
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
			init = s;
			setText(s);
			setEchoChar((char) 0);
			addFocusListener(myFL);
		}

		@Override
		public void focusGained() {
			if (!isTyped) {
				setText("");
				setEchoChar('*');
			}
		}

		@Override
		public void focusLost() {
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
			return getText();
		}

		@Override
		public boolean isTyped() {
			return isTyped;
		}

		@Override
		public boolean isEnable() {
			return isEnabled();
		}

		@Override
		public void clear() {
			setText(init);
			setEchoChar((char) 0);
			isTyped = false;
		}
	}

	static class MyFL implements FocusListener { // MyPT, MyJT 용 포커스 리스터
		@Override
		public void focusGained(FocusEvent e) {
			if (e.getSource() instanceof BaseTextComponent) {
				BaseTextComponent baseTextComponent;
				baseTextComponent = (BaseTextComponent) e.getSource();
				baseTextComponent.focusGained();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
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

	static void initJTableStyle(JTable jt, int height, int rowCount, boolean isHeader) { // JTable 클래스들의 기본 설정
		final Border DEFAULT_BORDER = new EmptyBorder(1, 1, 1, 1);

		My_ML ml = new My_ML();
		
		// Enter 키 이벤트 제거
		InputMap iMap = jt.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		KeyStroke stroke = KeyStroke.getKeyStroke("ENTER");
		jt.addFocusListener(new MyFL());
		iMap.put(stroke, "null");

		// 테이블 설정
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(renderer.CENTER);
		jt.setDefaultRenderer(String.class, renderer); // 중앙 정렬
		jt.setRowHeight(height / rowCount); // JTable의 헤더의 높이는 25임
		jt.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		jt.setSelectionBackground(new Color(106, 172, 208));
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jt.setDefaultRenderer(String.class, new ProxyCellRenderer(jt.getDefaultRenderer(String.class)));
		jt.setDefaultRenderer(Boolean.class, new ProxyCellRenderer(jt.getDefaultRenderer(Boolean.class)));
		jt.addMouseListener(ml);
		jt.addKeyListener(new My_KL());
		jt.setShowVerticalLines(false);

		// 헤더 설정
		if (isHeader) {
			DefaultTableCellRenderer renderer_header = new DefaultTableCellRenderer();
			renderer_header.setBorder(DEFAULT_BORDER);
			renderer_header.setBackground(new Color(0, 140, 200));
			renderer_header.setForeground(new Color(255, 255, 255));
			renderer_header.setHorizontalAlignment(renderer_header.CENTER);
			renderer_header.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
			jt.getTableHeader().setDefaultRenderer(renderer_header);
			jt.getTableHeader().setResizingAllowed(false);
			jt.getTableHeader().setReorderingAllowed(false);
		} else {
			jt.setTableHeader(null);
		}
	}

	static class MyTA extends JTable implements BaseTableComponent {
		/*
		 * JTable 에 사용자 기능들을 추가한 클래스 goDetail : 클릭 이벤트 또는 enter 이벤트 발생 시 해당 메소드를 실행함
		 * focusLost : focus 가 사라지는 경우 Select 된 행을 초기화
		 */
		protected int itemNumIdx = 0;

		MyTA() {
		}

		MyTA(String[][] s1, String[] s2) {
			super(s1, s2);
		}

		@Override
		public void goDetail() { // 마우스나 키보드 이벤트 발생시 실행하는 메소드
			int selectedRow = this.getSelectedRow(); // 행 정보를 받아옴
			// 선택 항의 PID를 이용하여서 정보 검색이 필요
			ItemDetail idPanel = new ItemDetail(Integer.parseInt(getValueAt(selectedRow, itemNumIdx).toString()));
			if (!idPanel.isOpen)
				idPanel.dispose();
			else
				idPanel.setVisible(true);
		}

		@Override
		public void focusLost() {
			this.clearSelection();
		}

	}

	static class MyTA_report extends MyTA implements BaseTableComponent {
		/*
		 * reportDetailTable를 위해서 goDetail을 재정의한 테이블 이 테이블은 선택 항목에 대해서
		 * Report_Window_Read 를 표시한다.
		 */

		@Override
		public void goDetail() { // 마우스나 키보드 이벤트 발생시 실행하는 메소드
			int selectedRow = this.getSelectedRow(); // 행 정보를 받아옴
			// 선택 항의 PID를 이용하여서 정보 검색이 필요
			Report_Window_Read RWRPanel = new Report_Window_Read(getValueAt(selectedRow, itemNumIdx).toString());
			RWRPanel.setVisible(true);
		}

	}

	static class MyTA_Offer extends MyTA implements BaseTableComponent {
		/*
		 * itemSlot_offer를 위해서 goDetail을 재정의한 테이블 이 테이블은 선택 항목에 대해서 설정된 모드에 따라
		 * checkOffer / ItemDetail을 표시한다.
		 */
		boolean mode;
		Vector<Integer> offerNum = new Vector<>();

		public void goDetail() { // 마우스나 키보드 이벤트 발생시 실행하는 메소드
			if (mode) {
				int selectedRow = this.getSelectedRow(); // 행 정보를 받아옴
				// 선택 항의 PID를 이용하여서 정보 검색이 필요
				checkOffer cO = new checkOffer(offerNum.get(selectedRow));
				cO.setVisible(true);
			} else {
				int selectedRow = this.getSelectedRow(); // 행 정보를 받아옴
				// 선택 항의 PID를 이용하여서 정보 검색이 필요
				ItemDetail idPanel = new ItemDetail(Integer.parseInt(getValueAt(selectedRow, itemNumIdx).toString()));
				if (!idPanel.isOpen)
					idPanel.dispose();
				else
					idPanel.setVisible(true);
			}
		}
	}

	static class base_itemSlot extends JScrollPane {
		/*
		 * JTable 을 사용하는 클래스들의 기본 상속 클래스 table : 실제로 화면에 표시될 JTable | 사용자 기능들을 추가한 MyTA
		 * 클래스를 이용함 | C_Component: 276 setItem : table 의 행을 설정하는 메소드 setHeaderColor :
		 * table 의 Header 의 색을 변경함
		 */
		MyTA table;

		void setItem(Vector<String[]> v) { // 자료형과 개수는 각 항목 참조
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			for (int i = 0; i < v.size(); i++) {
				tableModel.addRow(v.elementAt(i));
			}
		}

		void setHeaderColor(Color color) {
			if (table.getTableHeader() == null)
				return;
			DefaultTableCellRenderer defaultTableCellRenderer = (DefaultTableCellRenderer) table.getTableHeader()
					.getDefaultRenderer();
			defaultTableCellRenderer.setBackground(color);
		}

	}

	static class itemSlot_list extends base_itemSlot {
		/*
		 * 목록 패널에 사용될 JTable 생성자의 count 의 값에 따라 동시에 보여주는 항목의 개수를 설정
		 * 
		 */
		private static final long serialVersionUID = 1L;

		Vector<ItemDTO> data = new Vector<>();
		int page_max, page_cur = 1, itemCount;

		public itemSlot_list(int x, int y, int width, int height, int count) {
			this.itemCount = count;
			this.setBounds(x, y, width, height);
			table = new MyTA();
			table.setModel(new DefaultTableModel(new Object[][] {},
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
			initJTableStyle(table, height, itemCount, false);
			setSize(getWidth(), getHeight() + 3);

			this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

			// 스크롤팬에 테이블 추가
			this.setViewportView(table);

		}

		public void setPage(String category, String itemName, String status) { // count 만큼의 행을 표시함
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			while (rowCount != 0) {
				tableModel.removeRow(0);
				rowCount--;
			}
			ItemDAO itemDAO = new ItemDAO();
			data.clear();
			try {
				// 패널 내에 데이터 저장
				data = itemDAO.searchItemData(category, itemName, status);
				// 최대 페이지 설정
				page_max = 1;
				while (page_max * itemCount < data.size()) {
					page_max++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// 처음 페이지로 전환
			for (int i = 0; i < ((data.size() > itemCount) ? itemCount : data.size()); i++) {
				ItemDTO item = data.get(i);
				tableModel.addRow(new Object[] { Integer.toString(item.getItemnumber()), item.getCategory(),
						item.getItemname(), item.getPerson(), item.getRentdate(), item.getState() });
			}
		}

		public void changePage(int page) {
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			while (rowCount != 0) {
				rowCount--;
				tableModel.removeRow(0);
			}
			for (int idx = (page - 1) * itemCount, i = 0; i < itemCount; i++, idx++) {
				if (idx == data.size()) {
					break;
				}
				ItemDTO item = data.get(idx);
				tableModel.addRow(new Object[] { item.getItemnumber(), item.getCategory(), item.getItemname(),
						item.getPerson(), item.getRentdate(), item.getState() });
			}
			page_cur = page;
		}

		public int nextPage() {
			if (page_cur == page_max)
				return page_cur;
			changePage(++page_cur);
			return page_cur;
		}

		public int prevPage() {
			if (page_cur == 1)
				return page_cur;
			changePage(--page_cur);
			return page_cur;
		}

	}

	static public class itemSlot_myWriting extends itemSlot_list {
		/*
		 * 나의 글 패널에 사용될 JTable itemSlot_list 를 상속받아 같은 형식으로 생성됨 setPage를 오버로딩하여서 현재 접속된
		 * 계정의 물품만 불러옴
		 */

		public itemSlot_myWriting(int x, int y, int width, int height, int count) {
			super(x, y, width, height, count);
		}

		public void setPage() { // 10개 행 생성을 기본으로 함 |
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			while (rowCount != 0) {
				tableModel.removeRow(0);
				rowCount--;
			}
			ItemDAO itemDAO = new ItemDAO();
			data.clear();
			// 패널 내에 데이터 저장
			data = itemDAO.searchItemData_MY();
			// 최대 페이지 설정
			page_max = 1;
			while (page_max * itemCount < data.size()) {
				page_max++;
			}
			// 처음 페이지로 전환
			for (int i = 0; i < ((data.size() > itemCount) ? itemCount : data.size()); i++) {
				ItemDTO item = data.get(i);
				tableModel.addRow(new Object[] { Integer.toString(item.getItemnumber()), item.getCategory(),
						item.getItemname(), item.getPerson(), item.getRentdate(), item.getState() });
			}
		}

	}

	static public class itemSlot_offer extends base_itemSlot {
		/*
		 * 신청 관리 패널에 사용될 JTable mode 입력에 따라서 서로 다른 동작을 함
		 */
		private static final long serialVersionUID = 1L;
		private MyTA_Offer p_t;

		public itemSlot_offer(int x, int y, int width, int height, boolean mode) {
			// true: receive | false: send
			setBounds(x, y, width, height);
			getViewport().setBackground(Color.white);

			table = new MyTA_Offer();
			p_t = (MyTA_Offer) table;
			p_t.mode = mode;
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

			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(0).setMinWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setMinWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setMinWidth(15);

			initJTableStyle(table, height, 10, false);

			this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

			this.setViewportView(table);
		}

		void setItem(String s) throws SQLException {
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			while (rowCount != 0) {
				tableModel.removeRow(0);
				rowCount--;
			}
			Vector<ItemDTO> data = new Vector<ItemDTO>();
			ItemDAO itemDAO = new ItemDAO();
			data = itemDAO.item_receive_sending(s);
			for (ItemDTO item : data) {
				if (p_t.mode)
					p_t.offerNum.add(item.getRentNum());
				tableModel.addRow(new Object[] { "" + item.getItemnumber(), item.getItemname(), item.getRentdate() });
			}

		}

	}

	static public class itemSlot_history extends base_itemSlot {
		/*
		 * 렌트 내역 패널에 사용될 JTable 다른 테이블과 boolean 값을 추가로 가짐
		 */
		private static final long serialVersionUID = 1L;

		private int selectedIndex = -1;
		private Vector<Integer> offerNum = new Vector<>();

		public itemSlot_history(int x, int y, int width, int height) {
			setBounds(x, y, width, height);
			getViewport().setBackground(new Color(243, 246, 249));
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

			initJTableStyle(table, height, 10, false);

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

			table.itemNumIdx = 1;

			table.getModel().addTableModelListener(new TableModelListener() {

				@Override
				public void tableChanged(TableModelEvent e) {
					handleTableChangedEvent(e);
				}
			});

			this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));

			this.setViewportView(table);

		}

		void setItem() {
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			try {
				int rowCount = tableModel.getRowCount();
				while (rowCount != 0) {
					tableModel.removeRow(0);
					rowCount--;
				}
				offerNum.clear();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Vector<ItemDTO> data = new Vector<>();
				ItemDAO itemDAO = new ItemDAO();
				data = itemDAO.itemRental();
				for (ItemDTO item : data) {
					Object[] newData;
					offerNum.add(item.getRentNum());
					if (item.getState().equals("대여중")) {
						newData = new Object[] { false, Integer.toString(item.getItemnumber()), item.getPerson(),
								item.getItemname(), item.getRentdate(), item.getState(), null };
					} else {
						newData = new Object[] { false, Integer.toString(item.getItemnumber()), item.getPerson(),
								item.getItemname(), null, null, item.getState() };
					}

					// System.out.println(item.getItemname());

					tableModel.addRow(newData);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		int getSelectItemNum() { // checkBox가 선택된 항목의 물품코드를 반환함
			int returnItemNum = -1;
			if (selectedIndex != -1 && (boolean) table.getValueAt(selectedIndex, 0)) {
				returnItemNum = Integer.parseInt(table.getValueAt(selectedIndex, 1).toString());
			}
			return returnItemNum;
		}

		int getSelectRentNum() { // checkBox가 선택된 항목의 대여번호를 반환함
			int returnRentNum = -1;
			if (selectedIndex != -1 && (boolean) table.getValueAt(selectedIndex, 0)) {
				returnRentNum = offerNum.get(selectedIndex);
			}
			return returnRentNum;
		}

		String getSelectState() { // checkBox가 선택된 항목의 대여상태를 반환함
			String s = null;
			if (selectedIndex != -1 && (boolean) table.getValueAt(selectedIndex, 0)) {
				try {
					s = table.getValueAt(selectedIndex, 5).toString();
				} catch (Exception e) {
				}
			}
			return s;
		}

		void clear() {
			if (selectedIndex != -1)
				table.setValueAt(false, selectedIndex, 0);
			table.focusLost();

		}

		protected void handleTableChangedEvent(TableModelEvent e) { // checkBox가 하나만 선택되도록 설정
			int tempIndex = e.getFirstRow();
			if (tempIndex != -1 && table.getRowCount() != 0) {
				if ((Boolean) table.getValueAt(tempIndex, 0) == true) {
					if (selectedIndex != -1 && selectedIndex != tempIndex)
						table.setValueAt(false, selectedIndex, 0);
					selectedIndex = tempIndex;

				}
			}
		}
	}

	static public class myPageTable extends base_itemSlot {
		/*
		 * 마이페이지 패널에 사용될 JTable 대여기간이 짧게 남은 항목을 최대 2개까지 보여줌
		 */
		private static final long serialVersionUID = 1L;

		public myPageTable(int x, int y, int width, int height,int item_count) {
			setBounds(x, y, width, height);
			getViewport().setBackground(Color.white);

			table = new MyTA();

			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "", "", "" }) {
				Class[] columnTypes = new Class[] { String.class, String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			
			table.setRowHeight(70); // 각 행의 높이 설정
			
			initJTableStyle(table, height, item_count, false);
			if (item_count != 2) // 렌트 알림의 테이블이라면 행 높이 재설정
				table.setRowHeight(30);
			
			// 테이블 내 텍스트 가운데 정렬
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // 수평 가운데 정렬
			for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
				table.getColumnModel().getColumn(i).setPreferredWidth(128);
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}

			setItem(item_count);

			setSize(getWidth(), getHeight() + 3);
			this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.setViewportView(table);
		}

		public void refresh(int item_count) {
			setItem(item_count);
		}

		public void setItem(int item_count) {
			try {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount = tableModel.getRowCount();
				while (rowCount != 0) {
					tableModel.removeRow(0);
					rowCount--;
				}
				Vector<ItemDTO> data = new Vector<>();
				ItemDAO itemDAO = new ItemDAO();
				data = itemDAO.itemRental();
				for (int i = 0, j = 0; i < item_count; j++) {
					if (data.size() == j) {
						break;
					}
					ItemDTO item = data.get(j);
					Object[] newData;
					if (item.getState().equals("대여중")) {
						newData = new Object[] { Integer.toString(item.getItemnumber()), item.getItemname(),
								item.getRentdate() };
						tableModel.addRow(newData);
						i++;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static public class reportDetailTable extends base_itemSlot {
		/*
		 * 신고 내역 패널에 사용될 JTable
		 */
		private static final long serialVersionUID = 1L;

		public reportDetailTable(int x, int y, int width, int height) {
			setBounds(x, y, width, height);
			getViewport().setBackground(new Color(243, 246, 249));

			table = new MyTA_report();
			table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "", "", "", "" }) {
				Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.setRowHeight(60); // 각 행의 높이 설정

			// 가운데 정렬
			int columnSize[] = { 50, 50, 360, 50 };
			for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
				table.getColumnModel().getColumn(i).setPreferredWidth(columnSize[i]);
			}

			initJTableStyle(table, height, 10, false);

			this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
			this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
			this.setViewportView(table);
		}

		public void setItem() {
			try {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount = tableModel.getRowCount();
				while (rowCount != 0) {
					tableModel.removeRow(0);
					rowCount--;
				}
				Vector<ReportDTO> data = new Vector<>();
				ReportDAO reportDAO = new ReportDAO();
				data = reportDAO.loginIDReportData();
				if (data == null)
					return;
				for (ReportDTO item : data) {
					Object[] newData;
					newData = new Object[] { Integer.toString(item.getReportNum()),
							Integer.toString(item.getItemNumber()), item.getItemName(), item.getStatus() };
					tableModel.addRow(newData);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class My_KL extends KeyAdapter {
		/*
		 * JTable 에서 Enter 입력을 변경 Enter 입력이 되었을 경우 goDetail 함수를 호출
		 */

		boolean pressed = false;

		@Override
		public void keyPressed(KeyEvent e) {
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
			if (e.getKeyChar() == '\n' && pressed) {
				pressed = false;
			}
		}

	}

	static class My_ML extends MouseAdapter {

		/*
		 * JTable 에서 MouseAdapter 를 추가 더블 클릭을 통해서 해당 항목의 goDetail 함수를 호출
		 */

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) { // 더블 클릭했을 경우
				if (e.getSource() instanceof BaseTableComponent) { // JTable 인 경우
					BaseTableComponent baseTableComponent = (BaseTableComponent) e.getSource();
					baseTableComponent.goDetail();
				}
			}
		}
	}
}