package com.angelhack.shield.home;

import com.angelhack.shield.struts.StrutsContext;

public class DefaultHome extends StrutsContext {
	
	public String home(){
		
		System.out.println("Came here");
		
		return SUCCESS;
		
	}

}
