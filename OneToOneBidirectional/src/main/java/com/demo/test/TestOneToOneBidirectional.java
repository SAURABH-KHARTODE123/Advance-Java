package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestOneToOneBidirectional {

	public static void main(String[] args) {
//		Address addr1 = new Address(1,"SB","pune","Maharashtra");
//		Address addr2 = new Address(2,"FC","pune","Maharashtra");
//		MyUser u1 = new MyUser(1,"Saurabh",addr1);
//		MyUser u2 = new MyUser(2,"Somesh",addr2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tr = s1.beginTransaction();
//		MyUser u1 = s1.get(MyUser.class, 2);
//		System.out.println(u1);
		Address a1 = s1.get(Address.class, 2);
		System.out.println(a1);
		System.out.println(a1.getU());
//		s1.save(addr1);
//		s1.save(addr2);
//		s1.save(u1);
//		s1.save(u2);

		tr.commit();
//		s1.close();

	}

}
