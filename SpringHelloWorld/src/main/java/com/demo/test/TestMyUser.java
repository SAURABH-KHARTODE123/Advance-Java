package com.demo.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.demo.model.HelloWorld;
import com.demo.model.MyUser;

public class TestMyUser {

	public static void main(String[] args) {
//		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("springconfig.xml"));
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		// In Bean factory the object is created when getBean 
		// method is called
		
//		MyUser u = (MyUser)bf.getBean("u1");
//		System.out.println(u);
//		System.out.println("before");
//		HelloWorld h1 = (HelloWorld)bf.getBean("hw");
//		h1.sayHello();
//		System.out.println("after");
//		System.out.println("--------------");

		// When application context is used all the bean objects are
		// created when the context is created
		
		System.out.println("Application context");
		System.out.println("before");
		MyUser u1 = (MyUser)ctx.getBean("u1");
		System.out.println(u1);
		System.out.println("after");
		
		
		// If one or more objects of same type are created then type 
		// cannot be used
		System.out.println("---------------");
		System.out.println("constructor arguments");
		MyUser u2 = (MyUser) ctx.getBean("u2");
		System.out.println(u2);
		
		System.out.println("before");
		MyUser u3 = (MyUser)ctx.getBean("u3");
		System.out.println(u3);
		System.out.println("after");
		
		
	}

}
