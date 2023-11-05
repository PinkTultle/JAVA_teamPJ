package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ItemDAO {
	
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
	
	
	public Vector<ItemDTO> allItemData() throws SQLException{ // GUI 설계_ver.2의 5번 슬라이드에 맞게 모든 물품 리스트 가져오기
		Vector<ItemDTO> list = new Vector<ItemDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //결과 담는 곳
		String sql = " SELECT 물품코드, 카테고리, 물품명, 소유주, (SELECT 렌트기한 - TRUNC(SYSDATE) FROM DUAL ) as 렌트기한, 대여상태 "
				+ " FROM 물품목록 ";
		
		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				
				// 여기에 ItemDTO 완성되면 rs 출력값 넣어주는거 작성해야함
				
				list.add(dto); // 리스트에 한줄 추가
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
