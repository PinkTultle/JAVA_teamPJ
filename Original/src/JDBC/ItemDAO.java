package JDBC;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class ItemDAO {

	// String url = "jdbc:oracle:thin:@192.168.124.100:1521:xe";
	String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 안되면 이걸로!
	// String url = "jdbc:oracle:thin:@115.140.208.29:1521:xe";

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
			sql += " 물품목록.물품명 LIKE '%" + itemName + "%'";
		}
		if (status != null) {
			if (category != null || itemName != null) {
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

	public ItemDTO itemdetail(int n) throws SQLException {
		ItemDTO itemdto = new ItemDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 모델명, 렌트기한, 대여료, 보증금, 전화번호, 설명, 첨부, 물품명, 별명, 아이디, 예약자, 물품목록.대여상태, 대여자 "
				+ " FROM 물품목록 " + " INNER JOIN 회원 ON 물품목록.소유주 = 회원.아이디 " + " WHERE 물품코드 = ? ";
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
				itemdto.setRentdate(rs.getString("렌트기한"));
				itemdto.setBookingGuest(rs.getString("예약자"));
				itemdto.setLender(rs.getString("대여자"));
				itemdto.setState(rs.getString("대여상태"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemdto;
	}

	public Vector<ItemDTO> itemRental() throws SQLException { // RentHistory
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 소유자, 물품명, (SELECT 대여반납예정일 - 대여시작날짜 FROM DUAL ) as 렌트기한, 대여시작날짜, 대여반납예정일, 반납상태, 대여번호 "
				+ " FROM 대여기록 " + " WHERE 대여자 = ? ";
		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserDAO.user_cur); // 로그인된 아이디 가져오기
			System.out.println(sql + UserDAO.user_cur);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setPerson(rs.getString("소유자"));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setRentdate(rs.getString("렌트기한"));
				itemdto.setState(rs.getString("반납상태"));
				itemdto.setRentdate_start(rs.getString("대여시작날짜"));
				itemdto.setRentdate_end(rs.getString("대여반납예정일"));
				itemdto.setRentNum(rs.getInt("대여번호"));

				list.add(itemdto); // 리스트에 한줄 추가
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Vector<ItemDTO> itemRental_detail(int itemNum) {
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳
		String sql = " SELECT 물품코드, 물품명, 대여시작날짜, 대여반납예정일, 소유자, 대여자, 반납상태" + " FROM 대여기록 " + " WHERE 물품코드 = ? ";
		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, itemNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setRentdate_start(rs.getString("대여시작날짜"));
				itemdto.setRentdate_end(rs.getString("대여반납예정일"));
				itemdto.setPerson(rs.getString("소유자"));
				itemdto.setLender(rs.getString("대여자"));
				itemdto.setState(rs.getString("반납상태"));

				list.add(itemdto); // 리스트에 한줄 추가
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Vector<ItemDTO> item_receive_sending(String s) throws SQLException { // OfferManage
		Vector<ItemDTO> list = new Vector<ItemDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 결과 담는 곳

		String sql = "";
		if (s.equals("receive")) {
			sql = " SELECT 물품코드, 물품명, CONCAT(CONCAT(대여시작날짜, ' ~ '), 대여반납예정일) 요청기한, 대여번호 " + " FROM 대여기록 "
					+ " WHERE 소유자 = ? AND 반납상태 = '대기중' ";

		} else if (s.equals("sending")) {
			sql = " SELECT 물품코드, 물품명, CONCAT(CONCAT(대여시작날짜, ' ~ '), 대여반납예정일) 요청기한 " + " FROM 대여기록 " + " WHERE 대여자 = ? ";
		}

		try {
			con = getConn();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, UserDAO.user_cur); // 로그인된 아이디 가져오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ItemDTO itemdto = new ItemDTO();
				itemdto.setItemnumber(Integer.parseInt(rs.getString("물품코드")));
				itemdto.setItemname(rs.getString("물품명"));
				itemdto.setRentdate(rs.getString("요청기한"));
				if (s.equals("receive"))
					itemdto.setRentNum(rs.getInt("대여번호"));

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
			String sql = "SELECT * FROM 물품목록 WHERE 물품코드 = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Integer.toString(n));
			rs = pstmt.executeQuery();
			rs.next();
			if (rs.getString("대여상태").equals("대여중"))
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

	public int checkOffer(int itemNum, LocalDate d1, LocalDate d2) {
		/*
		 * -1: 처리되지 않은 오류 0: 성공 1: 해당 기간에 예약자가 있음
		 */
		try {
			// 신청하기 전에 마지막으로 성태를 확인
			ItemDTO itemData = this.itemdetail(itemNum);
			Vector<ItemDTO> data1 = this.itemRental_detail(itemNum);
			// 예약자가 있는지 확인
			if (data1.size() != 0) {
				// 대여기한 및 대여자를 최신화하는 작업이 필요함
				if (changeDate(data1.get(0).getRentdate_start()).isAfter(d2)
						|| changeDate(data1.get(data1.size() - 1).getRentdate_end()).isBefore(d1)) {
					// 기존의 대여와 관계가 없는 경우
					// 삽입 연산 필요
					System.out.println(data1.get(0).getRentdate_start() + " " + d2 + " "
							+ changeDate(data1.get(0).getRentdate_start()).isAfter(d2));
					return 0;
				}
				for (int i = 0; i < data1.size() - 1; i++) {
					LocalDate e, s;
					e = changeDate(data1.get(i).getRentdate_end());
					s = changeDate(data1.get(i + 1).getRentdate_end());
					if (e.isAfter(d1))
						break;
					if (e.isBefore(d1) & s.isAfter(d2)) {
						// 다른 대여들 사이에 들어갈수 있는 경우
						// 삽입 연산 필요
						System.out.println("사이");
						return 0;
					}
				}
				return 1;
			}
			// 다른 대여자가 없는 상황
			// 삽입 연산 필요
			System.out.println("없음");
			return 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public LocalDate changeDate(String d) {
		return LocalDate.of(Integer.parseInt(d.substring(0, 4)), Integer.parseInt(d.substring(5, 7)),
				Integer.parseInt(d.substring(8, 10)));
	}

	public int sendingOffer(ItemDTO data, LocalDate d1, LocalDate d2) {
		try {
			String sql = "INSERT INTO 대여기록 (대여번호 ,물품코드, 물품명, 대여시작날짜, 대여반납예정일, 소유자, 대여자, 반납상태) "
					+ "VALUES (대여_seq.nextval,?, ?, ?, ?, ?, ?, ?) ";
			Connection con = getConn();
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, data.getItemnumber());
			pstmt.setString(2, data.getItemname());
			pstmt.setDate(3, java.sql.Date.valueOf(d1));
			pstmt.setDate(4, java.sql.Date.valueOf(d2));
			pstmt.setString(5, data.getPerson());
			pstmt.setString(6, UserDAO.user_cur);
			pstmt.setString(7, "대기중");

			pstmt.executeQuery();

			sql = "UPDATE 물품목록 SET 대여상태 = ? WHERE 물품코드 = ? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "승인대기");
			pstmt.setInt(2, data.getItemnumber());

			pstmt.executeQuery();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 1;
		}

		return 0;
	}

	public int returnItem(int offerNum, int itemNum) {
		int result = 0;
		try {
			Connection con = getConn();
			String sql = "UPDATE 대여기록 SET 반납상태 = ? WHERE 대여번호 = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "반납");
			pstmt.setInt(2, offerNum);

			pstmt.executeQuery();

			sql = "UPDATE 물품목록 SET 대여상태 = ? WHERE 물품코드 = ? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "대여가능");
			pstmt.setInt(2, itemNum);
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}

		return result;
	}

	public ItemDTO getOffer(int offerNum) {
		ItemDTO result = new ItemDTO();
		try {
			Connection con = getConn();
			String sql = "SELECT * FROM 대여기록 WHERE 대여번호 = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, offerNum);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result.setRentNum(rs.getInt("대여번호"));
				result.setItemnumber(rs.getInt("물품코드"));
				result.setItemname(rs.getString("물품명"));
				result.setRentdate_start(rs.getString("대여시작날짜"));
				result.setRentdate_end(rs.getString("대여반납예정일"));
				result.setPerson(rs.getString("소유자"));
				result.setLender(rs.getString("대여자"));
				result.setState(rs.getString("반납상태"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		}
		return (result);
	}

	public int acceptOffer(int offerNum, int mode) {
		// 0: 승인 | 1: 거절
		int result = 0;
		try {
			ItemDTO offerData = this.getOffer(offerNum);
			if (!offerData.getState().equals("대기중"))
				return 1;
			String sql = "UPDATE 물품목록 SET 대여상태 = ?, 대여자 = ? WHERE 물품코드 = ? ";
			String state = "대여중";

			Connection con = getConn();
			PreparedStatement pstmt = con.prepareStatement(sql);

			if (mode == 1) {
				state = "대여가능";
				pstmt.setNull(2, java.sql.Types.NULL);
			} else {
				pstmt.setString(2, offerData.getLender());
			}

			pstmt.setString(1, state);
			pstmt.setInt(3, offerData.getItemnumber());

			pstmt.executeQuery();

			sql = "UPDATE 대여기록 SET 반납상태 = ? WHERE 대여번호 = ?";
			pstmt = con.prepareStatement(sql);
			if (mode == 1)
				state = "대여거부";
			pstmt.setString(1, state);
			pstmt.setInt(2, offerNum);

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 물뭄 목록 불러오기
	public void itemAll(DefaultTableModel model) throws Exception {
		Connection con = null;
		try {
			con = getConn();
			Statement stmt = con.createStatement();
			String query = "SELECT 물품코드,카테고리,물품명,소유주, 대여상태 FROM 물품목록";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				int itemNum = rs.getInt("물품코드");
				String category = rs.getString("카테고리");
				String itemName = rs.getString("물품명");
				String admin = rs.getString("소유주");
				String state = rs.getString("대여상태");

				model.addRow(new Object[] { itemNum, category, itemName, admin, state });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int extendOffer(int rentNum, LocalDate d) {
		int result = 0;
		try {
			String sql = "UPDATE 대여기록 SET 대여반납예정일 = ? WHERE 대여번호 = ? ";
			Connection con = getConn();
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setDate(1, Date.valueOf(d));
			pstmt.setInt(2, rentNum);

			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}
		return (result);
	}

	public int insertItem(ItemDTO data) {
		int result = 0;
		try {
			String sql = "INSERT INTO 물품목록 (물품코드, 카테고리, 물품명, 렌트기한, 모델명, 대여료, 보증금, 설명, 소유주, 대여상태, 예약자, 대여자, 첨부) VALUES (물품_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			Connection con = getConn();
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, data.getCategory());
			pstmt.setString(2, data.getItemname());
			pstmt.setDate(3, Date.valueOf(changeDate(data.getRentdate())));
			pstmt.setString(4, data.getModelname());
			pstmt.setInt(5, data.getRentalfee());
			pstmt.setInt(6, data.getDeposit());
			pstmt.setString(7, data.getExplanation());
			pstmt.setString(8, data.getPerson());
			pstmt.setString(9, "대여가능");
			pstmt.setNull(10, java.sql.Types.NULL);
			pstmt.setNull(11, java.sql.Types.NULL);
			pstmt.setNull(12, java.sql.Types.NULL);

			System.out.println(sql);

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
			result = 1;
		}

		return result;
	}
}