package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.MyUser;

public class TestRetrieveData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tr = s1.beginTransaction();
//		MyUser u1 = s1.get(MyUser.class, 1);
		MyUser u1 = s1.load(MyUser.class, 1);
		System.out.println("before");
		System.out.println(u1);
		System.out.println("after");
		tr.commit();
		s1.close();
	}

}
