package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class UserDAO implements AutoCloseable { // 회원 관련 db 기능

	// String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	//String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 안되면 이걸로!
	String url = "jdbc:oracle:thin:@115.140.208.29:1521:xe";

	String user = "ABC"; // db 사용자 이름
	String password = "1234"; // db
	public static String user_cur;

	Connection conn = null, con;

	ResultSet rs;
	PreparedStatement pstmt;

	public UserDAO() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("DB 로그인 성공");

		} catch (SQLException e) {
			System.out.println("DB 로그인 실패");
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 없음");
		}

	}

	public Connection getConn() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);

			System.out.println("DB 로그인 성공");

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("DB 로그인 실패");
		}
		return conn; // 오라클 로그인 연결 정보
	}

	// 이부분 관리자 권한 확인해서 닽이 반환하도록 수정 필요
	public int checkLogin(UserDTO dto) throws SQLException { // 로그인

		String sql = " SELECT * FROM 회원 WHERE 아이디 = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("비밀번호").equals(dto.getPw())) {

					int Administrator = rs.getInt("관리자여부");
					dto.setAdministrator(Administrator);

					return Administrator; // 로그인 성공
				} else {
					return -3; // 비밀번호 불일치
				}
			}
			return -1; // 아이디 없음

		} catch (Exception e) {
			System.out.print(e.getMessage());
			return -2; // db 오류
		} finally {
			if(rs != null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn != null)  conn.close();
		}

	}

	public int userIdCheck(String id) throws SQLException, ClassNotFoundException { // 회원가입때 아이디 중복 체크

		String sql = " SELECT * FROM 회원 WHERE 아이디 = ? ";

		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);

		rs = pstmt.executeQuery(); //

		if (rs.next()) {
			return 1; // 같은 아이디가 있을경우
		}

		return 0; // 같은 아이디가 없을경우
	}

	public int userInsert(UserDTO dto) throws SQLException { // 회원가입
		int rs = 0;
		String sql = " INSERT INTO 회원 (아이디, 비밀번호, 별명, 이름, 생년월일, 성별, 전화번호, 주소, 이메일, 대여상태 ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, '대여가능') ";

		String tel1 = Integer.toString(dto.getTel()).substring(0, 4); // 전화번호 중간 4자리
		String tel2 = Integer.toString(dto.getTel()).substring(4); // 전화번호 마지막 4자리

		String tel = "010-" + tel1 + "-" + tel2;

		String tmp = Integer.toString(dto.getBirth());
		if (tmp.length() < 8)
			tmp = "0" + tmp;
		String bir = tmp.substring(0, 4) + "-" + tmp.substring(4, 6) + "-" + tmp.substring(6, 8);

		try {

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, bir);
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, tel);
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getEmail());

			rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			// if(e.getErrorCode()==1) {
			// System.out.println("아이디 중복!!");
			// return -1;
			// }
		} finally {
			pstmt.close();
		}
		return rs; // 리턴값 1이상이면 회원가입 성공, 0이면 실패

	}

	@Override
	public void close() throws Exception {
		// TODO 객체 참조가 끊어져 해당 클래스가 갈비지 컬럭터의 정리대상이 될때
		// 남은 리소스 헤제

		rs.close();
		pstmt.close();
		conn.close();
	}

	public int userUpdate(String[] data) throws SQLException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean c = false;
		int rs = 0;

		String sql = "UPDATE 회원 SET ";

		String[] column = { "비밀번호", "별명", "이름", "생년월일", "주소", "전화번호", "이메일", "성별" };

		for (int i = 0; i < column.length; i++) {
			if (data[i] == null) {
				continue;
			} else {
				if (!c)
					c = true;
				else
					sql += ", ";
				sql += column[i] + " = '" + data[i] + "' ";
			}
		}

		sql += "WHERE 아이디 = '" + user_cur + "'";

		try {

			con = getConn();

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmt.close();
			con.close();
		}

		return rs; // 프로필 수정
	}

	public UserDTO userSelect(String ID) {
		UserDTO userDTO = new UserDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT * FROM 회원 WHERE 아이디 = ? ";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();

			rs.next();

			userDTO.setId(rs.getString("아이디"));
			userDTO.setPw(rs.getString("비밀번호"));
			userDTO.setNickname(rs.getString("별명"));
			userDTO.setName(rs.getString("이름"));
			String bir, temp = rs.getString("생년월일");
			bir = temp.substring(0, 4) + temp.substring(5, 7) + temp.substring(8, 10);
			userDTO.setBirth(Integer.parseInt(bir));
			userDTO.setGender(rs.getString("성별"));
			userDTO.setAddress(rs.getString("주소"));
			String TEL;
			temp = rs.getString("전화번호");
			TEL = temp.substring(0, 3) + temp.substring(4, 8) + temp.substring(9, 13);
			userDTO.setTel(Integer.parseInt(TEL));
			userDTO.setEmail(rs.getString("이메일"));
			if (rs.getString("관리자여부") != null)
				userDTO.setAdministrator(1);
			else
				userDTO.setAdministrator(0);

			// 계좌번호 추가 필요

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userDTO;
	}

	public int userDelete() {
		int result = 0;
		try {
			Connection con = getConn();
			String sql = "DELETE FROM 회원 WHERE 아이디 = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_cur);
			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}
		return result;
	}

	// 유저 목록 불러오기
	public void userAll(DefaultTableModel model) {
		Connection con = null;
		try {
			con = getConn();
			Statement stmt = con.createStatement();
			String query = "SELECT 아이디, 이름, 전화번호, 관리자여부 FROM 회원";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("아이디"));
				String id = rs.getString("아이디");
				String name = rs.getString("이름");
				String tel = rs.getString("전화번호");
				int admin = rs.getInt("관리자여부");

				model.addRow(new Object[] { id, name, tel, admin });

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int milerege() {

		int m = 0;
		String sql = " SELECT 마일리지 FROM 회원 WHERE 아이디 = ? ";

		try {
			con = getConn();

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user_cur);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				m = rs.getInt("마일리지");
				System.out.println("마일리지 점수 : " + m);
			}
			
			con.close();
			pstmt.close();
			rs.close();
			
			return m;
		}
		catch(Exception e) {			
			return m;
		}
		
	}

	public boolean milerege_sum(String id) {

		String sql = "UPdate 회원 set 마일리지 = 마일리지+5 where 아이디 = ?";

		try {
			con = getConn();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

			con.close();
			pstmt.close();

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean admin_user_delete(String id) {

		String sql = "DELETE FROM 회원 WHERE 아이디 = ?";
		Connection con = null;
		try {
			con = getConn();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
