package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();

		Employee e = new Employee();
		e.setEid(99);
		e.setEname("avi");
		e.setEaddress("hadapser");
		e.setSallary(2380);
		e.setEmail("avi@123");

		session.save(e);
		session.beginTransaction().commit();

		System.out.println("Save Employee Data......");

	}

}
