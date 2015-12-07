package com.centralstock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.dao.RequestOrderDao;
import com.centralstock.dao.StockDao;
import com.centralstock.model.OrderedItems;
import com.centralstock.model.PurchaseOrders;
import com.centralstock.model.RequestOrder;
import com.centralstock.model.RequestOrderDTO;
import com.centralstock.model.RequestOrderedItem;

@Service("RequestOrderService")
@Transactional
public class RequestOrderServiceImpl  implements RequestOrderService{
	
	@Autowired(required=true)
	private RequestOrderDao requestOrderDao;
	public void insertRequestOrder(RequestOrder requestOrder){
		
		requestOrderDao.insertRequestOrder(requestOrder);
		
	}
	public void insertRequestOdererItems(RequestOrderedItem requestOrderItems){
		
		requestOrderDao.insertRequestOdererItems(requestOrderItems);
		
	}
	public  List<RequestOrderedItem> getRequestOrderItemList(int rid){
		
		return requestOrderDao.getRequestOrderItemList(rid);
		
	}
	
	public List<RequestOrder> getRequestOrerPreDetails(){
		
		return requestOrderDao.getRequestOrerPreDetails();
	}
	public List<RequestOrderDTO> getRequestOrderList(String insName){
		
		return requestOrderDao.getRequestOrderList(insName);
	}
	public void insertOrderedItems(OrderedItems orderedItems){
		requestOrderDao.insertOrderedItems(orderedItems);
	}
	
	public List<OrderedItems> getOrderedItems(int rid){
		
		return requestOrderDao.getOrderedItems(rid);
	}
	
	public void insertPurchaseOrderItems(PurchaseOrders purchaseOrders){
		
		requestOrderDao.insertPurchaseOrderItems(purchaseOrders);
		
	}
	public void deletOrderedItems(int rid, int sno){
		requestOrderDao.deletOrderedItems(rid, sno);
		
	}
	public List<PurchaseOrders> getPurchaseOrderList(int rid){
		
		return requestOrderDao.getPurchaseOrderList(rid);
	}
}
