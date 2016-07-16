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

import org.apache.commons.lang3.StringUtils;

public class AuthFilter implements Filter {
	
	public static final String authCookieName = "USERAGENT";
	
	private static String getAuthCookie(HttpServletRequest request){
		String authCookieValue = null;
		if(request != null){
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie c : cookies){
					if(c.getName().equals(authCookieName)){
						authCookieValue = c.getValue();
						if(StringUtils.isNotEmpty(authCookieName) ){
							break;
						}
					}
						
				}
			}
		}
		return authCookieValue;
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
		
		String cookie = getAuthCookie(request);
		
		
		
	}

@Override
public void destroy() {
	// TODO Auto-generated method stub
	
}

@Override
public void init(FilterConfig arg0) throws ServletException {
	
}	
	

}
