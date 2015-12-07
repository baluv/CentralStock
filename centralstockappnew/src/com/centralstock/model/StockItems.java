package com.centralstock.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "received_stock_details_items")

public class StockItems implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Id
	@GeneratedValue
	@Column(name="sno" )
	private int sno;
	
	@Column(name="category")
	private String category;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="quantity")
	private double quantity;
	
	@Column(name="units")
	private String units;
	
	@Column(name="amount")
	private Double amount;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

}
