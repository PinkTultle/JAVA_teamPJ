package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ReportDAO {
	String url = "jdbc:oracle:thin:@115.140.208.29:1521:xe";

	//String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String user = "ABC"; // db 사용자 이름
	String password = "1234"; // db

	public Connection getConn() throws ClassNotFoundException {
		Connection conn = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			// System.out.println("로그인 성공");

		} catch (SQLException e) {
			System.out.println("DB 로그인 실패");
		}
		return conn; // 오라클 로그인 연결 정보
	}

	public Vector<ReportDTO> allReportData() {
		Vector<ReportDTO> list = new Vector<ReportDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳

		String sql = "SELECT * FROM 신고기록";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportDTO dto = new ReportDTO();
				dto.setReportNum(rs.getInt("신고번호"));
				dto.setItemNumber(rs.getInt("물품코드"));
				dto.setItemName(rs.getString("물품명"));
				dto.setCategory(rs.getString("신고분류"));
				dto.setStatus(rs.getString("처리상태"));
				dto.setReportDetail(rs.getString("신고메세지"));

				list.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertReport(Vector<String> v) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT MAX(신고번호) FROM 신고기록";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			rs.next();

			sql = "INSERT INTO 신고기록 (신고번호, 물품코드, 물품명, 신고분류, 처리상태, 신고메세지) " + "VALUES (?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rs.getInt(1) + 1);
			pstmt.setInt(2, Integer.parseInt(v.get(0)));
			pstmt.setString(3, v.get(1));
			pstmt.setString(4, v.get(2));
			pstmt.setString(5, "처리중");
			pstmt.setString(6, v.get(3));

			rs = pstmt.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
