package com.centralstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.centralstock.dao.StockDao;
import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.exception.CentralStockServiceException;
import com.centralstock.model.StockBill;
import com.centralstock.model.StockItems;

@Service("StockItemService")
@Transactional
public class StockItemServiceImpl implements StockItemService{
	
	@Autowired(required=true)
	private StockDao stockDao;
	
	public void insertStockBill(StockBill stockBill)throws CentralStockServiceException  {
		
		 try{
		
		 stockDao.insertStockBill(stockBill);
		 }catch(CentralStockDAOException se){
			 
			 throw new CentralStockServiceException(se+"");  
		 }
		
		
	}
	public void insertStockItems(StockItems stockItems)throws CentralStockServiceException  {
		
		 try{
			
		stockDao.insertStockItems(stockItems);
		 }catch(CentralStockDAOException se){
			 
			 throw new CentralStockServiceException(se+"");  
		 }
	}
	
	public List<StockItems> getStockItems(String invoiceNumber){
	
		return stockDao.getStockItems(invoiceNumber);
	}
	
	public List<StockBill> getStockBill(String invoiceNumber){
		
		return stockDao.getStockBill(invoiceNumber);
	}
	
	public List<StockItems> editStockItems(int sno,String invoiceNumber){
		
		return stockDao.editStockItems(sno, invoiceNumber);
	}
	public void updateStockItems(double quantity,Double amount,String invoiceNumber,int sno){
		
		stockDao.updateStockItems(quantity, amount, invoiceNumber, sno);
	}
	public void deleteStockItem(int sno,String invoiceNumber){
		
		stockDao.deleteStockItem(sno, invoiceNumber);
	}

}
