package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Department;
import com.demo.model.Employee;

public class TestOneToMany {

	public static void main(String[] args) {
		Employee e1 = new Employee(1,"Ameya",750000);
		Employee e2 = new Employee(2,"Saurabh",800000);
		
		Set<Employee> elist = new HashSet();
		elist.add(e1);
		elist.add(e2);
		Department d1 = new Department(1,"HR","Pune",elist);
//		System.out.println(d1);
		e1.setDept(d1);
		e2.setDept(d1);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction tr = s.beginTransaction();
		s.save(d1);
		s.save(e1);
		s.save(e2);
		
		
		tr.commit();

	}

}
