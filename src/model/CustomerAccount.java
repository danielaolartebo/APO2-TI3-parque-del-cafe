package model;

import java.io.Serializable;

public class CustomerAccount extends Visitor implements Serializable{

	private static final long serialVersionUID = 1;
	private String userName;
	private String password;
	private String name;
	private String gender;
	private int age;
	
	private Visitor firstVisitor;
	
	public CustomerAccount(String userName, String password, String name, String gender, int age) {
		super(name,age,gender);
		this.userName=userName;
		this.password=password;
		this.name=name;
		this.gender=gender;
		this.age=age;
		
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
	
	public String getGender() {
		return gender;
		}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getName() {
		return name;
		}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
		}

	public void setAge(int age) {
		this.age = age;
	}
	public void setFirstVisitor(Visitor first) {
		firstVisitor = first;
	}
	public Visitor getFirstVisitor() {
		return firstVisitor;
	}
}
