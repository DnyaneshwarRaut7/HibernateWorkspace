package com.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Util.HibrnateUtil;
import com.entity.TeamLeader;
import com.entity.TeamMember;

public class Serviceimple implements ServiceI {

	SessionFactory sf = HibrnateUtil.getseSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addTeamLeadDataWithTeamMemberData() {
		Session session = sf.openSession();
		TeamLeader tl = new TeamLeader();

		System.out.println("Enter your TeamLeader Name.");
		tl.setTeamleaderName(sc.next());

		System.out.println("Enter your  TeamLeader Designation.");
		tl.setDesignation(sc.next());

		System.out.println("Enter your Mail_Id");
		tl.setMaild(sc.next());

		System.out.println("Enter your Mobaile Number.");
		tl.setMobailno(sc.nextLong());

		System.out.println("How Many Team Member You Want To add ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			TeamMember tm = new TeamMember();

			System.out.println("Enter your Team Member Name.");
			tm.setTeamMemberName(sc.next());

			System.out.println("Enter your Team Member Project.");
			tm.setProjectName(sc.next());

			System.out.println("Enter Your Team Member MailId.");
			tm.setEMailid(sc.next());

			tl.getList().add(tm);

		}
		session.save(tl);
		session.beginTransaction().commit();
		System.out.println("Data Inserted Sucessfully");

	}

	@Override
	public void getSingleTeamLeadData() {

		Session session = sf.openSession();
		System.out.println("Enter your Team Leader Id");
		int id = sc.nextInt();
		TeamLeader tl = session.get(TeamLeader.class, id);

		if (tl != null) {

			System.out.println("Team Leader Nmae   " + tl.getTeamleaderName());

			System.out.println("Team Leader Designatin   " + tl.getDesignation());

			System.out.println("Team Leader MailId   " + tl.getMaild());

			System.out.println("Team Leader Mobaile Number   " + tl.getMobailno());

		} else {
			System.out.println("Team Leader Id is Not Present");
		}

	}

	@Override
	public void showAllData() {
		Session session = sf.openSession();
		Query<TeamLeader> query = session.createQuery("from TeamLeader");
		List<TeamLeader> list = query.getResultList();

		// System.out.println(list);
		for (TeamLeader tl : list) {
			System.out.println("-------------- Team Leader Data ------------------");

			System.out.println("Team Leader Nmae   " + tl.getTeamleaderName());
			System.out.println("Team Leader Designatin   " + tl.getDesignation());
			System.out.println("Team Leader MailId   " + tl.getMaild());
			System.out.println("Team Leader Mobaile Number   " + tl.getMobailno());

			for (TeamMember tm : tl.getList()) {

				System.out.println("------------ TEAM MEMBER DATA---------------");

				System.out.println("Team Member Name   " + tm.getTeamMemberName());
				System.out.println("Team Member Project   " + tm.getProjectName());
				System.out.println("Team Member Email Id   " + tm.getEMailid());
			}
			System.out.println("________________________________________________________");
		}
	}

	@Override
	public void updateTeamLeadData() {
		Session session = sf.openSession();
		System.out.println("Enter your TeamLeader Id");
		int id = sc.nextInt();

		TeamLeader tl = session.get(TeamLeader.class, id);
		if (tl != null) {

			while (true) {
				System.out.println("___________________________________________________");
				System.out.println(" 1. Update Team Leader Name ");
				System.out.println(" 2. Update Desgnation");
				System.out.println(" 3. Update Email Id  ");
				System.out.println(" 4. Update Mobaile Number ");
				System.out.println(" 5. Exit");
				System.out.println("__________________________________________________________");

				System.out.println("Enter your Choice");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					System.out.println("Update Team Leader Name ");
					tl.setTeamleaderName(sc.next());
					session.update(tl);
					session.beginTransaction().commit();

					break;

				case 2:
					System.out.println("Update Desgnation");
					tl.setDesignation(sc.next());
					session.update(tl);
					session.beginTransaction().commit();

					break;

				case 3:
					System.out.println("Update Email Id ");
					tl.setMaild(sc.next());
					session.update(tl);
					session.beginTransaction().commit();

					break;

				case 4:
					System.out.println("Update Mobaile Number");
					tl.setMobailno(sc.nextLong());
					session.update(tl);
					session.beginTransaction().commit();
					break;
					
				case 5:
					
				default:
					System.out.println("Wrong Choice");
					sc.close();
					break;
				}

//				System.out.println("Update Team Leader Name ");
//				tl.setTeamleaderName(sc.next());
//
//				System.out.println("Update Desgnation");
//				tl.setDesignation(sc.next());
//
//				System.out.println("Update Email Id ");
//				tl.setMaild(sc.next());
//
//				System.out.println("Update Mobaile Number");
//				tl.setMobailno(sc.nextLong());
//
//				session.update(tl);
//				session.beginTransaction().commit();
//				System.out.println("Updated Data Sucessfully");
			}
			//System.out.println("sucessfully Updated");
		} else {

			System.out.println("Team Leader Id is Not Present ");
		}

	}

	@Override
	public void updatePerticularTeamMemberData() {
		Session session = sf.openSession();
		System.out.println("Enter your TeamLeader Id");
		int id = sc.nextInt();

		TeamLeader tl = session.get(TeamLeader.class, id);
		if (tl != null) {

			for (TeamMember tm : tl.getList()) {
				System.out.println("Update Team Member Name");
				tm.setTeamMemberName(sc.next());

				System.out.println("Update Team Member Project ");
				tm.setProjectName(sc.next());

				System.out.println("Update Team Member E_Mail");
				tm.setEMailid(sc.next());

				session.update(tm);
				session.beginTransaction().commit();

				System.out.println("Updated Data Sucessfully");
			}

		} else {
			System.out.println(" Id is Not Present");

		}
	}

	@Override
	public void deleteTeamLeaderData() {
		Session session = sf.openSession();
		System.out.println("Enter your TeamLeader Id");
		int id = sc.nextInt();

		TeamLeader tl = session.get(TeamLeader.class, id);
		if (tl != null) {

			System.out.println(tl);

			session.delete(tl);
			session.beginTransaction().commit();
			System.out.println("Delete Data Sucessfully");
		} else {
			System.out.println("Team Leader Id is not Present");
		}

	}

}
