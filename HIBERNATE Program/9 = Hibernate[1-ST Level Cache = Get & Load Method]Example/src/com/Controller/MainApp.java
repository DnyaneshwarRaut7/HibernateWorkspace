package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;
import com.model.Student;

public class MainApp {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsessionFactory();
		Session session = sf.openSession();

		System.out.println("---- get method-----");
		// After query all details 100%
		Student student = session.get(Student.class, 1);
		System.out.println(student.getSid());
		System.out.println(student.getSname());
		System.out.println(student.getAddress());
		System.out.println(student.getMob());
		System.out.println(student.getMail_Id());

		System.out.println("------ Load Method -------");
		// Before Query 50%
		// After Query 50%
		Student student1 = session.load(Student.class, 4);
		System.out.println(student1.getSid());
		System.out.println(student1.getMail_Id());
		System.out.println(student1.getAddress());
		System.out.println(student1.getMob());
		System.out.println(student1.getSname());
	}

}
//get & load method Example
