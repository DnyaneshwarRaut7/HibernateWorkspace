package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Util.HibernateUtil;
import com.entity.Battery;
import com.entity.Mobile;

public class Serviceimpl implements ServiceI {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addMobileAndBatteryDetails() { 
		Mobile mobile = new Mobile();
		Battery battery = new Battery();

		System.out.println("Enter your Mobile Name");
		mobile.setMname(sc.next());

		System.out.println("Enter your Mobile Compaeny Nmae");
		mobile.setMcompany(sc.next());

		System.out.println("Enter your Battery Name");
		battery.setBname(sc.next());

		System.out.println("Enter your Battery Mhpower");
		battery.setMh(sc.next());

		mobile.setBattery(battery);
		battery.setMobile(mobile);

		Session session = sf.openSession();
		session.save(mobile);
		session.save(battery);

		session.beginTransaction().commit();

		System.out.println("Data Insert Sucessfully.....");

	}

	@Override
	public void getsingleMobiledataWithBatteryusingMobailid() {
		Session session = sf.openSession();
		System.out.println("Enter your Mobile Id");
		int id = sc.nextInt();
		Mobile mobile = session.get(Mobile.class, id);

		if (mobile != null) {
			System.out.println("==== Mobile Data ====");
			System.out.println(mobile);
			System.out.println("==== Battery data ====");

			System.out.println("Battery Id :-" + mobile.getBattery().getBid());
			System.out.println("Battery Name :- " + mobile.getBattery().getBname());
			System.out.println("Battery Mh Power:-" + mobile.getBattery().getMh());
		} else {

			System.out.println("Mobile Id is not Present ");
		}

	}

	@Override
	public void getAllMobiledatawithBattery() {
		Session session = sf.openSession();
		Query<Mobile> mobile = session.createQuery("from Mobile");
		List<Mobile> mlist = mobile.getResultList();
		System.out.println(mlist);

	}

	@Override
	public void getAllMobileDatawithBatteryUsingBattery() {
		Session session = sf.openSession();
		Query<Battery> battery = session.createQuery("from Battery ");
		List<Battery> blist = battery.getResultList();
		System.out.println(blist);

	}

	@Override
	public void updateMobileData() {
		Session session = sf.openSession();

		System.out.println("Enter your Mobile id ");
		int id = sc.nextInt();

		Mobile mobile = session.get(Mobile.class, id);

		System.out.println("Enter your update Mobile Name ");
		mobile.setMname(sc.next());

		System.out.println("Enter Your Update Mobile Company Name ");
		mobile.setMcompany(sc.next());

		session.update(mobile);
		session.beginTransaction().commit();

		System.out.println("--- Updated Mobile Data ---");

	}

	@Override
	public void updateBatteryUsingMobileId() {
		Session session = sf.openSession();

		System.out.println("Enter your mobile Id");
		int id = sc.nextInt();
		Mobile mobile = session.get(Mobile.class, id);
		System.out.println("Update Battery Name");
		mobile.getBattery().setBname(sc.next());

		System.out.println("Update Battery Mh Power ");
		mobile.getBattery().setMh(sc.next());

		session.update(mobile);
		session.beginTransaction().commit();
	}

	@Override
	public void getSingleMobiledataWithBatteryusingBatteryid() {

		Session session = sf.openSession();
		System.out.println("Enter your Battery Id");
		int id = sc.nextInt();

		Battery battery = session.get(Battery.class, id);

		System.out.println("==== Battery data ====");

		System.out.println("Battery Id :-" + battery.getBid());
		System.out.println("Battery Name :- " + battery.getBname());
		System.out.println("Battery Mh Power:-" + battery.getMh());

		System.out.println("---- Mobile Data ----");

		System.out.println("Mobail Id:- " + battery.getMobile().getMid());
		System.out.println("Mobile Name:-" + battery.getMobile().getMname());
		System.out.println("Mobile Compaeny Name:-" + battery.getMobile().getMcompany());

		session.save(battery);
		session.beginTransaction().commit();

	}

	@Override
	public void updateBatteryData() {
		Session session = sf.openSession();

		System.out.println("Enter your Battery Id ");
		int id = sc.nextInt();

		Battery battery = session.get(Battery.class, id);

		System.out.println("Enter your update Battery Name");
		battery.setBname(sc.next());
		System.out.println("Enter your update Battery MH Power");
		battery.setMh(sc.next());

		session.update(battery);
		session.beginTransaction().commit();

	}

	@Override
	public void updateMobiledatausingBattery() {
		Session session = sf.openSession();
		System.out.println("Enter Battery Id");
		int id = sc.nextInt();

		Battery battery = session.get(Battery.class, id);
		System.out.println("Enter your update Mobile Name");
		battery.getMobile().setMname(sc.next());

		System.out.println("Enter your update Mobile Company Name");
		battery.getMobile().setMcompany(sc.next());

		session.update(battery);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteMobile() {
		Session session = sf.openSession();

		System.out.println("Enter your mobile id");
		int id = sc.nextInt();

		Mobile mobile = session.get(Mobile.class, id);

		session.delete(mobile);
		session.beginTransaction().commit();

		System.out.println("Delete Mobail Data");

	}

}
