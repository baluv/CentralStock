package com.centralstock.model;

public class StockDTO {

	private String itemName;
	private Double quantity;
	
	public StockDTO(String itemName,
			Double quantity) {
		super();

		this.itemName = itemName;
		this.quantity = quantity;
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
	
	
}
