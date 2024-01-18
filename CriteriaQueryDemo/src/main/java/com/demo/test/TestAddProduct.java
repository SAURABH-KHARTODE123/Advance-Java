package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;

public class TestAddProduct {

	public static void main(String[] args) {
		
		Product p1 = new Product(1,"chair",40,150.0);
		Product p2 = new Product(2,"table",20,300.0);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(p1);
		s.save(p2);
		
		
		tr.commit();
		s.close();

	}

}
