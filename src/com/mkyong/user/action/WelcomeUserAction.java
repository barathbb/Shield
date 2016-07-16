package com.mkyong.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeUserAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

//	public void access(){
//		System.out.println("Came here...");
//	}
//	
	
	public String access(){
		System.out.println("Jdskghfdgkjfd");
		return SUCCESS;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
}