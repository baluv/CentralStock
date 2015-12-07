package com.centralstock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "consumption_details")
public class Consumption implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "c_id")
	@GeneratedValue
	private int cid;
	
	@Column(name ="institution_name")
	private String insName;
	
	@Column(name ="issued_date")
	private String issuedDate;
	
	@Column(name ="entered_person")
	private String enteredby;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getEnteredby() {
		return enteredby;
	}

	public void setEnteredby(String enteredby) {
		this.enteredby = enteredby;
	}

	
	
	
}
