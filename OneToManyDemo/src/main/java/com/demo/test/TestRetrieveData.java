package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Department;
import com.demo.model.Employee;

public class TestRetrieveData {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		
//		Employee e = sess.get(Employee.class, 1);
//		Employee e = sess.load(Employee.class, 1);
//		Department d = sess.get(Department.class, 1);
		Department d = sess.load(Department.class, 1);
		System.out.println("before");
//		System.out.println(e.getEname());
		System.out.println(d.getEset());  // LAZY
//		System.out.println(e.getDept());
		System.out.println("after");
		
		tr.commit();
		
	}

}
