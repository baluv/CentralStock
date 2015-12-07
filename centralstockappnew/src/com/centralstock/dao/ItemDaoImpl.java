package com.centralstock.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.Item;

@Repository("ItemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {

	private static final Logger log = Logger.getLogger(ItemDaoImpl.class);
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
   //here New Items will be saved in stock table 
	public void saveItem(Item item) throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
			session.save(item);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
  //get the list of New Item Name And Quantity
	@SuppressWarnings("unchecked")
	public List<Item> getItemList() {
		return (List<Item>) sessionFactory.getCurrentSession().createCriteria(Item.class).list();
	}
	
	//here To get the only Stationary list of New Item Name And Quantity
	@SuppressWarnings("unchecked")
	public List<Item> getItemList1() {
		org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Item i WHERE i.category ='Stationary' group by itemName";
		@SuppressWarnings("rawtypes")
		List list1 = session.createQuery(hql).list();
		return list1;
	}
	//here To get the only Cleaning list of New Item Name And Quantity
	@SuppressWarnings("unchecked")
	public List<Item> getItemList2() {
		org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Item i WHERE i.category ='Cleaning'group by itemName";
		@SuppressWarnings("rawtypes")
		List list2 = session.createQuery(hql).list();
		return list2;
	}
  //here to get the AllItemList form stock table using itemName
	@SuppressWarnings("unchecked")
	public List<Item> getAllItemList(String itemName) {
		org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Item i WHERE i.itemName ='" + itemName + "'";
		return session.createQuery(hql).list();
	}
	//here New Items will be updated in stock table 
	public void updateItem(Item item) throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
			Item existingItem = (Item) session.get(Item.class, item.getItemName());
			existingItem.setCategory(item.getCategory());
			existingItem.setItemName(item.getItemName());
			existingItem.setQuantity(existingItem.getQuantity()+ item.getQuantity());
			existingItem.setQuantity1(existingItem.getQuantity1()+ item.getQuantity());
			existingItem.setUnits(item.getUnits());

			session.saveOrUpdate(existingItem);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	public void deductEditItem(Item item) throws CentralStockDAOException {

		try {
			org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
			Item existingItem = (Item) session.get(Item.class, item.getItemName());
			double q = 0;

			if (existingItem.getQuantity1() == 0) {

				existingItem.setCategory(item.getCategory());
				existingItem.setItemName(item.getItemName());
				existingItem.setQuantity(existingItem.getQuantity()- item.getQuantity());
				existingItem.setQuantity1(q);
				existingItem.setUnits(item.getUnits());

				session.saveOrUpdate(existingItem);

			} else {

				existingItem.setCategory(item.getCategory());
				existingItem.setItemName(item.getItemName());
				existingItem.setQuantity(existingItem.getQuantity()- item.getQuantity());
				existingItem.setQuantity1(existingItem.getQuantity1()- item.getQuantity());
				existingItem.setUnits(item.getUnits());

				session.saveOrUpdate(existingItem);
			}
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	public void updateItemOfOrderes(Item item) {
		try {
			org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
			Item existingItem = (Item) session.get(Item.class, item.getItemName());
			double quantity2 = 0;
			if (existingItem.getQuantity1() == 0 || existingItem.getQuantity1() < item.getQuantity1()) {

				log.debug("Quantity2::" + quantity2);

				String hql = "UPDATE Item i set i.quantity1 = '" + quantity2 + "'WHERE i.itemName = '" + item.getItemName() + "'";
				session.createQuery(hql).executeUpdate();

			} else {
				quantity2 = existingItem.getQuantity1() - item.getQuantity1();

				log.debug("Quantity2::" + quantity2);

				String hql = "UPDATE Item i set i.quantity1 = '" + quantity2 + "'WHERE i.itemName = '" + item.getItemName() + "'";
				session.createQuery(hql).executeUpdate();
			}
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	@SuppressWarnings("unchecked")
	public String getItemListSta() {
		org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Item i WHERE i.category ='Stationary'";
		@SuppressWarnings("rawtypes")
		List list = session.createQuery(hql).list();
		@SuppressWarnings("rawtypes")
		List list1 = new ArrayList();
		for (@SuppressWarnings("rawtypes")
		Iterator it = list.iterator(); it.hasNext();) {

			Item l = (Item) it.next();

			list1.add("'" + l.getItemName() + "'");
	
		}
		String s=list1.toString().replace("[", "").replace("]", "");
		return s;
	}
	
	@SuppressWarnings("unchecked")
	public String getItemListCle() {
		org.hibernate.classic.Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Item i WHERE i.category ='Cleaning'";
		@SuppressWarnings("rawtypes")
		List list = session.createQuery(hql).list();
		@SuppressWarnings("rawtypes")
		List list1 = new ArrayList();
		for (@SuppressWarnings("rawtypes")
		Iterator it = list.iterator(); it.hasNext();) {

			Item l = (Item) it.next();

			list1.add("'" + l.getItemName() + "'");
	
		}
		String c=list1.toString().replace("[", "").replace("]", "");
		return c;
	}
	
	
}
