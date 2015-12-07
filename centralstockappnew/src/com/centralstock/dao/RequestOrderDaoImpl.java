package com.centralstock.dao;

import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import javax.annotation.Resource;
import javax.management.Query;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.Distribution;
import com.centralstock.model.DistributionListDTO;
import com.centralstock.model.Item;
import com.centralstock.model.Login;
import com.centralstock.model.OrderedItems;
import com.centralstock.model.PurchaseOrders;
import com.centralstock.model.RequestOrder;
import com.centralstock.model.RequestOrderDTO;
import com.centralstock.model.RequestOrderedItem;

@Repository("RequestOrderDao")
@Transactional
public class RequestOrderDaoImpl implements RequestOrderDao {

	private static final Logger log = Logger
			.getLogger(RequestOrderDaoImpl.class);

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void insertRequestOrder(RequestOrder requestOrder)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(requestOrder);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}

	}

	public void insertRequestOdererItems(RequestOrderedItem requestOrderItems)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(requestOrderItems);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	@SuppressWarnings("unchecked")
	public List<RequestOrderedItem> getRequestOrderItemList(int rid) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(RequestOrderedItem.class);

		criteria.add(Restrictions.eq("rid", rid));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<RequestOrder> getRequestOrerPreDetails(){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

		Criteria criteria = session.createCriteria(RequestOrder.class);
		
		criteria.addOrder(Order.desc("rid"));
		criteria.addOrder(Order.desc("orderedDate"));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<RequestOrderDTO> getRequestOrderList(String insName){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

		String hql = "SELECT NEW com.centralstock.model.RequestOrderDTO(rl.sno, rl.category, rl.itemName, rl.quantity, rl.units, r.orderedDate, r.orderedPerson)  FROM RequestOrderedItem rl, RequestOrder r  WHERE r.rid=rl.rid AND r.insName= '"+ insName+ "'";
		

		List<RequestOrderDTO> list= session.createQuery(hql).list();

		return list;
	}
	
	public void insertOrderedItems(OrderedItems orderedItems)throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(orderedItems);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderedItems> getOrderedItems(int rid){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

		Criteria criteria = session.createCriteria(OrderedItems.class);

		criteria.add(Restrictions.eq("rid", rid));

		return criteria.list();
	}
	
	public void insertPurchaseOrderItems(PurchaseOrders purchaseOrders)throws CentralStockDAOException{
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		
		PurchaseOrders newPurchaseOrders =new  PurchaseOrders();
		try{
			
			Item existingItem =  (Item) session.get(Item.class, purchaseOrders.getItemName());
			
			if(existingItem.getQuantity1()==0 || existingItem.getQuantity1() < purchaseOrders.getQuantity() ){
				
				newPurchaseOrders.setRid(purchaseOrders.getRid());
				newPurchaseOrders.setSno(purchaseOrders.getSno());
				newPurchaseOrders.setCategory(purchaseOrders.getCategory());
				newPurchaseOrders.setItemName(purchaseOrders.getItemName());
				newPurchaseOrders.setQuantity(purchaseOrders.getQuantity()-existingItem.getQuantity1());
				newPurchaseOrders.setUnits(purchaseOrders.getUnits());
				
				session.save(newPurchaseOrders);
				
			}else
				
				throw new  CentralStockDAOException("");
		}catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
	
	public void deletOrderedItems(int rid, int sno){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		
		String hql = "DELETE FROM OrderedItems o WHERE o.rid = '"+ rid +"' AND o.sno='"+sno+"'";
		
		log.debug("Delete query for Ordered items::"+hql);
	
			session.createQuery(hql).executeUpdate();
		}
	
	
	@SuppressWarnings("unchecked")
	public List<PurchaseOrders> getPurchaseOrderList(int rid){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

		Criteria criteria = session.createCriteria(PurchaseOrders.class);

		criteria.add(Restrictions.eq("rid", rid));

		return criteria.list();
	}
	
}
	

