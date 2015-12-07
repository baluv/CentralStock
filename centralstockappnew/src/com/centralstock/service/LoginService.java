package com.centralstock.service;

import com.centralstock.model.Login;

public interface LoginService {
	public int checkLogin(String insName, String user, String pwd);
	public int passwordChange(String insName,String oldpwd, String newpwd);
	
}
