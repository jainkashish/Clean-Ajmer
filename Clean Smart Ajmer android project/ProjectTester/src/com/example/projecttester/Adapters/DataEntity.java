package com.example.projecttester.Adapters;

public class DataEntity {
	private int id;
	private String name;
	private String address;
	private String contact;
	private String email;
	private String password;
	
	public DataEntity(int id, String name, String address,  String contact,   String email, String password ){
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setContact(contact);
		this.setEmail(email);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
