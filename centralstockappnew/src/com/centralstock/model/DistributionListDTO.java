package com.centralstock.model;

public class DistributionListDTO {

	private Integer sno;
	private String category;
	private String itemName;
	private Double quantity;
	private String units;
	private String issuedDate;
	private String receivedperson;
	
	public DistributionListDTO(Integer sno, String category, String itemName,
			Double quantity, String units, String issuedDate,
			String receivedperson) {
		super();
		this.sno = sno;
		this.category = category;
		this.itemName = itemName;
		this.quantity = quantity;
		this.units = units;
		this.issuedDate = issuedDate;
		this.receivedperson = receivedperson;
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
