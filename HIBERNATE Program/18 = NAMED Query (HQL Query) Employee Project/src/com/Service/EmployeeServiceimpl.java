package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Employee;
import com.Util.HibernateUtil;

public class EmployeeServiceimpl implements EmployeeServiceI {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void insertData() {
		Employee e = new Employee();
		Session session = sf.openSession();

		System.out.println("Enter your Employee Name");
		e.setName(sc.next());

		System.out.println("Enter Your Employee Address");
		e.setAddress(sc.next());

		System.out.println("Enter Your User Name");
		e.setuNmae(sc.next());

		System.out.println("Enter Your Passwrd");
		e.setPass(sc.next());

		session.save(e);
		session.beginTransaction().commit();
		System.out.println("Data Inserted Sucessully.... ");

	}

	@Override
	public void getSinleDta() {

		Session session = sf.openSession();
		System.out.println("Enter Your Employee Id:-");
		int idd = sc.nextInt();
		Query<Employee> query = session.createNamedQuery("findusingid");
		query.setParameter("id1", idd);
		Employee ee = query.getSingleResult();
		System.out.println(ee);

	}

	@Override
	public void showAllData() {
		Session session = sf.openSession();
		Query<Employee> query = session.createNamedQuery("findall");
		List<Employee> elist = query.getResultList();
		System.out.println(elist);

	}

	@Override
	public void updateData() {
		
		Session session= sf.openSession();
		session.beginTransaction();
		System.out.println("Enter your id");
		int id = sc.nextInt();
		
		System.out.println("Entert your Update Name");
		String nm = sc.next();
		
		System.out.println("Enter your Update Address ");
		String as = sc.next();
		
		System.out.println("Enter Your Update Uname");
		String un = sc.next();
		
		System.out.println("Enter Your Update Password");
		String ps = sc.next();
		
		Query<Employee>query = session.createNamedQuery("updatedata");
		query.setParameter("n", nm);
		query.setParameter("a", as);
		query.setParameter("u", un);
		query.setParameter("p", ps);
		query.setParameter("id1", id);
		
		query.executeUpdate();
		System.out.println("update sucessfully");
		
	}

	@Override
	public void deleteData() {

	Session session = sf.openSession();
	session.beginTransaction();
	System.out.println("Enter your id");
	int id = sc.nextInt();
	Query<Employee>query = session.createNamedQuery("deletesingleid");
	query.setParameter("id1", id);
    query.executeUpdate();
//	
	}

}
