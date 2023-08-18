package com.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.City;
import com.model.Product;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getseSessionFactory();

		Session session = sf.openSession();

		Product p = new Product();
		p.setPname("bag");
		p.setPaddress("Pimperi");
		p.setEmailid("Mauli@123");
		p.setActive(false);

		City c = new City();

		c.setCName("shivajinager");
		c.setDistric("Pune");
		c.setActive(true);
		session.save(p);
		session.save(c);

		session.beginTransaction().commit();

		System.out.println("Data Incerted....");

	}

}
