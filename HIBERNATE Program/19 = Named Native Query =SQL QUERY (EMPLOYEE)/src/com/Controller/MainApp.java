package com.Controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.sql.CaseFragment;

import com.Util.HibernateUtil;
import com.entity.Employee;

public class MainApp {

	private static void addEmployeeData(Session session) {

		Scanner sc = new Scanner(System.in);

		Employee e = new Employee();
		System.out.println("Enter Your Employee Name:-");
		e.setName(sc.next());
		System.out.println("Enter Your Employee Address:-");
		e.setAddress(sc.next());
		System.out.println("Enter Your User Name:-");
		e.setUname(sc.next());
		System.out.println("Enter Your Passward:-");
		e.setPass(sc.next());
		session.beginTransaction();

		// Query<Employee> query = session.createNamedQuery("Insertdata");
		Query<Employee> query = session.getNamedNativeQuery("Insertdata");
		query.setParameter(1, e.getId());
		query.setParameter(2, e.getName());
		query.setParameter(3, e.getAddress());
		query.setParameter(4, e.getUname());
		query.setParameter(5, e.getPass());
		query.executeUpdate();
	}

	private static void getEmployeeDataUsingId(Session session) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Employee Id:-");
		int id = sc.nextInt();

		Query<Employee> query = session.getNamedNativeQuery("getsingledata");
		query.setParameter(1, 1);
		Employee employee = query.getSingleResult();
		System.out.println(employee);
	}

	private static void getUsingLikeClause(Session session) {

		Query<Employee> query = session.getNamedNativeQuery("likequery");
		List<Employee> employee = query.getResultList();
		System.out.println(employee);
	}

	private static void showAlldata(Session session) {

		Query<Employee> query = session.getNamedNativeQuery("alldata");
		List<Employee> employee = query.getResultList();
		System.out.println(employee);

	}

	private static void updateSingledata(Session session) {
		Scanner sc = new Scanner(System.in);
		Employee e = new Employee();

		System.out.println("Enter your Employee Id:-");
		int id = sc.nextInt();

		System.out.println("Enter Your Employee Name:-");
		e.setName(sc.next());
		session.beginTransaction();

		Query<Employee> query = session.getNamedNativeQuery("updatesingledata");
		query.setParameter(1, id);
		query.setParameter(2, e.getName());
		query.executeUpdate();

	}

	private static void getNameAndAddrss(Session session) {

		Query query = session.getNamedNativeQuery("customquery");
		// array list data Object index
		List<Object[]> l = query.getResultList();
		// Enhance for loop
		for (Object[] obj : l) {

			System.out.println("Name :  " + obj[0] + "Address :  " + obj[1]);
		}
	}

	private static void getNameAndAddressUsingId(Session session) {
		Query query = session.getNamedQuery("customqueryusingid");
		query.setParameter(1, 1);
		List<Object[]> emp = query.getResultList();
		// enhance For Loop
		for (Object[] o : emp) {

			System.out.println("Name :  " + o[0] + "Address : " + o[1]);
		}

	}

	private static void getCount(Session session) {

		Query query = session.getNamedNativeQuery("countquery");
		BigInteger count = (BigInteger) query.getSingleResult();
		System.out.println(count);
	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getseSessionFactory();
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		MainApp mp = new MainApp();

		// Boolean flag = true();
		while (true) {

			System.out.println("1. Add Employee Details");
			System.out.println("2. Get Employee Data Using Id");
			System.out.println("3. Get Using Like Clause Data");
			System.out.println("4. Show All Data");
			System.out.println("5. Update Single Data");
			System.out.println("6. Get Name And Address Data Show");
			System.out.println("7. Get Name And Address Using Id Data Show");
			System.out.println("8. Get Count Data");
			System.out.println("====================================================");

			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				mp.addEmployeeData(session);

				break;
			case 2:
				mp.getEmployeeDataUsingId(session);

				break;
			case 3:
				mp.getUsingLikeClause(session);

				break;
			case 4:
				mp.showAlldata(session);
				break;
			case 5:
				mp.updateSingledata(session);
				

				break;
			case 6:
				mp.getNameAndAddrss(session);
				
				break;
			case 7:
				mp.getNameAndAddressUsingId(session);


				break;
			case 8:
				mp.getCount(session);
				break;

			default:
				break;
			}

		}

		// addEmployeeData(session);
		// getEmployeeDataUsingId(session);
		// getUsingLikeClause(session);
		// showAlldata(session);
		// updateSingledata(session);
		// getNameAndAddrss(session);
		// getNameAndAddressUsingId(session);
		// getCount(session);

	}

}
