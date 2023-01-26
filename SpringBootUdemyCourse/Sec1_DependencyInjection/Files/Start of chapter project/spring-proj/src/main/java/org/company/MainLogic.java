package org.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
	
public class MainLogic {

	public static void main(String[] args) {

		//Bean config using XML
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		//ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		AnimalSound obj = (AnimalSound) context.getBean("animalSound");
		obj.shout();
	}

}
