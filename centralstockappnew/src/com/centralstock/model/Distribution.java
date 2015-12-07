package com.centralstock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribution_details")
public class Distribution implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1231L;

@Id
@Column(name = "d_id")
@GeneratedValue
private int did;

@Column(name="institution_name")
private String insName;

@Column(name="issued_date")
private String issuedDate;

@Column(name="received_person")
private String receivedperson;

public int getDid() {
	return did;
}

public void setDid(int did) {
	this.did = did;
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

public String getReceivedperson() {
	return receivedperson;
}

public void setReceivedperson(String receivedperson) {
	this.receivedperson = receivedperson;
}


}