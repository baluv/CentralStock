package com.centralstock.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.centralstock.model.Consumption;
import com.centralstock.model.Login;
import com.centralstock.service.LoginService;

@Controller
@RequestMapping("/stock")
public class LoginController {
	
	@Autowired(required = true)
	private LoginService loginService;
	private static final Logger log = Logger.getLogger(MainController.class);
	
	@RequestMapping(value = "/login")
	public String getLogin() {

		log.info("login");

		return "login";
	}
	
	@RequestMapping(value = "/change_password")
	public String getModifyPassword() {

		log.info("chang_password");

		return "change_password";
	}
	
	
	
	/*
	@RequestMapping(value = "/passwordChange")
	public String getPasswordChange(@ModelAttribute("login")
			Login login, HttpServletRequest request){
		HttpSession session = request.getSession();

		int check = loginService.passwordChange(login.getInsName(), login.getUserPw());
		if(check==1)
		{
			return "home";
		}else
		{
	}return "change_password";
	}
*/
		
	@RequestMapping(value = "/checkLogin")
	public String getHome(@ModelAttribute("login")
			Login login, HttpServletRequest request)  {
		  HttpSession session = request.getSession();
		  
		  

		int check = loginService.checkLogin(login.getInsName(), login.getUserId(), login.getUserPw());
		if(check==1)
		{
			return "home";
		}else if(check==2)
		{
			session.setAttribute("insName",login.getInsName());
			return "ins_home";	
		}else
		{
	}return "login";

}
	
	@RequestMapping(value = "/passwordChange")
	public String changePassword(@RequestParam("insName")
			String insName, @RequestParam("oldPw")
			String oldPw, @RequestParam("newPw")
			String newPw)
	 {
		
		int check = loginService.passwordChange(insName, oldPw, newPw);
		if(check==1)
		{
			return "login";
		}
		else
		{
		return "change_pw";
		}
	}
	
	
	}
