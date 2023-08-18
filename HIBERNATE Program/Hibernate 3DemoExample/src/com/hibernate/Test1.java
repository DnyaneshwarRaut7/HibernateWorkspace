package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate1.cfg.xml");

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		User u = new User();

		u.setUid(11);
		u.setUname("Mauli");
		u.setUaddress("Pune");
		u.setMob(9146229448l);
		u.setEmail("rautdnyaneshwar2001@gmail.com");
		u.setSallary(22.222);

		session.save(u);
		session.beginTransaction().commit();

		System.out.println("save user dara......");
	}

}
