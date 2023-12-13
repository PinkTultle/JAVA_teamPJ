package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ReportDAO {

	// String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	//String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String url = "jdbc:oracle:thin:@115.140.208.29:1521:xe";

	String user = "ABC"; // db 사용자 이름
	String password = "1234"; // db

	public Connection getConn() throws ClassNotFoundException {
		Connection conn = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);


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

		String sql = "select * from 신고기록 order by (CASE WHEN 처리상태 = '신청' THEN 1 WHEN 처리상태 = '처리중' THEN 2 END), 신고번호 asc";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportDTO dto = new ReportDTO();
				dto.setPostID(rs.getString("작성자"));
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

			sql = "INSERT INTO 신고기록 (신고번호, 물품코드, 물품명, 신고분류, 처리상태, 신고메세지, 작성자) "
					+ "VALUES (신고_seq.nextval, ?, ?, ?, ?, ?, ?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(v.get(0)));
			pstmt.setString(2, v.get(1));
			pstmt.setString(3, v.get(2));
			pstmt.setString(4, "신청");
			pstmt.setString(5, v.get(3));
			pstmt.setString(6, UserDAO.user_cur);

			rs = pstmt.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public Vector<ReportDTO> loginIDReportData() {
		Vector<ReportDTO> list = new Vector<ReportDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM 신고기록 WHERE 작성자 = ?";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserDAO.user_cur);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReportDTO dto = new ReportDTO();
				dto.setPostID(rs.getString("작성자"));
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

	public ReportDTO reportNumData(int reportNum) {
		ReportDTO data = new ReportDTO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM 신고기록 WHERE 신고번호 = ?";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reportNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				data.setPostID(rs.getString("작성자"));
				data.setReportNum(rs.getInt("신고번호"));
				data.setItemNumber(rs.getInt("물품코드"));
				data.setItemName(rs.getString("물품명"));
				data.setCategory(rs.getString("신고분류"));
				data.setStatus(rs.getString("처리상태"));
				data.setReportDetail(rs.getString("신고메세지"));
				data.setAnswer(rs.getString("답변"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return data;
	}

	public boolean report_add_Answer(ReportDTO dto) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int up_row;
		String sql = "UPDATE 신고기록 SET 답변 = ? where 신고번호 = ?";

		try {

			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getAnswer());
			pstmt.setInt(2, dto.getReportNum());

			up_row = pstmt.executeUpdate();

			con.close();
			pstmt.close();

			if (up_row == 1)
				return true;
			else
				throw (null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

}
