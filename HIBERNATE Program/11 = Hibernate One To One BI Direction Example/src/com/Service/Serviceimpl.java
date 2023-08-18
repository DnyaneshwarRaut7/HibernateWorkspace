package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Entity.Car;
import com.Entity.Engine;
import com.Util.HibernateUtil;

public class Serviceimpl implements ServiceI {

	SessionFactory sf = HibernateUtil.getseSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCarAndEngineDetails() {
		Car car = new Car();
		Engine engine = new Engine();

		System.out.println("Enter your Car Name:-");
		car.setCname(sc.next());

		System.out.println("Enter your Car Type:-");
		car.setCtype(sc.next());

		System.out.println("Enter Engine Name:- ");
		engine.setEname(sc.next());

		System.out.println("Enter Engine Model:- ");
		engine.setModel(sc.next());

		car.setEngine(engine);
		engine.setCar(car);

		Session session = sf.openSession();
		session.save(car);
		session.save(engine);

		session.beginTransaction().commit();
		System.out.println("Data Inserted");

	}

	@Override
	public void getSingleCarDataWithEngineUsingCarId() {

		Session session = sf.openSession();

		System.out.println("enter your car Id:-");
		int id = sc.nextInt();

		Car car = session.get(Car.class, id);
		if (car != null) {

			System.out.println("===== CAR DATA =====");
			System.out.println("Car Id = " + car.getCid());
			System.out.println("Car Name =  " + car.getCname());
			System.out.println("Car Type  = " + car.getCtype());

			System.out.println("===== ENGINE DATA");
			System.out.println("Engine Id = " + car.getEngine().getEid());
			System.out.println("Engine Nmae  = " + car.getEngine().getEname());
			System.out.println("Engine Model =  " + car.getEngine().getModel());
		} else {

			System.out.println("Car Id Not Present");
		}

	}

	@Override
	public void getAllCarDataWithEngine() {

		Session session = sf.openSession();
		Query<Car> query = session.createQuery("from Car");
		List<Car> clist = query.getResultList();
		for (Car car1 : clist) {

			System.out.println("--------------- CAR DATA -------------");
			System.out.println("Car Name =  " + car1.getCname());
			System.out.println("Car Type  = " + car1.getCtype());
			System.out.println("------------- ENGINE DATA-----------");
			System.out.println("Engine Nmae  = " + car1.getEngine().getEname());
			System.out.println("Engine Model =  " + car1.getEngine().getModel());

		}

	}

	@Override
	public void getAllCarDatawithEngineUsingEngine() {
		Session session = sf.openSession();
		Query<Engine> query = session.createQuery("from Engine");
		List<Engine> elist = query.getResultList();
		for (Engine engine1 : elist) {

			System.out.println("------------- ENGINE DATA-----------");
			System.out.println("Engine Nmae  = " + engine1.getEname());
			System.out.println("Engine Model =  " + engine1.getModel());

			System.out.println("--------------- CAR DATA -------------");
			System.out.println("Car Name =  " + engine1.getCar().getCname());
			System.out.println("Car Type  = " + engine1.getCar().getCtype());

		}
	}

	@Override
	public void updateCarData() {
		Session session = sf.openSession();
		System.out.println("Enter car id ");
		int id = sc.nextInt();
		Car car = session.get(Car.class, id);
		if (car != null) {

			System.out.println("Enter update Car Name");
			car.setCname(sc.next());

			System.out.println("Enter update car Type");
			car.setCtype(sc.next());

			session.update(car);
			session.beginTransaction().commit();
		} else {

			System.out.println("Enter Id is Not Present");
		}
	}

	@Override
	public void updateEngineUsingCarId() {
		Session session = sf.openSession();
		System.out.println("Enter Your Car Id");
		int id = sc.nextInt();
		Car car = session.get(Car.class, id);
		if (car != null) {

//			System.out.println("Enter update Car Name");
//			car.setCname(sc.next());
//
//			System.out.println("Enter update car Type");
//			car.setCtype(sc.next());

			System.out.println("Enter Update Engine Name");
			car.getEngine().setEname(sc.next());

			System.out.println("Engine Update Engine Model");
			car.getEngine().setModel(sc.next());

			session.update(car);
			session.beginTransaction().commit();
		} else {

			System.out.println("Enter Id is Not Present");
		}

	}

	@Override
	public void getSingleCarDataUsingEngineId() {

		Session session = sf.openSession();
		System.out.println("Enter your Engine Id:-");
		int id = sc.nextInt();
		Engine engine = session.get(Engine.class, id);
		if (engine != null) {

			System.out.println("===== ENGINE DETAIL ======");
			System.out.println("Engine Id = " + engine.getEid());
			System.out.println("Engine Name =  " + engine.getEname());
			System.out.println("Engine model  = " + engine.getModel());

			System.out.println("===== CARE DETAILS =======");
			System.out.println("Car Id = " + engine.getCar().getCid());
			System.out.println("Car Nmae  = " + engine.getCar().getCname());
			System.out.println("Car type =  " + engine.getCar().getCtype());
		} else {

			System.out.println("Engine Id Not Present");
		}
	}

	@Override
	public void updateEngine() {

		Session session = sf.openSession();
		System.out.println("Enter your Engine Id");
		int id = sc.nextInt();

		Engine engine = session.get(Engine.class, id);
		if (engine != null) {

			System.out.println("Enter Update Engine Name:-");
			engine.setEname(sc.next());

			System.out.println("Engine Update Engine Model:-");
			engine.setModel(sc.next());

			session.update(engine);
			session.beginTransaction().commit();

		} else {

			System.out.println("Engine Id not Present ");
		}

	}

	@Override
	public void updateCarDataUsingEngine() {

		Session session = sf.openSession();
		System.out.println("Enter your Engine Id");
		int id = sc.nextInt();

		Engine engine = session.get(Engine.class, id);
		if (engine != null) {

//			System.out.println("Enter Update Engine Name:-");
//			engine.setEname(sc.next());
//
//			System.out.println("Enter Update Engine Model:-");
//			engine.setModel(sc.next());

			System.out.println("Enter Update Car Name");
			engine.getCar().setCname(sc.next());

			System.out.println("Enter Update Car Type");
			engine.getCar().setCtype(sc.next());

			session.update(engine);
			session.beginTransaction().commit();

		} else {

			System.out.println("Engine Id not Present ");
		}

	}

	@Override
	public void deleteCar() {
		Session session = sf.openSession();
		System.out.println("Enter your car Id:-");
		int id = sc.nextInt();

		Car car = session.get(Car.class, id);

		session.delete(car);
		session.beginTransaction().commit();

		System.out.println(" Car Sucessfully");

	}

}
