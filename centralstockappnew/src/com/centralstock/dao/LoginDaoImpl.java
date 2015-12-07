package com.centralstock.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.model.Item;
import com.centralstock.model.Login;

@Repository("LoginDao")
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	public int checkLogin(String insName, String user, String pwd)throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();
			

			Login existingUser = (Login) session.get(Login.class, insName);
			
			if(insName.equals("Centeral Admin") && user.equals(existingUser.getUserId()) && pwd.equals(existingUser.getUserPw())){
				return 1;
			}else if(insName.equals(existingUser.getInsName()) && user.equals(existingUser.getUserId()) && pwd.equals(existingUser.getUserPw())){
				return 2;
			}else
			{
				return 0;
			}
		}
		catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
	
	public int passwordChange(String insName, String oldpw, String newpw)throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();
			

			Login existingUser = (Login) session.get(Login.class, insName);
			
			if(insName.equals(existingUser.getInsName()) && oldpw.equals(existingUser.getUserPw())){
				
				String hql = "UPDATE Login i set i.userPw = '" + newpw
				+ "'WHERE i.insName = '" + insName+ "'";
				
		session.createQuery(hql).executeUpdate();
				
				return 1;
			}else
			{
				return 0;
			}
		}
		catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
	/*
	@SuppressWarnings("unchecked")
	public void updatePassword(Login login) throws CentralStockDAOException {
		try {
			org.hibernate.classic.Session session = sessionFactory
					.getCurrentSession();

			Login existingPassword = (Login) session.get(Login.class, login
					.getInsName());

			existingPassword.setUserPw(login.getUserPw());
	
			session.saveOrUpdate(existingPassword);
		} 
		
		catch (HibernateException he) {
			throw new CentralStockDAOException(he + "");
		} catch (Exception sl) {
			throw new CentralStockDAOException(sl + "");
		}
	}
	
	*/
	

}
