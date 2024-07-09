package com.example.demo;

public class Member {
	private String name;
	private String id;
	private String password;
	private int age;
	private String address;
	private String phone;
	
	public Member(String name, String id, String password, int age, String address, String phone) {
		this.name=name;
		this.id=id;
		this.password=password;
		this.age=age;
		this.address=address;
		this.phone=phone;
	}
	
	public void setMember(String name, String id, String password, int age, String address, String phone) {
		this.name=name;
		this.id=id;
		this.password=password;
		this.age=age;
		this.address=address;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
