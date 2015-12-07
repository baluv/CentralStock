package com.centralstock.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.Consumption;
import com.centralstock.model.ConsumptionDTO;
import com.centralstock.model.ConsumptionList;
import com.centralstock.model.DistributionListDTO;
import com.centralstock.model.RequestOrderedItem;

@Repository("ConsumptionDao")
@Transactional
public class ConsumptionDaoImpl implements ConsumptionDao {

	private static final Logger log = Logger
			.getLogger(ConsumptionDaoImpl.class);
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void insertConsumption(Consumption consumption)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(consumption);
		} catch (HibernateException he) {
			log.debug(he);
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	public void insertConsumptionItems(ConsumptionList consumptionList)
			throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			session.save(consumptionList);
		} catch (HibernateException he) {
			log.debug(he);
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}

	@SuppressWarnings("unchecked")
	public List<ConsumptionList> getConsumptionList(int cid) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		Criteria criteria = session.createCriteria(ConsumptionList.class);

		criteria.add(Restrictions.eq("cid", cid));

		return criteria.list();

	}
	
	@SuppressWarnings("unchecked")
	public List<ConsumptionDTO>  getConsumedItems(String insName,
			String fromDate, String toDate) {

		org.hibernate.classic.Session session = sessionFactory
				.getCurrentSession();

		String hql = "SELECT NEW com.centralstock.model.ConsumptionDTO(cl.sno, cl.category, cl.itemName, cl.quantity, cl.units, c.issuedDate, c.enteredby)  FROM ConsumptionList cl, Consumption c  WHERE c.cid=cl.cid AND c.insName='"
				+ insName
				+ "' AND c.issuedDate between '"
				+ fromDate 
				+ "' AND '"
				+ toDate + "'";
		log.debug("search"+hql);
		log.debug("ll::" + insName + fromDate + toDate);

		List<ConsumptionDTO> list= session.createQuery(hql).list();
		
		return list;
	}
}
