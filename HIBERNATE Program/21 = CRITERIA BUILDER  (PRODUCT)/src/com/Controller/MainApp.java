package com.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.Model.Product;
import com.Util.HibernateUtil;

public class MainApp {
// product data  informention add
	private static void addProductDetails(Session session) {
		Product p = new Product();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Product Name:-");
		p.setPname(sc.nextLine());
		System.out.println("Enter your Product Price:-");
		p.setPrice(sc.nextDouble());
		System.out.println("Enter your Product Categery:-");
		p.setCategery(sc.next());

		session.save(p);
		session.beginTransaction().commit();

		System.out.println("Data Insert Sucessfully........");

	}

// all product data show
	private static void getAllData(Session sessio) {

		CriteriaBuilder builder = sessio.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root);

		Query<Product> query = sessio.createQuery(criteriaQuery);
		List<Product> plist = query.getResultList();
		//System.out.println(plist);
		for(Product pp : plist) {
			
			System.out.println("======  PRODUCT DETAILS ==========");
			System.out.println(" Product Id :- " + pp.getId());
			System.out.println(" Product Name :- " + pp.getPname());
			System.out.println(" Product price :- " + pp.getPrice());
			System.out.println(" Product categery :- " + pp.getCategery());
		}
		System.out.println("=======================================================");
	}
	// select * from product where id = ?
	// we can id pass than single id data show

	private static void getProductDataUsingId(Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root).where(builder.equal(root.get("id"), 2));

		Query<Product> query = session.createQuery(criteriaQuery);
		Product product = query.getSingleResult();

		System.out.println(product);

	}
	// select all name from product (name coloum name data)

	private static void getAllProductName(Session session) {
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

		Root<Product> root = criteriaQuery.from(Product.class);
		criteriaQuery.select(root.get("pname"));

		Query<String> query = session.createQuery(criteriaQuery);
		List<String> slist = query.getResultList();
		System.out.println(slist);
	}
	// Select all name & price from product

	private static void getMultipalColoumData(Session session) {

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

		Root<Product> root = criteriaQuery.from(Product.class);

		criteriaQuery.multiselect(root.get("pname"), (root.get("price")));

		Query<Object[]> query = session.createQuery(criteriaQuery);
		List<Object[]> olist = query.getResultList();

		for (Object[] obj : olist) {

			System.out.println("Product Name :-" + obj[0] + "    Product Price  :-" + obj[1]);
		}
 
	}
// update product Name & price / select product update set name = "board" where id=3;  
	private static void updateData(Session session) {
		session.beginTransaction();

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Product> update = builder.createCriteriaUpdate(Product.class);
		Root<Product> root = update.from(Product.class);
		update.set("pname", "board");
		update.set("price", 500);
		update.where(builder.equal(root.get("id"), 2));

		Query<Product> query = session.createQuery(update) ;
		query.executeUpdate();
		System.out.println("Update sucessfully.....");
	}
// delete id = 3.
	private static void deleteData(Session session) {
		session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaDelete<Product> delete = builder.createCriteriaDelete(Product.class);
		Root<Product> root = delete.from(Product.class);
		delete.where(builder.equal(root.get("id"), 4));
		
		Query<Product> query = session.createQuery(delete);
		query.executeUpdate();
		System.out.println("Delete Record Sucessfully....");

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		MainApp mp = new MainApp();

		while (true) {

			System.out.println("  ****************    Application Stared  **********************");
			System.out.println("1. Add Product Details.");
			System.out.println("2. Show All Product Data.");
			System.out.println("3. Get Single Product Using Id");
			System.out.println("4. Get All Product Name");
			System.out.println("5. Get Multipal Coloum Data");
			System.out.println("6. Update Data");
			System.out.println("7. Delete Data");
			System.out.println("================================================================");

			System.out.println("Enter Your Choice ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				mp.addProductDetails(session);
				break;

			case 2:
				mp.getAllData(session);
				break;

			case 3:
				mp.getProductDataUsingId(session);
				break;

			case 4:
				mp.getAllProductName(session);
				break;

			case 5:
				mp.getMultipalColoumData(session);
				break;

			case 6:
				mp.updateData(session);
				break;
			case 7:
				mp.deleteData(session);
				break;

			default:
				break;
			}
		}

		// addProductDetails(session);

	}

}
