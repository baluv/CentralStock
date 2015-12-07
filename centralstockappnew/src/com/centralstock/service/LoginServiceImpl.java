package com.centralstock.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.centralstock.dao.LoginDao;
import com.centralstock.exception.CentralStockDAOException;
import com.centralstock.exception.CentralStockServiceException;
import com.centralstock.model.Consumption;
import com.centralstock.model.Item;
import com.centralstock.model.Login;


@Service("LoginService")
@Transactional
public class LoginServiceImpl implements LoginService {
	
	private static final Logger log = Logger.getLogger(ItemServiceImpl.class);
	@Autowired(required=true)
	private LoginDao loginDao;

	
	public int checkLogin(String insName, String user, String pwd) {
		// TODO Auto-generated method stub
		log.info("loginService");
		return loginDao.checkLogin(insName, user, pwd);
	}

	public int passwordChange(String insName,String oldpwd, String newpwd)
	{
		// TODO Auto-generated method stub
		log.info("loginService");
		return loginDao.passwordChange(insName, oldpwd, newpwd);
	}
	/*
	public void updatePassword(Login login)throws CentralStockServiceException{	
		 try{
		
		loginDao.updatePassword(login);
	}
		 catch(CentralStockDAOException se){
			 throw new CentralStockServiceException(se+""); 
		 }
		 
	 }
	*/
}

