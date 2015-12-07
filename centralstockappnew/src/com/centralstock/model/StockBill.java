package com.centralstock.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "received_stock_details")
public class StockBill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="invoice_date")
	private String invoiceDate;
	
	@Column(name="delivery_date")
	private String deliveryDate;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	 @OneToMany
	 private List<StockItems> stockItems;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<StockItems> getStockItems() {
		return stockItems;
	}

	public void setStockItems(List<StockItems> stockItems) {
		this.stockItems = stockItems;
	}



}
