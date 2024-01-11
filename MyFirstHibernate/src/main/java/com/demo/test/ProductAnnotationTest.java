package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class ProductAnnotationTest {

	public static void main(String[] args) {
		Product p1 = new Product("chair",70,127);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tr = s1.beginTransaction();
		s1.save(p1);
		tr.commit();
		
		s1.close();
		sf.close();
		
		
		

	}

}
