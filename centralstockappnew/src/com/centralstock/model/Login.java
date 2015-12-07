package com.centralstock.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "inst_name")
	private String insName;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "user_pw")
	private String userPw;

	

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	

	
}
