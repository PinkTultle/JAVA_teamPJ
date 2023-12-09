package JDBC;

public class ItemDTO {

	private int itemnumber; // 물품코드
	private String category; // 카테고리
	private String itemname; // 물품명
	private String modelname; // 모델명
	private String person; // 소유주
	private String nickname;// 별명 | 회원 테이블
	private String rentdate; // ex) 2023-10-10
	private String rentdate_start; // 대여시작날짜
	private String rentdate_end; // 대여반납예정일
	private int rentalfee; // 대여료
	private int deposit; // 보증금
	private String explanation; // 설명
	private String state; // 대여상태
	private String phonenumber; // 전화번호
	private String image; // 이미지
	private String lender; // 대여자
	private String bookingGuest; // 예약자
	private int rentNum;

	public String getRentdate_end() {
		return rentdate_end;
	}

	public void setRentdate_end(String s) {
		rentdate_end = s;
	}

	public String getRentdate_start() {
		return rentdate_start;
	}

	public void setRentdate_start(String s) {
		rentdate_start = s;
	}

	public void setBookingGuest(String s) {
		bookingGuest = s;
	}

	public String getBookingGuest() {
		return bookingGuest;
	}

	public void setLender(String s) {
		lender = s;
	}

	public String getLender() {
		return lender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRentdate() {
		return rentdate;
	}

	public void setRentdate(String rentdate) {
		this.rentdate = rentdate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public int getRentalfee() {
		return rentalfee;
	}

	public void setRentalfee(int rentalfee) {
		this.rentalfee = rentalfee;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getRentNum() {
		return rentNum;
	}
	
	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}

}
