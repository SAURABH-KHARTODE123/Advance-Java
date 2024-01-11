package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Address;
import com.demo.model.MyUser;

public class TestOneToOneUser {

	public static void main(String[] args) {
		Address addr1 = new Address(3,"SB","pune","Maharashtra");
		Address addr2 = new Address(4,"FC","pune","Maharashtra");
		MyUser u1 = new MyUser(3,"Saurabh",addr1);
		MyUser u2 = new MyUser(4,"Somesh",addr2);
		addr1.setU(u1);
		addr2.setU(u2);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s2 = sf.openSession();
		Transaction tr = s2.beginTransaction();
		s2.save(addr1);
		s2.save(addr2);
		s2.save(u1);
		s2.save(u2);

		tr.commit();
		s2.close();

	}

}
