package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;

import com.entity.AdhaarCard;
import com.entity.AdhaarInfoOffice;
import com.entity.PanCard;

public class ServiceImple implements ServiceI {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addAdhaarInfoOfficeandAdhaarCardWithPanCardData() {

		Session session = sf.openSession();

		AdhaarInfoOffice ao = new AdhaarInfoOffice();

		System.out.println("Enter Adhaar Center Name:- ");
		ao.setCenterName(sc.next());

		System.out.println("Enter Adhaar AddressCenter Address");
		ao.setCenterAdders(sc.next());

		System.out.println(" How Many Adhaarcard To Be Insert In To Adhaar Center");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			AdhaarCard ac = new AdhaarCard();

			System.out.println("Enter Adhaar Card HolderName");
			ac.setHolderName(sc.next());

			System.out.println("Enter Adhaar Card  Address");
			ac.setAddress(sc.next());

			System.out.println("Enter Adhaar DateOfBirth");
			ac.setDateofbirth(sc.next());

			System.out.println("Enter Adhaar MobailNumber");
			ac.setMobileNO(sc.nextLong());

			ao.getAdhar().add(ac);

			PanCard pc = new PanCard();

			System.out.println("Enter PanName ");
			pc.setPanName(sc.next());

			System.out.println("Enter PanNo");
			pc.setPanno(sc.next());

			System.out.println("Enter Pan Valid Date");
			pc.setValidDate(sc.nextLong());

			ac.setPancard(pc);

			session.save(ao);

			session.beginTransaction().commit();
			System.out.println("Data Inserted Sucessfully.......");

		}

	}

	@Override
	public void showAllAdhaarInfoOfficeData() {

		Session session = sf.openSession();
		Query<AdhaarInfoOffice> query = session.createQuery("From AdhaarInfoOffice");
		List<AdhaarInfoOffice> list = query.getResultList();

		for (AdhaarInfoOffice aa : list) {

			System.out.println("------------Adhar Office InformentionDetails --------------- ");
			System.out.println(" Adhar center Name:-" + aa.getCenterName());
			System.out.println("Adhar Center Adddress:-" + aa.getCenterAdders());

			for (AdhaarCard ac : aa.getAdhar()) {

				System.out.println("--------------- Adhaar Card Informention ---------------");
				System.out.println("Adhaar Holder Name :-" + ac.getHolderName());
				System.out.println("Adhaar Card Address:-" + ac.getAddress());
				System.out.println("Adhaar Card Date Of Birth:-" + ac.getDateofbirth());
				System.out.println("Adhaar Card Mobail No:-" + ac.getMobileNO());

				PanCard pp = ac.getPancard();
				System.out.println("-------------------PanCard Informention -----------------");
				System.out.println("Pan Nmae:-" + pp.getPanName());
				System.out.println("Pan Number:-" + pp.getPanno());
				System.out.println("Pan Valied Date:-" + pp.getValidDate());
			}
			System.out.println("===============================================================");
		}
	}

	@Override
	public void getSingleAdhaarInfoOfficeData() {
		Session session = sf.openSession();
		System.out.println("Enter AdharOffice Id");
		int id = sc.nextInt();
		AdhaarInfoOffice ao = session.get(AdhaarInfoOffice.class, id);
		if (ao != null) {
			System.out.println("Adhaar Office Id:-" + ao.getCid());
			System.out.println("Adhar Office Name:-" + ao.getCenterName());
			System.out.println("Adhaar Office Address:-" + ao.getCenterAdders());

		} else {
			System.out.println("Center Id Is Not Present");
		}
	}

	@Override
	public void updateAdhaarInfoOfficeData() {
		Session session = sf.openSession();

		System.out.println("Enter your Adhaar Office ID");
		int id = sc.nextInt();

		AdhaarInfoOffice ao = session.get(AdhaarInfoOffice.class, id);
		if (ao != null) {
			boolean flag = true;
			while (flag) {
				System.out.println("-----------------------------------------");
				System.out.println("1.  Update Center Name");
				System.out.println("2.  Update Center Address");
				System.out.println("3.  exit");
				System.out.println("-----------------------------------------");

				System.out.println("Enter Your Choice");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					System.out.println(ao.getCenterName());
					System.out.println(" Update Center Name");
					ao.setCenterName(sc.next());
					session.update(ao);
					session.beginTransaction().commit();
					System.out.println("Updated Data Sucessfully");

					break;

				case 2:
					System.out.println(ao.getCenterAdders());
					System.out.println("Update Center Address");
					ao.setCenterAdders(sc.next());

					session.update(ao);
					session.beginTransaction().commit();
					System.out.println("Updated Data Sucessfully");
					break;

				case 3:
					flag = false;
					break;

				default:
					break;

				}
			}

		} else {

			System.out.println("Center Id is Not Present");
		}
	}

	@Override
	public void updateAdhaarCardUsingAdhaarInfoOfficeId() {
		Session session = sf.openSession();

		System.out.println("Enter your Adhaar Office Id");
		int id = sc.nextInt();

		AdhaarInfoOffice ao = session.get(AdhaarInfoOffice.class, id);

		if (ao != null) {

			for (AdhaarCard ac : ao.getAdhar()) {

				System.out.println("Enter your Adhaaar Card Id");
				int id1 = sc.nextInt();

				System.out.println("Update Adhaar Holder Name");
				ac.setHolderName(sc.next());

				System.out.println("Update Adhaar Card Address");
				ac.setAddress(sc.next());

				System.out.println("Updare Adhaar Crad Date Of Birth");
				ac.setDateofbirth(sc.next());

				System.out.println("Update Adhaar Card Mobail NO");
				ac.setMobileNO(sc.nextLong());

				session.update(ac);
				session.beginTransaction().commit();

				System.out.println("Updated Adhard Data Sucessfully");

			}

		} else {

			System.out.println("Center Id is Not Present");
		}

	}

}
