package com.init.listener;

import javax.servlet.ServletContextEvent;
import org.springframework.web.context.ContextLoaderListener;


public class InitProjectListener extends ContextLoaderListener{
	public void contextInitialized(ServletContextEvent event) {  
	    super.contextInitialized(event);  
	}
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
		// TODO Auto-generated method stub
	}
}
