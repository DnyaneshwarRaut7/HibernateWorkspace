package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsessonfactory();

		Session session = sf.openSession();

		Student s = new Student();
		s.setId(11);
		s.setName("Mauli");
		s.setAddress("pune");
		s.setMonumber(9898989898l);

		session.save(s);
		session.beginTransaction().commit();

		System.out.println(" Student Data Inserted Successfully");

	}

}
