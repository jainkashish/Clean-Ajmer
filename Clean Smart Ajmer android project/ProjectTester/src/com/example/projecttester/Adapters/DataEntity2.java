package com.example.projecttester.Adapters;

public class DataEntity2 {
	private int id;
	private String name;
	private String address;
	private String contact;
	private String email;
	private String ward;
	private String complaint;
	private String imagePath;

	public DataEntity2(int id, String name, String address, String contact,
			String email, String ward, String complaint, String imagePath) {
		this.setId(id);
		this.setName(name);
		this.setAddress(address);
		this.setContact(contact);
		this.setEmail(email);
		this.setWard(ward);
		this.setComplaint(complaint);
		this.setImagePath(imagePath);
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

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
