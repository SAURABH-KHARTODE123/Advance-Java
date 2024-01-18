package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.demo.model.Product;

public class TestCriteriaQuery {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Criteria cr = ses.createCriteria(Product.class);
		List<Product> plist = cr.list();
		plist.forEach(System.out::println);
		System.out.println("------------------------");
		
		Criterion gt = Restrictions.gt("price", 100.00);
		Criterion qty = Restrictions.lt("qty",50);
		LogicalExpression expr = Restrictions.and(gt,qty);
		
		Criteria cr1 = ses.createCriteria(Product.class);
		cr1.add(expr);
		plist = cr1.list();
		plist.forEach(System.out::println);
		System.out.println("------------------------");
		cr.setFirstResult(0);
		cr.setMaxResults(1);
		plist = cr.list();
		plist.forEach(System.out::println);
		System.out.println("------------------------");
		
		tr.commit();
		ses.close();

	}

}
