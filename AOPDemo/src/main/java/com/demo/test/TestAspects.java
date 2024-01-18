package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.MyGame;
import com.demo.model.MyVehicleGame;

public class TestAspects {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		
		MyGame g1 = (MyGame) ctx.getBean("myGame");
		g1.m1();
		g1.m2();
		
		MyVehicleGame g2 = (MyVehicleGame) ctx.getBean("myVehicleGame");
		g2.m11(1);

	}

}
