package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Student;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsessionFactory();
		Session session = sf.openSession();

//		Student student = new Student();
//		student.setSname("Suraj");
//		student.setAddress("Rajuri");
//		student.setMob(9172759448l);
//		student.setMail_Id("suraj@123");
//		
//	session.save(student);
//		session.beginTransaction().commit();
		
		// Student data set

		Student student1 = session.get(Student.class, 1);
		System.out.println(student1);

		System.out.println("-------------------------------------");
		// remove particular object from first level cache
		// single object remove
		// session MADHUN remove data
		session.evict(student1);

		// to clear all object from the first level cache
		// Delete all the object from the cache /session
		session.clear();
		
		Student studenr2 = session.get(Student.class, 1);
		System.out.println(studenr2);

	}

}
//== first level cache Example
//1== We can ID pass get method First time Query fire
//2== We can Same Id pass get Method not query fire in output 