package com.app;


import com.util.HibrnateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Product;

public class Test {

	public static void main(String[] args) {
    SessionFactory sf = HibrnateUtil.getSessionFactory();
    Session session =sf.openSession();
	
	Product p = new Product();
	p.setPid(11);
	p.setPname("Hudi");
	p.setPrice(800);
	
	session.save(p);
	session.beginTransaction().commit();
	System.out.println("save Product Data......");
	
	}

}
