package com.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

	public static void main(String[] args) {

	
		Configuration cfg = new Configuration().configure("Hibernate1.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

	Employee e = new 	Employee();
		e.setEid(12);
		e.setEname("Tushar");
		e.setEaddress("Pimperi");
		e.setSalary(23000);
		e.setEmail("tusharpaudaml@gmail.com");
		session.save(e);
		session.beginTransaction().commit();
		System.out.println("insert Record  Sucess .....");

	
	
	}

}
