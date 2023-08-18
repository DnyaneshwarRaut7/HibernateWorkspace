package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.entity.Student;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		// data set

//		Student s = new Student();
//		s.setSname("Suraj");
//		s.setsAddress("Pune");
//
//		Session session = sf.openSession();
//		session.save(s);
//
//		session.beginTransaction().commit();
//		System.out.println("sucessfully");
//		
		System.out.println("-------- FIRST LEVEL CACHE ------------");
		// It is a known as session
		// first time query fire
		// Secound time qery not fire
		// Same Id Pass
		// not thread safe
		Session session = sf.openSession();
		Student s = session.get(Student.class, 1);
		System.out.println(s);

		System.out.println("=========================================================");

		Student s1 = session.get(Student.class, 1);
		System.out.println(s1);

		System.out.println("------------- Secound level cache --------------------");
		// it is known as session factory
		// session object double
		// first time query fire
		// Second time query not fire
		// Same Id Pass
		// thread safe

		Session session1 = sf.openSession();
		Student s2 = session.get(Student.class, 2);
		System.out.println(s2);

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		Session session2 = sf.openSession();
		Student s3 = session.get(Student.class, 1);
		System.out.println(s3);

	}

}
