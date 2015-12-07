package com.centralstock.dao;

import java.util.List;

import com.centralstock.model.OrderedItems;
import com.centralstock.model.PurchaseOrders;
import com.centralstock.model.RequestOrder;
import com.centralstock.model.RequestOrderDTO;
import com.centralstock.model.RequestOrderedItem;

public interface RequestOrderDao {
	
	public void insertRequestOrder(RequestOrder requestOrder);
	public void insertRequestOdererItems(RequestOrderedItem requestOrderItems);
	public  List<RequestOrderedItem> getRequestOrderItemList(int rid);
	public List<RequestOrder> getRequestOrerPreDetails();
	public List<RequestOrderDTO> getRequestOrderList(String insName);
	public void insertOrderedItems(OrderedItems orderedItems);
	public List<OrderedItems> getOrderedItems(int rid);
	public void insertPurchaseOrderItems(PurchaseOrders purchaseOrders);
	public void deletOrderedItems(int rid, int sno);
	public List<PurchaseOrders> getPurchaseOrderList(int rid);
}
