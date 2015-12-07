package com.centralstock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "request_order")
public class RequestOrder implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "r_id")
	@GeneratedValue
	private int rid;

	@Column(name = "institution_name")
	private String insName;
	
	@Column(name = "order_date")
	private String orderedDate;
	
	@Column(name = "ordered_person")
	private String orderedPerson;

	

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getOrderedPerson() {
		return orderedPerson;
	}

	public void setOrderedPerson(String orderedPerson) {
		this.orderedPerson = orderedPerson;
	}
	
}
