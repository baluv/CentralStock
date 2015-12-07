package com.centralstock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distribution_details_items")
public class DistributionList implements Serializable {

	private static final long serialVersionUID = 451231L;

	@Column(name = "d_id")
	private int did;

	@Id
	@GeneratedValue
	@Column(name = "sno")
	private int sno;

	@Column(name = "category")
	private String category;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "quantity")
	private double quantity;

	@Column(name = "units")
	private String units;
	
	@Column(name="institution_name")
	private String insName;
	
	@Column(name="issued_date")
	private String issuedDate;

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
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



}
