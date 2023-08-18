package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Entity.Address;
import com.Entity.Student;
import com.Util.HibernateUtil;

public class ServiceIMPL implements Service {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	Scanner sc = new Scanner(System.in);
	Student s = new Student();
	Address a = new Address();

	@Override
	public void addStudentwithAddress() {

		System.out.println("Enter Student Name :-");
		s.setSname(sc.next());

		System.out.println("Enter City :-");
		a.setCity(sc.next());

		System.out.println("Enter Dist :- ");
		a.setDist(sc.next());

		s.setAddress(a);

		session.save(s);
		session.beginTransaction().commit();

	}

	@Override
	public void getAllStudentwiththeirAddress() {
		Session session = sf.openSession();

		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();
		System.out.println(slist);

	}

	@Override
	public void getSingleStudentwithAddeess() {
		System.out.println("Enter your Student ID ");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		if (s != null) {
			System.out.println(s);
		} else {
			System.out.println("Student Id not Present..");
		}

	}

	@Override
	public void deleteSingleStudent() {

		System.out.println("Enter your Student Id");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		if (s != null) {

			System.out.println(s);
			session.delete(s);
			session.beginTransaction().commit();

		} else {
			System.out.println("Id is Not Present ");
		}

	}

	@Override
	public void updateSingleStudent() {
		System.out.println(" Enter your Student Id ");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		if (s != null) {
			System.out.println(s);
			System.out.println("Enter your update Student Name ");
			s.setSname(sc.next());
			session.update(s);
			session.beginTransaction().commit();

			System.out.println("Enter your update City name ");
			a.setCity(sc.next());
			session.update(s);
			session.beginTransaction().commit();

			System.out.println("Enter Your Update Dist Name");
			a.setDist(sc.next());
			session.update(s);
			session.beginTransaction();

		} else {

			System.out.println("Student ID Not Present");
		}

	}

	@Override
	public void updateAddressUsingStudent() {

		System.out.println("Enter your Student ID ");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		System.out.println(s);
		if (s != null) {

			System.out.println("Update City Name ");
			s.getAddress().setCity(sc.next());
			session.update(s);
			session.beginTransaction().commit();

			System.out.println("Update Dist Name ");
			s.getAddress().setDist(sc.next());
			session.update(s);
			session.beginTransaction().commit();
		}

	}

}
