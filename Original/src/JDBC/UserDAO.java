package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO { // 회원 관련 db 기능 
	
	//String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; //안되면 이걸로!
	
	String user = "ABC";       // db 사용자 이름
	String password = "1234";  // db 
	
	
	public Connection getConn() throws ClassNotFoundException {		
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("DB 로그인 성공");
			
		} catch (SQLException e) {
			System.out.println("DB 로그인 실패");
		}
		return conn;   // 오라클 로그인 연결 정보
	}
	
	
	public int checkLogin(UserDTO dto) throws SQLException { // 로그인 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //결과 담는 곳
		String sql = " SELECT * FROM 회원 WHERE 아이디 = ? ";
		
		try {
			
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("비밀번호").equals(dto.getPw())) {
					return 0; // 로그인 성공
				}else {
					return 1; // 비밀번호 불일치
				}
			}
			return -1; // 아이디 없음
		
			
		} catch (Exception e) {
			return -2; // db 오류
		}finally {
			rs.close();
			pstmt.close();
			con.close();
		}
		
		
		
		
	}
	
	public int userIdCheck(String id) throws SQLException { // 회원가입때 아이디 중복 체크 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs ; 
		String sql = " SELECT * FROM 회원 WHERE 아이디 = ? ";
		
		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery(); // 
			
			if(rs.next()) {
				return 1;  // 같은 아이디가 있을경우 
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;  // 같은 아이디가 없을경우 
	}
	
	public int userInsert(UserDTO dto) throws SQLException { // 회원가입
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0; 
		String sql = " INSERT INTO 회원 (아이디, 비밀번호, 별명, 이름, 생년월일, 성별, 전화번호, 주소, 이메일, 대여상태 ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, '대여가능') ";
		
		String tel1 = Integer.toString(dto.getTel()).substring(0, 4); // 전화번호 중간 4자리
		String tel2 = Integer.toString(dto.getTel()).substring(4); // 전화번호 마지막 4자리
		
		String tel = "010-"+ tel1 + "-"+ tel2;
		
		try {
			
			con = getConn();
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getName());
			pstmt.setInt(5, dto.getBirth());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, tel);
			pstmt.setString(8, dto.getAddress());
			pstmt.setString(9, dto.getEmail());
			

			rs = pstmt.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//if(e.getErrorCode()==1) {
			//	System.out.println("아이디 중복!!");
			//	return -1;
			//}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmt.close();
			con.close();
		}
		return rs; // 리턴값 1이상이면 회원가입 성공,  0이면 실패
		
		
	}
	
		

}


