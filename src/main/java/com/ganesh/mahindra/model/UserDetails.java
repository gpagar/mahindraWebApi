package com.ganesh.mahindra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	int userId;

	@Column(name = "name")
	String name;

	@Column(name = "email")
	String email;

	@Column(name = "password")
	String password;

	@Column(name = "contact")
	String contact;

	@Column(name = "photo")
	String photo;

	@Column(name = "type")
	int type;

	@Column(name = "delStatus")
	int delStatus;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contact=" + contact + ", photo=" + photo + ", type=" + type + ", delStatus=" + delStatus + "]";
	}

	
	
}
