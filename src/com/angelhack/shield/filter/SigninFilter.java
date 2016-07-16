package com.angelhack.shield.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SigninFilter implements Filter {
	
	private static String getAuthTokenForUser(String userName, String password){
		// Fetch from DB
		return null;
	}
	
	private static boolean isValidAuthToken(String authToken){
		//DO fetch from DB and validate.
		return true;
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String authTokenForUser = getAuthTokenForUser(userName, password);
		
		Cookie authCookie = new Cookie(AuthFilter.authCookieName, authTokenForUser);
		authCookie.setPath("/");
		
		response.addCookie(authCookie);
		response.sendRedirect("/home");
		
	}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	
}	
	

}
