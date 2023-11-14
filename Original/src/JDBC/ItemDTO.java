package JDBC;

public class ItemDTO {

	private int itemnumber; // 물품코드
	private String category;
	private String itemname; // 물품명
	private String modelname; // 모델명
	private String person; // 소유주
	private String rentdate; // ex) 2023-10-10
	private int rentalfee; // 대여료
	private int deposit; // 보증금
	private String explanation; // 설명
	private String state; // 대여상태
	private String phonenumber; // 전화번호
	private String image; // 이미지
	
	
	
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
	
	
	
	
	
	
}
