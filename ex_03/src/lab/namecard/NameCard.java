package lab.namecard;

public class NameCard {
	
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		String info = 
			String.format("[%3d][%s][%s][%s]", no, name, phone, email);
		return info;
	}

}
