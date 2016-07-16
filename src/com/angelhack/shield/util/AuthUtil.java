package com.angelhack.shield.util;

import javax.servlet.http.HttpServletRequest;

public class AuthUtil {

	public static final String authCookieName = "S_USERAGENT";
	
	private static String getAuthTokenForUser(String userName, String password){
		// Fetch from DB
		return null;
	}
	
	private static boolean isValidAuthToken(String authToken){
		//DO fetch from DB and validate.
		return true;
	}
	
	
	private static boolean isUserLoggedIn(HttpServletRequest request){
		return false;
	}
	
}
