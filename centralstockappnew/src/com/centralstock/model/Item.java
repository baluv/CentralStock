package com.centralstock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Item {
	
	@Id
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "units")
	private String units;

	@Column(name = "quantity1")
	private double quantity1;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getQuantity1() {
		return quantity1;
	}

	public void setQuantity1(double quantity1) {
		this.quantity1 = quantity1;
	}


}
