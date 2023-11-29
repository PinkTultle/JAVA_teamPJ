package JDBC;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ItemDAO {

	// String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 안되면 이걸로!

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

	public Vector<ItemDTO> allItemData() throws SQLException { // GUI 설계_ver.2의 5번 슬라이드에 맞게 모든 물품 리스트 가져오기
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 카테고리, 물품명, 소유주, (SELECT 렌트기한 - TRUNC(SYSDATE) FROM DUAL ) as 렌트기한, 대여상태 "
				+ " FROM 물품목록 ";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemnumber(Integer.valueOf(rs.getString("물품코드")));
				dto.setCategory(rs.getString("카테고리"));
				dto.setItemname(rs.getString("물품명"));
				dto.setPerson(rs.getString("소유주"));
				dto.setRentdate(rs.getString("렌트기한"));
				dto.setState(rs.getString("대여상태"));

				// 여기에 ItemDTO 완성되면 rs 출력값 넣어주는거 작성해야함

				list.add(dto); // 리스트에 한줄 추가
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Vector<ItemDTO> searchItemData(String category, String itemName, String status) throws SQLException {
		System.out.println("searchItemData");
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT 물품목록.물품코드, 물품목록.카테고리, 물품목록.물품명, 회원.별명, (SELECT 물품목록.렌트기한 - TRUNC(SYSDATE) FROM DUAL ) as 렌트기한, 물품목록.대여상태 "
				+ " FROM 물품목록 " + " INNER JOIN 회원 ON 물품목록.소유주 = 회원.아이디 ";
		if (category != null || itemName != null || status != null) {
			sql += "WHERE";
		}
		if (category != null) {
			sql += " 물품목록.카테고리 = '" + category + "'";
		}
		if (itemName != null) {
			if (category != null) {
				sql += " AND ";
			}
			sql += " 물품목록.물품명 = '" + itemName + "'";
		}
		if (status != null) {
			if (category != null && itemName != null) {
				sql += " AND ";
			}
			sql += " 물품목록.대여상태 = '" + status + "'";
		}

		System.out.println(sql);

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemnumber(Integer.valueOf(rs.getString("물품코드")));
				dto.setCategory(rs.getString("카테고리"));
				dto.setItemname(rs.getString("물품명"));
				dto.setPerson(rs.getString("별명"));
				dto.setRentdate(rs.getString("렌트기한"));
				dto.setState(rs.getString("대여상태"));

				// 여기에 ItemDTO 완성되면 rs 출력값 넣어주는거 작성해야함

				list.add(dto); // 리스트에 한줄 추가
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ItemDTO itmedetail(int n) throws SQLException {
		ItemDTO itemdto = new ItemDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 모델명, 렌트기한, 대여료, 보증금, 전화번호, 설명, 첨부, 물품명, 별명, 아이디 " + " FROM 물품목록 "
				+ " INNER JOIN 회원 ON 물품목록.소유주 = 회원.아이디 " + " WHERE 물품코드 = ? ";
		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(n));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setModelname(rs.getString("모델명"));
				itemdto.setRentdate(rs.getString("렌트기한"));
				itemdto.setRentalfee(Integer.parseInt(rs.getString("대여료")));
				itemdto.setDeposit(Integer.parseInt(rs.getString("보증금")));
				itemdto.setPhonenumber(rs.getString("전화번호"));
				itemdto.setExplanation(rs.getString("설명"));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setNickname(rs.getString("별명"));
				itemdto.setPerson(rs.getString("아이디"));
				itemdto.setImage(rs.getString("첨부"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemdto;
	}

	public Vector<ItemDTO> itemRental() throws SQLException { // RentHistory
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		// 테스트

		UserDTO ud = new UserDTO();
		// 개발 중 사용할 아이디 | 완료 후에는 아래의 코드로 변경 필요
		// ud.setLoginid("asd4");
		ud.setLoginid(UserDAO.user_cur);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 소유자, 물품명, (SELECT 대여반납예정일 - 대여시작날짜 FROM DUAL ) as 렌트기한, 반납상태 " + " FROM 대여기록 "
				+ " WHERE 대여자 = ? ";

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ud.getLoginid()); // 로그인된 아이디 가져오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setPerson(rs.getString("소유자"));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setRentdate(rs.getString("렌트기한"));
				itemdto.setState(rs.getString("반납상태"));

				list.add(itemdto); // 리스트에 한줄 추가
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Vector<ItemDTO> item_receive_sending(String s) throws SQLException { // OfferManage
		Vector<ItemDTO> list = new Vector<ItemDTO>();
		ItemDTO itemdto = new ItemDTO();

		// 테스트

		UserDTO ud = new UserDTO();
		// ud.setLoginid("asd1"); // 로그인 아이디 가져오기
		ud.setLoginid(UserDAO.user_cur);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳

		String sql = "";
		if (s.equals("receive")) {
			sql = " SELECT 물품코드, 물품명, CONCAT(CONCAT(대여시작날짜, ' ~ '), 대여반납예정일) 요청기한 " + " FROM 대여기록 " + " WHERE 소유자 = ? ";

		} else if (s.equals("sending")) {
			sql = " SELECT 물품코드, 물품명, CONCAT(CONCAT(대여시작날짜, ' ~ '), 대여반납예정일) 요청기한 " + " FROM 대여기록 " + " WHERE 대여자 = ? ";
		}

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ud.getLoginid()); // 로그인된 아이디 가져오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setRentdate(rs.getString("요청기한"));

				list.add(itemdto); // 리스트에 한줄 추가
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public void displayImage(String imagePath, JLabel imageLabel) { // 물품 상세 사진
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image = imageIcon.getImage();

		// 이미지 크기 조정 (원하는 크기로 수정 가능)
		Image scaledImage = image.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

		// 조정된 이미지를 ImageIcon으로 변환
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		// ImageIcon을 JLabel에 설정
		imageLabel.setIcon(scaledIcon);
	}

	public boolean deleteItem(int n) {
		// true: 성공 | false: 실패
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = getConn();
			String sql = "SELECT * FROM 대여기록 WHERE 물품코드 = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(n));
			rs = pstmt.executeQuery();
			if (rs.next())
				return false;
			sql = "DELETE FROM 신고기록 WHERE 물품코드 = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(n));
			pstmt.executeQuery();
			sql = "DELETE FROM 물품목록 WHERE 물품코드 = ? ";
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(n));
			pstmt.executeQuery();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}