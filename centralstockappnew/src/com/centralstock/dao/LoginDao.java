package com.centralstock.dao;

import com.centralstock.model.Login;

public interface LoginDao {
	public int checkLogin(String organization, String userid, String password);
	public int passwordChange(String organization, String oldpassword, String newpassword);

}
