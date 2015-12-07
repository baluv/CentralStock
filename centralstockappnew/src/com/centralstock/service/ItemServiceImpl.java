package com.centralstock.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.dao.ItemDao;
import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.exception.CentralStockServiceException;
import com.centralstock.model.Item;


@Service("ItemService")
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ItemServiceImpl.class);
	@Autowired(required=true)
	private ItemDao itemDao;
	 
	public void saveItem(Item item)throws CentralStockServiceException  {
		 try{
		 itemDao.saveItem(item);
		 }catch(CentralStockDAOException se){
			 throw new CentralStockServiceException(se+"");  
		 }
	}
	
	 public List<Item> getItemList(){
		 return itemDao.getItemList();
	 }
	 
     public List<Item> getItemList1(){
		 return itemDao.getItemList1();
	 }
 
    public List<Item> getItemList2(){
	 return itemDao.getItemList2();
    }
    
	 public List<Item> getAllItemList(String itemName){
		 return itemDao.getAllItemList(itemName);
	 }
	 
	 public void updateItem(Item item)throws CentralStockServiceException{
		 try{
		itemDao.updateItem(item);
	  }
		 catch(CentralStockDAOException se){
			 throw new CentralStockServiceException(se+""); 
		 }
	 }
	 
	 public void deductEditItem(Item item){
		 try{
			 itemDao.deductEditItem(item);
		 }
		 catch(CentralStockDAOException se){
			 throw new CentralStockServiceException(se+""); 
		 }
	 }
	 
	 public void updateItemOfOrderes(Item item){
		 itemDao.updateItemOfOrderes(item);
	 }
	 
     public String getItemListSta(){
		 return itemDao.getItemListSta();
	 }
	 
    public String getItemListCle(){
	 return itemDao.getItemListCle();
    }
    
  }
