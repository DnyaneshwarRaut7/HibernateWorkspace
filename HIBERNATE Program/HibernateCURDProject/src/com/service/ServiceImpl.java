package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.curd.HibernateUtil;
import com.curd.Student;

public class ServiceImpl implements StudentService {

	SessionFactory sf = HibernateUtil.getsessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addStudentInformention() {

		Session session = sf.openSession();

		Student s = new Student();

		System.out.println("How Many Student Add");
		int n = sc.nextInt();

		for (int i = 0; i <= n; i++) {

			System.out.println("add student id :");
			s.setId(sc.nextInt());

			System.out.println("Add Student Name :");
			s.setName(sc.next());

			System.out.println("Add Student Address:");
			s.setAddress(sc.next());

			System.out.println("Add Mobaile Number");
			s.setMono(sc.nextLong());

			System.out.println("Add Persentage ");
			s.setPersendage(sc.nextFloat());

			session.save(s);
			session.beginTransaction().commit();
			System.out.println("Student Data Insertd Successfully ...!");
		}

	}

	@Override
	public void fetchAllStudentDetails() {

		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();

		System.out.println(slist);
	}

	@Override
	public void fetchSingleStudentDetails() {

		Session session = sf.openSession();
		System.out.println("Enter Product Id");
		int id = sc.nextInt();
		Student s = session.get(Student.class, id);
		if (s != null) {
			System.out.println(s);
		} else
			System.out.println("Student Id is Not Present");
	}

	@Override
	public void updateStudentDetails() {

		Session session = sf.openSession();
		Student s = new Student();
		System.out.println("Enter Updated Student Id");
		int id = sc.nextInt();

		System.out.println("add student id :");
		s.setId(sc.nextInt());

		System.out.println("Add Student Name :");
		s.setName(sc.next());

		System.out.println("Add Student Address:");
		s.setAddress(sc.next());

		System.out.println("Add Mobaile Number");
		s.setMono(sc.nextLong());

		System.out.println("Add Persentage ");
		s.setPersendage(sc.nextFloat());

		session.update(s);
		session.beginTransaction().commit();

		System.out.println("Student Data Updated Successfully");

	}

	@Override
	public void deleteStudentDetails() {

		Session session = sf.openSession();
		Student s = new Student();
		System.out.println("Enter Studetd Delete Id");
		int id = sc.nextInt();
		Student s1 = session.get(Student.class, id);

		session.delete(s1);
		session.beginTransaction().commit();

		System.out.println("Student Data Deleted Successfully....!");
	}

}
