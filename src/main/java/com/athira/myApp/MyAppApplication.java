package com.athira.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		//run to create the spring IOC container inside the JVM, where all the objects are created
		ApplicationContext context = SpringApplication.run(MyAppApplication.class, args);

		/*
		  Spring wont create the objects of all classes as it would be a waste.
		  It will only create/handles the objects of the classes which has been marked as Components
		 */

		Dev obj = context.getBean(Dev.class);
		obj.build();
	}

}
