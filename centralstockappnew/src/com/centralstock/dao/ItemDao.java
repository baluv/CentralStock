package com.centralstock.dao;

import java.util.List;

import com.centralstock.model.Item;

public interface ItemDao {
	
	public void saveItem(Item item);
	public List<Item> getItemList();
	public List<Item> getItemList1();
	public List<Item> getItemList2();
	public List<Item> getAllItemList(String itemName);
	public void updateItem(Item item);
	public void deductEditItem(Item item);
	public void updateItemOfOrderes(Item item);
	public String getItemListSta();
	public String getItemListCle();
	
}
