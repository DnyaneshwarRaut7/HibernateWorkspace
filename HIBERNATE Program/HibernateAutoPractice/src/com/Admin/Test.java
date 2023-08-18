package com.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Companey;
import com.model.Employee;
import com.model.User;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		User u = new User();

		u.setUname("suraj");
		u.setUadress("rajuri");
		u.setMobno(9960175210l);
		u.setEmailid("suraj@123");

		Employee e = new Employee();
		e.seteName("shubham");
		e.setAddress("mumbai");
		e.setMobailno(877765778l);
		e.setEmailid("sanket@123gmail.com");

		Companey c = new Companey();
		c.setCname("Exponeant");
		c.setCaddress("Nigdi");

		session.save(u);
		session.save(e);
		session.save(c);

		session.beginTransaction().commit();

		System.out.println("Sucess.....");

	}

}
