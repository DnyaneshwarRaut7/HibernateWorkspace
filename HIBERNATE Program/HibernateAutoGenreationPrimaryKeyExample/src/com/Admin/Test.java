package com.Admin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.model.Student;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getsessionFactory();

		Session session = sf.openSession();

		Student s = new Student();
		s.setSname("Mauli");
		s.setSaddress("pune");

		Employee e = new Employee();
		e.setEname("Rohit");
		e.setEaddress("nigdi");

		session.save(s);
		session.save(e);
		session.beginTransaction().commit();

		System.out.println("Data Inserted.....");

	}

}
