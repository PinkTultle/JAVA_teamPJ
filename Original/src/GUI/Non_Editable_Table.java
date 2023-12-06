package GUI;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

// 신고 접수/내역 패널에서 벡터로 만든 테이블의 내용을 사용자가 임의로 수정하지 못하게 하는
// 테이블 내용 수정 불가 클래스
class NonEditableTableModel extends DefaultTableModel {

	NonEditableTableModel(Vector<Vector<Object>> data, Vector<String> columnNames) {
		super(data, columnNames);
	}

	@Override
	public boolean isCellEditable(int row, int column) {
		// 모든 셀을 수정할 수 없게 함
		return false;
	}
}