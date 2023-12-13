package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import JDBC.ReportDAO;
import JDBC.ReportDTO;

public class Report_Details extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JTable table;
	private JButton Bt_Back;
	private JPanel contentpane;

	// 벡터로 컬럼 이름과 데이터 정의
	Vector<String> columnNames;
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();

	protected My_Page_Panel mpp;

	public Report_Details() {
		setBackground(new Color(255, 255, 255));
		setBounds(0, 150, 1050, 562);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("신고 접수/내역");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel.setBounds(30, 171, 140, 46);
		add(lblNewLabel);

		// 컬럼 이름을 벡터로 초기화
		columnNames = new Vector<>();
		columnNames.add("순번");
		columnNames.add("물품코드");
		columnNames.add("물품명");
		columnNames.add("처리상태");

		// 데이터를 벡터의 벡터로 초기화
		// 임시로 데이터 넣어놨음
		ReportDAO reportDAO = new ReportDAO();
		Vector<ReportDTO> reportData = reportDAO.allReportData();
		for (int i = 0; i < reportData.size(); i++) {
			Vector<Object> row = new Vector<>();
			row.add(reportData.get(i).getReportNum());
			row.add(reportData.get(i).getItemNumber());
			row.add(reportData.get(i).getItemName());
			row.add(reportData.get(i).getStatus());
			data.add(row);
		}

		// DefaultTableModel에 데이터와 컬럼 이름을 설정
		NonEditableTableModel nonEditableModel = new NonEditableTableModel(data, columnNames);

		// JTable에 모델을 설정 // 내용 수정 불가 테이블 모델
		table = new JTable();
		table.setModel(nonEditableModel);
		table.setShowVerticalLines(false);
		table.setRowSelectionAllowed(false);
		table.setBounds(176, 243, 698, 291);
		table.setRowHeight(60); // 각 행의 높이 설정
		table.getTableHeader().setReorderingAllowed(false); // 열 위치 드래그해서 바꿔지는 기능 비활성화

		JTableHeader header = table.getTableHeader();

		// 헤더의 배경색, 텍스트 정렬을 설정할 수 있는 메소드
		header.setDefaultRenderer(new DefaultTableCellRenderer() {

			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
						column);
				label.setBackground(Color.WHITE); // 헤더의 배경색을 흰색으로 설정
				label.setHorizontalAlignment(JLabel.CENTER); // 헤더 내 텍스트 중앙 정렬
				label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK)); // 헤더 칸 하단에 윤곽선을 설정
				return label;
			}
		});

		// 테이블 내 텍스트 가운데 정렬을 위한 렌더러 설정
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // 가운데 정렬

		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setPreferredWidth(128); // 첫 번째 열 너비 설정
			columnModel.getColumn(i).setCellRenderer(centerRenderer);
		}

		// 테이블을 스크롤 패널에 추가하고 스크롤 패널을 패널에 추가
		// 스크롤 패널이 아닌 그냥 추가 add(table) 하면 열 제목이 안보여서 스크롤 패널 사용했음
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(176, 243, 698, 260);

		add(scrollPane);

		Bt_Back = new RoundButton("뒤로");
		Bt_Back.setBounds(937, 518, 62, 23);
		Bt_Back.addActionListener(this);
		add(Bt_Back);

		contentpane = new JPanel();
		contentpane.setBounds(0, 150, 1050, 562);
		add(contentpane);
	}

	public Report_Details(My_Page_Panel mpp) {
		this();
		this.mpp = mpp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Bt_Back) {

			Main_frame.Changepane("마이페이지");
		}
	}
}
