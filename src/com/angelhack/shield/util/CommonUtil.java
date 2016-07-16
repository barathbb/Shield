package com.angelhack.shield.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
	
	public static final String getCookieValue(HttpServletRequest request, String cookieName){
		Cookie c = getCookie(request, cookieName); 
		return c == null ? null : c.getValue();
	}
	
	public static final Cookie getCookie(HttpServletRequest request, String cookieName){
		if(request != null){
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie c : cookies){
					if(c.getName().equals(cookieName)){
						return c;
					}
				}
			}
		}
		return null;
	}
	
	public static String getAuthCookieValue(HttpServletRequest request){
		return getCookieValue(request, AuthUtil.authCookieName);
	}
	
	
}
