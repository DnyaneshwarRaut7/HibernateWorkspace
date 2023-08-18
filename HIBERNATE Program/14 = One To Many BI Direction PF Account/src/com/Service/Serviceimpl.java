package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;
import com.entity.EPFAccount;
import com.entity.PFAccount;

public class Serviceimpl implements ServiceI {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addEPFAccountWithMultiplePFAccount() {
		Session session = sf.openSession();

		EPFAccount epf = new EPFAccount();

		System.out.println("Enter Employee Account Name");
		epf.setEname(sc.next());

		System.out.println("Enter User Name");
		epf.setUserName(sc.next());

		System.out.println("Enter  your Password");
		epf.setPassward(sc.next());

		System.out.println("How many You Want To add Pf Account ");
		int n = sc.nextInt();

		for (int i = 0;i<n; i++) {

			PFAccount pf = new PFAccount();

			System.out.println("Enter your Pf Account Name");
			pf.setPFname(sc.next());

			System.out.println("Enter your Pf Account Number");
			pf.setPFnumber(sc.next());

			epf.getPlist().add(pf);
		}
		session.save(epf);
		session.beginTransaction().commit();
		System.out.println("Data Inserted Sucessfully......");

	}

	@Override
	public void showAllEPFAccountWithPFAccount() {

		Session session = sf.openSession();
		Query<EPFAccount> query = session.createQuery("From EPFAccount");
		List<EPFAccount> list = query.getResultList();

		// System.out.println(list);
		for (EPFAccount epf : list) {

			System.out.println("------------------- EPFACCOUNT DETAILS --------------");

			System.out.println("Employee Account Id =  " + epf.getEid());
			System.out.println(" Employee Account Name =  " + epf.getEname());
			System.out.println(" User Name =  " + epf.getUserName());
			System.out.println("Employee Account your Password =  " + epf.getPassward());

			for (PFAccount pf : epf.getPlist()) {

				System.out.println("------------------- PF ACCOUNT DETAILS --------------");

				System.out.println("Pf Account Id =  " + pf.getPid());
				System.out.println("Pf Account Name =   " + pf.getPFname());
				System.out.println("pf Account Number =  " + pf.getPFnumber());
			}
			System.out.println("--------------------------------------------------------");
		}
	}

	@Override
	public void getSingleEPFAccountWithPFAccount() {
		

	}

	@Override
	public void updateEPFAccount() {

		Session session = sf.openSession();
		System.out.println("Enter your EPF Account Id");
		int id = sc.nextInt();
		EPFAccount epf = session.get(EPFAccount.class, id);
		if (epf != null) {

			System.out.println("Update Epf Account Name");
			epf.setEname(sc.next());

			System.out.println("Update EPF Account Passward ");
			epf.setPassward(sc.next());

			session.update(epf);
			session.beginTransaction().commit();
			System.out.println("Updated Data Sucessfuly");

		} else {
			System.out.println("EPF Account Id Is Not Present");
		}

	}

	@Override
	public void updatePerticularPFAccountUsingEPFAccointId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePerticularPFAccountUsingEPFAccointId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getSinglePFAccountWithEPFAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void showAllPFAccountWithEPFAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePFAccount() {


	}

	@Override
	public void updateEPFAccountUsingPFAccountId() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePerticularPFAccountUsingPFAccount() {
		// TODO Auto-generated method stub

	}

}
