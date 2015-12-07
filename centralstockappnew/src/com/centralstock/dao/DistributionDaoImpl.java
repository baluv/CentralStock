package com.centralstock.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Order;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.Distribution;
import com.centralstock.model.DistributionList;
import com.centralstock.model.DistributionListDTO;
import com.centralstock.model.Item;


@Repository("DistributionDao")
@Transactional
public class DistributionDaoImpl implements DistributionDao {

	private static final Logger log = Logger
			.getLogger(DistributionDaoImpl.class);
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	
	public void insertDistribution(Distribution distribution)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(distribution);
		} catch (HibernateException he) {
			log.debug(he);
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}

	}

	public void insertDistributionItems(DistributionList distributionList)
			throws CentralStockDAOException {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Item existingItem = (Item) session.get(Item.class, distributionList
				.getItemName());
		log.debug("Existing Quantity::" + existingItem.getQuantity());
		log.debug("Distrubtion Quantity::" + distributionList.getQuantity());
		try {

			if (existingItem.getQuantity() >= distributionList.getQuantity()) {

				session.save(distributionList);
			} else {
				throw new CentralStockDAOException("Not Enogh Stock To Issu.. ");
			}

		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	@SuppressWarnings("unchecked")
	public List<DistributionList> getAllDistributionList(int did) {
		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(DistributionList.class);

		criteria.add(Restrictions.eq("did", did));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<DistributionListDTO>  searchDistributionList(String insName,
			String fromDate, String toDate) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "SELECT NEW com.centralstock.model.DistributionListDTO(dl.sno, dl.category, dl.itemName, dl.quantity, dl.units, d.issuedDate, d.receivedperson)  FROM  DistributionList dl, Distribution d  WHERE d.did=dl.did AND d.insName='"
				+ insName
				+ "' AND d.issuedDate between '"
				+ fromDate 
				+ "' AND '"
				+ toDate + "'";
		log.debug("search"+hql);
		log.debug("ll::" + insName + fromDate + toDate);

		List<DistributionListDTO> list= session.createQuery(hql).list();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Distribution> getDistributionPreList(){
		
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();

		
		Criteria criteria = session.createCriteria(Distribution.class);

		criteria.addOrder(Order.desc("issuedDate"));

		return criteria.list();
	}
	public List<DistributionList> getCurrentStat(String organisation)
	{
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		String hql = "select distinct itemName,sum(quantity) from DistributionList where insName='"+organisation+"' and category='Stationary' group by itemName";
		String hql1 = "select distinct itemName,sum(quantity) from ConsumptionList where insName='"+organisation+"' and category='Stationary' group by itemName";
		log.debug("stock of institute"+hql);

		  Query query = session.createQuery(hql);
		  Query query1 = session.createQuery(hql1);
		  Object[] row = null;
		  Object[] row1 = null;
		  Iterator it = query.iterate();
		  Iterator it1 = query1.iterate();
		  ArrayList list = new ArrayList();
		  Map list1 = new HashMap();
		  Map list2 = new HashMap();
		
		  while (it.hasNext()) {
		   row = (Object[]) it.next();
		   System.out.print(row[0] + "\t");
		   System.out.println(row[1]);

		   list1.put(row[0],row[1]);
	
		  }
		
		  while (it1.hasNext()) {
			   row1 = (Object[]) it1.next();
			   System.out.print(row1[0] + "\t");
			   System.out.println(row1[1]);

			   list2.put(row1[0],row1[1]);
			
			  }
		  
		  list.add(list1);
		  
		  list.add(list2);
		  
		  System.out.println("sssssssssss"+list1);
		  System.out.println("sssssssssss"+list1.size());
		  System.out.println("sssssssssss"+list2);
		  System.out.println("sssssssssss"+list2.size());
		  return list;
		  
		  
		  
		 }
	
	public List<DistributionList> getCurrentClean(String organisation)
	{
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		String hql = "select distinct itemName,sum(quantity) from DistributionList where insName='"+organisation+"' and category='Cleaning' group by itemName";
		String hql1 = "select distinct itemName,sum(quantity) from ConsumptionList where insName='"+organisation+"' and category='Cleaning' group by itemName";
		log.debug("stock of institute"+hql);

		  Query query = session.createQuery(hql);
		  Query query1 = session.createQuery(hql1);
		  Object[] row = null;
		  Object[] row1 = null;
		  Iterator it = query.iterate();
		  Iterator it1 = query1.iterate();
		  ArrayList list = new ArrayList();
		  Map list1 = new HashMap();
		  Map list2 = new HashMap();
		
		  while (it.hasNext()) {
		   row = (Object[]) it.next();
		   System.out.print(row[0] + "\t");
		   System.out.println(row[1]);

		   list1.put(row[0],row[1]);
	
		  }
		
		  while (it1.hasNext()) {
			   row1 = (Object[]) it1.next();
			   System.out.print(row1[0] + "\t");
			   System.out.println(row1[1]);

			   list2.put(row1[0],row1[1]);
			
			  }
		  
		  list.add(list1);
		  
		  list.add(list2);
		  
		  System.out.println("sssssssssss"+list1);
		  System.out.println("sssssssssss"+list1.size());
		  System.out.println("sssssssssss"+list2);
		  System.out.println("sssssssssss"+list2.size());
		  return list;
		  
		  
		  
		 }
	
	
	public List<DistributionList> getCurrentStock(String organisation)
	{
		org.hibernate.classic.Session session = sessionFactory
		.getCurrentSession();
		String hql = "select distinct itemName,sum(quantity) from DistributionList where insName='"+organisation+"' group by itemName";
		String hql1 = "select distinct itemName,sum(quantity) from ConsumptionList where insName='"+organisation+"' group by itemName";
		log.debug("stock of institute"+hql);

		  Query query = session.createQuery(hql);
		  Query query1 = session.createQuery(hql1);
		  Object[] row = null;
		  Object[] row1 = null;
		  Iterator it = query.iterate();
		  Iterator it1 = query1.iterate();
		  ArrayList list = new ArrayList();
		  Map list1 = new HashMap();
		  Map list2 = new HashMap();
		
		  while (it.hasNext()) {
		   row = (Object[]) it.next();
		   System.out.print(row[0] + "\t");
		   System.out.println(row[1]);

		   list1.put(row[0],row[1]);
	
		  }
		
		  while (it1.hasNext()) {
			   row1 = (Object[]) it1.next();
			   System.out.print(row1[0] + "\t");
			   System.out.println(row1[1]);

			   list2.put(row1[0],row1[1]);
			
			  }
		  
		  list.add(list1);
		  
		  list.add(list2);
		  
		  System.out.println("sssssssssss"+list1);
		  System.out.println("sssssssssss"+list1.size());
		  System.out.println("sssssssssss"+list2);
		  System.out.println("sssssssssss"+list2.size());
		  return list;
		  
		  
		  
		 }


	}


