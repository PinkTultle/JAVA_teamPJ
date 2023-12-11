package JDBC;

import java.sql.*;
import java.util.*;

public class MyHistoryDTO {
	String url = "jdbc:oracle:thin:@115.140.208.29:1521:xe";

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
	
	
	   public Vector select() {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null; // 결과 담는 곳
			//String sql = "SELECT 물품코드, 물품명, 대여반납예정일, 반납상태 FROM 대여기록 ";
		    String sql = "select 물품코드, 카테고리, 물품명, 렌트기한, 대여상태 from 물품목록 where 대여자 = 'asd5'";
		    ArrayList<String> arr = new ArrayList<String>();
		    Vector<String> v2 = new Vector<>();
		    try {
		    	con = getConn();
		    	pstmt = con.prepareStatement(sql);
		    	rs = pstmt.executeQuery();
		      System.out.println("test");
		      while(rs.next()) {
		         v2.add(rs.getString(1));
		         v2.add(rs.getString(2));
		         v2.add(rs.getString(3));
		         v2.add(rs.getString(4));
		         v2.add(rs.getString(5));
		      }
		      
		      
		      
		      
		      
		      }catch(Exception e) {
		    	  e.printStackTrace();
		      }
		      return v2;
		   }
		      

}
