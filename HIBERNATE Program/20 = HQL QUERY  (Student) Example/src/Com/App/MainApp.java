package Com.App;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Com.Model.Student;
import Com.Util.HibernateUtil;

public class MainApp {

	private static void dataInsert(Session session) {
		Scanner sc = new Scanner(System.in);

		Student s = new Student();

		System.out.println("Enter your Student Name");
		s.setName(sc.next());
		System.out.println("Enter Your Student Address");
		s.setAddress(sc.next());
		System.out.println("Enter Your Student BachName");
		s.setBachname(sc.next());
		System.out.println("Enter Your Student fess");
		s.setFees(sc.nextDouble());
		System.out.println("Enter Your Student Current Date");
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");
		String joindate = dateformat.format(date);
		s.setJoindate(joindate);

		System.out.println("Enter Your Student flag");
		s.setFlag(sc.nextBoolean());

		session.save(s);
		session.beginTransaction().commit();

	}

	private static void findMaxFee(Session session) {
// large fee record
		Query<Double> query = session.createQuery("select max (fees) from Student");
		double maxfee = query.getSingleResult();
		System.out.println(maxfee);
	}

// small fee  record
	private static void finMinimumFee(Session session) {
		Query<Double> query = session.createQuery("select min (fees) from Student");
		double minfee = query.getSingleResult();
		System.out.println(minfee);
	}

// Average Sarasari
	private static void getAvg(Session session) {
		Query<Double> query = session.createQuery("select avg (fees) from Student");
		Double avgfee = query.getSingleResult();
		System.out.println(avgfee);

	}

	// Peasant record show
	private static void getCount(Session session) {
		Query<Long> query = session.createQuery("select count (*) from Student");
		Long count = query.getSingleResult();
		System.out.println(count);
	}

// secound max  fees record
	private static void secoundMaxFees(Session session) {
		Query<Double> query = session
				.createQuery("select max (fees) from Student where (fees)< (select max (fees) from Student)");
		Double secoundMaxFee = query.getSingleResult();
		System.out.println(secoundMaxFee);
	}

// show Named & Address Data Show// single Student Show
	private static void getStudentNmaeAndAddress(Session session) {
		Query<Object[]> query = session.createQuery("select name,address from Student where id =:id1");
		query.setParameter("id1", 1);
		Object[] obj = query.getSingleResult();
		System.out.println("Name  :-" + obj[0] + "  Address  :- " + obj[1]);
	}

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		MainApp mp = new MainApp();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===================================================");
			System.out.println("1. Inset Data");
			System.out.println("2. Maxmimum fees Student");
			System.out.println("3. Minimum Fees Student");
			System.out.println("4. Get Avreage");
			System.out.println("5. Get Count");
			System.out.println("6. Secound Max Fees");
			System.out.println("7. Name And Address Informention Student");
			System.out.println("------------------------------");

			System.out.println("Enter Your Choice ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				mp.dataInsert(session);
				break;
			case 2:
				mp.findMaxFee(session);
				break;
			case 3:
				mp.finMinimumFee(session);
				break;
			case 4:
				mp.getAvg(session);
				break;
			case 5:
				mp.getCount(session);
				break;
			case 6:
				mp.secoundMaxFees(session);
				break;
			case 7:
				mp.getStudentNmaeAndAddress(session);
			default:
				break;
			}

		}

	}

}
