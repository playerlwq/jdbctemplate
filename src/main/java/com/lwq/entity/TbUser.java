package com.lwq.entity;

import com.lwq.base.BaseEntity;
import com.lwq.base.IdEntity;

public class TbUser extends BaseEntity {

	
	private String username;
	private String password;
	private String phone;
	private String email;
	private String created;
	private String updated;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	
	
	public TbUser() {
		// TODO Auto-generated constructor stub
	}
	public TbUser(String username, String password, String phone, String email,
			String created, String updated) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.created = created;
		this.updated = updated;
	}
	
	
	
	
}
