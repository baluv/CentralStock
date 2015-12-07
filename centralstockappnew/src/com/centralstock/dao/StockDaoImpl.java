package com.centralstock.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;


import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.StockBill;
import com.centralstock.model.StockItems;

@Repository("StockDao")
@Transactional
public class StockDaoImpl implements StockDao {

	private static final Logger log = Logger.getLogger(StockDaoImpl.class);
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void insertStockBill(StockBill stockBill)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(stockBill);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}

	}

	@SuppressWarnings("unchecked")
	public void insertStockItems(StockItems stockItems)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();
			
			String hql ="FROM StockItems s WHERE s.invoiceNumber = '"+ stockItems.getInvoiceNumber()+"' AND s.sno='"+ stockItems.getSno() +"' AND s.itemName='" + stockItems.getItemName() +"'" ;
				
			@SuppressWarnings("unused")
			List<StockItems> list=(List<StockItems>)session.createQuery(hql).list();
			
			log.debug("list::"+ list.toString());
			
				session.save(stockItems);
		} catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	@SuppressWarnings("unchecked")
	public List<StockItems> getStockItems(String invoiceNum) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(StockItems.class);
	
		criteria.add( Restrictions.eq("invoiceNumber",invoiceNum) );
		
		return  criteria.list();
		

	}

	@SuppressWarnings("unchecked")
	public List<StockBill> getStockBill(String invoiceNumber) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "FROM StockBill b WHERE b.invoiceNumber ='"
				+ invoiceNumber + "'";

		return session.createQuery(hql).list();

	}
	
	@SuppressWarnings("unchecked")
	public List<StockItems> editStockItems(int sno,String invoiceNumber){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		Criteria criteria = session.createCriteria(StockItems.class);
		criteria.add( Restrictions.eq("sno",sno) );
		criteria.add( Restrictions.eq("invoiceNumber",invoiceNumber) );
		return  criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public void updateStockItems(double quantity,Double amount,String invoiceNumber,int sno){
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		
		String hql = "UPDATE StockItems s set s.quantity = '"+quantity+"' , s.amount='"+amount+"'WHERE s.invoiceNumber = '"+invoiceNumber+"' AND s.sno='"+sno+"'";
		log.debug("update query for stock items::"+hql);
	
			session.createQuery(hql).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public void deleteStockItem(int sno,String invoiceNumber){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		
		String hql = "DELETE FROM StockItems s WHERE s.invoiceNumber = '"+invoiceNumber+"' AND s.sno='"+sno+"'";
		
		log.debug("Delete query for stock items::"+hql);
	
			session.createQuery(hql).executeUpdate();
	}
}
