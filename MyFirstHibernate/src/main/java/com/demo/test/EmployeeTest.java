package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;


public class EmployeeTest {

	public static void main(String[] args) {
		Employee e1 = new Employee(10,"Rahul",450000,"male");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
//		session.save(e1);
		
		
		tr.commit();
		session.close();
		
		Session sess1 = sf.openSession();
		Transaction tr1 = sess1.beginTransaction();
//		Employee e2 = sess1.get(Employee.class,1);
//		Employee e2 = sess1.load(Employee.class,1);
//		System.out.println("before");
//		System.out.println(e2);
//		System.out.println("after");
		
		sess1.update(new Employee(1,"Saurabh Khartode",750000,"male"));
		
		tr1.commit();
		
		sf.close();
		
		
		
		

	}

}
