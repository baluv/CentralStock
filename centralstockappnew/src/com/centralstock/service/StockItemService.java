package com.centralstock.service;

import java.util.List;

import com.centralstock.model.StockBill;
import com.centralstock.model.StockItems;

public interface StockItemService {
	
	public void insertStockBill(StockBill stockBill);
	public void insertStockItems(StockItems stockItems);
	public List<StockItems> getStockItems(String invoiceNumber);
	public List<StockBill> getStockBill(String invoiceNumber);
	public List<StockItems> editStockItems(int sno,String invoiceNumber);
	public void updateStockItems(double quantity,Double amount,String invoiceNumber,int sno);
	public void deleteStockItem(int sno,String invoiceNumber);
}
