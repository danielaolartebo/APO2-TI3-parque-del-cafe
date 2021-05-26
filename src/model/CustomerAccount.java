package model;

import java.io.Serializable;

public class CustomerAccount extends Visitor implements Serializable{

	private static final long serialVersionUID = 1;
	private String userName;
	private String password;
	
	public CustomerAccount(String userName, String password, String name, String gender, String age) {
		super(name,age,gender);
		this.userName=userName;
		this.password=password;
		
		}

	public String getUserName() {
		return userName;
		}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
