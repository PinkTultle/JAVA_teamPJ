package GUI;

public class User {
	String ID;
	String Passward;
	String Name;
	String TEL;
	String Address;
	boolean Adminster = false;
	int CreditRating = 0;

	public User(String id, String passward, String name, String tel, String address) {
		this.ID = id;
		this.Passward = passward;
		this.Name = name;
		this.TEL = tel;
		this.Address = address;
	}

	public User() {
	}

	public void setAdminster(boolean adminster) {
		Adminster = adminster;
	}

	public void setCreditRating(int creditrating) {
		CreditRating = creditrating;
	}
}
