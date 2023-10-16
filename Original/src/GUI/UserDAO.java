package GUI;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO { // 회원 관련 db 기능 
	
	String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	//String url = "jdbc:oracle:thin:@localhost:1521:xe"; 안되면 이걸로!
	
	String user = "ABC";       // db 사용자 이름
	String password = "1234";  // db 
	
	
	public Connection getConn() throws ClassNotFoundException {		
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			//System.out.println("로그인 성공");
			
		} catch (SQLException e) {
			System.out.println("DB 로그인 실패");
		}
		return conn;   // 오라클 로그인 연결 정보
	}
	
	
	public int checkLogin(UserDTO dto) throws SQLException {
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
	
		

}


