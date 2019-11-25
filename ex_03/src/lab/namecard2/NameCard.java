package lab.namecard2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NameCard implements Serializable {

	private String name;
	private String phone;
	private String email;
//	private String company;
//	private String field;
//	private String title;
//	private String address;

	public NameCard(String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
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
	
	public void showInfo() {
		System.out.printf("[%s][%s][%s]\n", name, phone, email);
	}

}
