package com.centralstock.model;

import javax.persistence.Column;

public class RequestOrderDTO {
	
	private Integer sno;
	private String category;
	private String itemName;
	private Double quantity;
	private String units;
	private String orderedDate;
	private String orderedPerson;
	
	
	public RequestOrderDTO(Integer sno, String category, String itemName,
			Double quantity, String units, String orderedDate,
			String orderedPerson) {
		super();
		this.sno = sno;
		this.category = category;
		this.itemName = itemName;
		this.quantity = quantity;
		this.units = units;
		this.orderedDate = orderedDate;
		this.orderedPerson = orderedPerson;
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
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
	
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
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
