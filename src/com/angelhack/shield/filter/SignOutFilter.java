package com.angelhack.shield.filter;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.angelhack.shield.persistence.Persistence;
import com.angelhack.shield.persistence.PersistenceUtil;
import com.angelhack.shield.util.AuthUtil;

public class SignOutFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		Cookie authCookie = new Cookie(AuthUtil.authCookieName, StringUtils.EMPTY);
		authCookie.setPath("/");
		
		response.addCookie(authCookie);
		request.getSession().invalidate();
		response.sendRedirect("/home");
		
		Persistence p = PersistenceUtil.getPersistence();
		PreparedStatement ps = null;
		try {
			ps = p.prepareStatement("");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		p.executeSelect(ps);
		
	}

@Override
public void destroy() {
	// TODO Auto-generated method stub
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	
}	
	

}
