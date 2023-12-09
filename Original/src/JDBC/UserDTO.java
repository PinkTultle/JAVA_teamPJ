package JDBC;

public class UserDTO { // 로그인 ,회원가입 등 유저 정보
	
	private String loginid;

	private String id;
	private String pw;
	private String nickname;
	private String name;
	private int birth; // ex) 19960519
	private String gender; // 남성, 여성으로 입력해야 db 오류 안남
	private int tel; // ex) 01012345678
	private String address;
	private String email;
	private String rentalstatus; // ex) 대여가능, 대여중
	private String bank; // ex) 하나은행
	private int accountnumber; // ex) 1357924684
	private int Administrator; //관리자 여부 0 : 일반 사용자, 1 : 관리자
	private int milerege;

	public UserDTO() {
		super();
	}


	public UserDTO(String id, String pw, String nickname, String name, int birth, String gender, int tel,
			String address, String email, String rentalstatus, String bank, int accountnumber, int Administrator) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
		this.rentalstatus = rentalstatus;
		this.bank = bank;
		this.accountnumber = accountnumber;
		this.Administrator = Administrator;
	}
	
	public UserDTO(String id, String pw, String nickname, String name, int birth, String gender, int tel,
			String address, String email, int Administrator) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.Administrator = Administrator;
	}
	
	
	
	public int getMilerege() {
		return milerege;
	}


	public void setMilerege(int milerege) {
		this.milerege = milerege;
	}


	public int getMileage() {
		return milerege;
	}

	public void setMileage(int mileage) {
		this.milerege = mileage;
	}

	public int getAdministrator() {
		return Administrator;
	}
	
	public void setAdministrator(int Administrator) {
		this.Administrator = Administrator;
	}
	
	public String getLoginid() {
		return loginid;
	}


	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRentalstatus() {
		return rentalstatus;
	}
	public void setRentalstatus(String rentalstatus) {
		this.rentalstatus = rentalstatus;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", tel=" + tel + ", address=" + address + ", email=" + email
				+ ", rentalstatus=" + rentalstatus + ", bank=" + bank + ", accountnumber=" + accountnumber + "]";
	}
	
	
	
	
	
}




