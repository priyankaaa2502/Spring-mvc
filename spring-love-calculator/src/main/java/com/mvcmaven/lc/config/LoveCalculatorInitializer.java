package com.mvcmaven.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class LoveCalculatorInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

//		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
//		webApplicationContext.setConfigLocation("Application.xml");

		AnnotationConfigWebApplicationContext webApplicationContext = 
				new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(LoveCalculatorConfig.class);
		
		
		//create dispatcherServlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		//Register dispatcherServlet with servlet context 
		ServletRegistration.Dynamic myCustomDispatcherServlet = 
				servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
	}

}
