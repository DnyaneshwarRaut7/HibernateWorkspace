package com.amazone.addcart.Service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.amazone.addcart.Util.HibernateUtil;
import com.amazone.addcart.entity.Cart;
import com.amazone.addcart.entity.Items;

public class Serviceimpl implements ServiceI {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCartAndWithItemData() {
		Session session = sf.openSession();

		Cart cart = new Cart();

		System.out.println("Enter Cart Owener Name:");
		cart.setCname(sc.next());

		System.out.println("Enter Cart Owener Mobileno");
		cart.setCmobileno(sc.nextLong());

		System.out.println("Enter Cart Owener Mail-Id");
		cart.setEmail(sc.next());

		System.out.println(" How Many Items To Be Insert In To Cart");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			Items items = new Items();

			System.out.println("Enter Item Name");
			items.setIname(sc.next());

			System.out.println("Enter Item Price");
			items.setPrice(sc.nextLong());

			System.out.println("Enter Item Quantity");
			items.setQuantity(sc.nextInt());

			// Method list madhun Data
			cart.getItems().add(items);

			session.save(cart);
			session.beginTransaction().commit();
			System.out.println("--Data Inserted Into CartData ");

		}
	}

	@Override
	public void showAllCatData() {
		Session session = sf.openSession();
		Query<Cart> query = session.createQuery("From Cart");
		List<Cart> clist = query.getResultList();

		// System.out.println(clist);

		// forch each loop

		for (Cart c : clist) {
			System.out.println("****************** CART DATA *****************");
			System.out.println("Cart Id:- " + c.getCid());
			System.out.println("Cart Name:- " + c.getCname());
			System.out.println("Cart Mobile Number:- " + c.getCmobileno());
			System.out.println("Cart Email Id:-" + c.getEmail());

			// for each loop
			for (Items i : c.getItems()) {

				System.out.println(" ****************** ITEMS IN CART DATA ********************");

				System.out.println("Item Id :- " + i.getId());
				System.out.println("Items Names :- " + i.getIname());
				System.out.println("Items Price :- " + i.getPrice());
				System.out.println("Items Quantity :- " + i.getQuantity());

				// datatype vaiable casting getquantity * getprice
				// getQuantity & getPrice multiplication
				// store in totalPrice
				float totalprice = (float) (i.getQuantity() * i.getPrice());

				i.setTotalamount(totalprice);
				System.out.println("Item Total Amount:-" + i.getTotalamount());

			}
			System.out.println("========================================================");

		}

	}

	@Override
	public void getSingleCartData() {
		Session session = sf.openSession();
		System.out.println("Enter your Cart Id ");
		int id = sc.nextInt();
		Cart cart = session.get(Cart.class, id);
		if (cart != null) {

			// System.out.println(cart);

			System.out.println("****************** CART DATA *****************");

			System.out.println("Cart Id:-" + cart.getCid());
			System.out.println("Cart Name :-" + cart.getCname());
			System.out.println("Cart Mobile Number:- " + cart.getCmobileno());
			System.out.println("Cart Email Id:-" + cart.getEmail());

			// for each loop
			for (Items i : cart.getItems()) {

				System.out.println(" ******************* ITEMS IN CART DATA ***********************");
				System.out.println("Item Id :- " + i.getId());
				System.out.println("Items Names :- " + i.getIname());
				System.out.println("Items Price :- " + i.getPrice());
				System.out.println("Items Quantity :- " + i.getQuantity());

				// datatype vaiable casting getquantity * getprice
				// getQuantity & getPrice multiplication
				// store in totalPrice
				float totalprice = (float) (i.getQuantity() * i.getPrice());

				i.setTotalamount(totalprice);
				System.out.println("Item Total Amount:-" + i.getTotalamount());

				System.out.println("========================================================");

			}

		} else {
			System.out.println("Cart Id Is not Present");
		}
	}

	@Override
	public void updateCartData() {
		Session session = sf.openSession();
		System.out.println("Enter Your Cart Id ");
		int id = sc.nextInt();
		Cart cart = session.get(Cart.class, id);
		boolean flag = true;

		while (flag) {
			System.out.println("**************************************");
			System.out.println("1. Enter Your Update Cart Name");
			System.out.println("2. Enter your Update Cart Mobail Number");
			System.out.println("3. Enter your Update Cart Email Number");
			System.out.println("4. Exit");
			System.out.println("********************************************");

			System.out.println(" Enter your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:

				System.out.println("Enter Your Update Cart Name");
				cart.setCname(sc.next());
				session.update(cart);
				session.beginTransaction().commit();;
				break;

			case 2:
				System.out.println("Enter your Update Cart Mobile Number");
				cart.setCmobileno(sc.nextLong());
				session.update(cart);
				session.beginTransaction().commit();
				break;

			case 3:
				System.out.println("Enter your Update Cart Email Number");
				cart.setEmail(sc.next());
				session.update(cart);
				session.beginTransaction().commit();
				break;

			case 4:
				flag = false;
				break;
			default:

				System.out.println("Wrong Chice ");
				sc.close();

			}

			System.out.println("updated Cart Data Sucessfully");
		}

	}

	@Override
	public void UpdataPerticularItemsUsingCratId() {
		Session session = sf.openSession();
		System.out.println("Enter Your Cart Id ");
		int id = sc.nextInt();
		Cart cart = session.get(Cart.class, id);

		List<Items> list = cart.getItems();

		for (Items items : list) {
			System.out.println(" ******************* ITEMS IN CART DATA ***********************");
			System.out.println("Item Id :- " + items.getId());
			System.out.println("Items Names :- " + items.getIname());
			System.out.println("Items Price :- " + items.getPrice());
			System.out.println("Items Quantity :- " + items.getQuantity());
		}

		System.out.println("Enter item id u want update");
		int idi = sc.nextInt();

		for (Items items : list) {

			if (idi == items.getId()) {

				System.out.println("Enter your updare Item Name");
				items.setIname(sc.next());

				System.out.println("Enter your Update Item Price");
				items.setPrice(sc.nextLong());

				System.out.println("Enter your Update Item Quantity ");
				items.setQuantity(sc.nextInt());

				System.out.println(cart.getItems());

				session.update(cart);
				session.beginTransaction().commit();

				System.out.println("Updated Item  Sucessfully");

			} else {
				System.out.println("Cart id is not presemt");

			}

		}

	}

	@Override
	public void deletePertiularItemsDataFromCartusingCartId() {
//		Session session = sf.openSession();
//
//		System.out.println("Enter your Cart Id");
//		int id = sc.nextInt();
//		Cart cart = session.get(Cart.class, id);
//		if (cart != null) {
//			List<Items> list = cart.getItems();
//
//			for (Items items : list) {
//				System.out.println(" ******************* ITEMS IN CART DATA ***********************");
//				System.out.println("Item Id :- " + items.getId());
//				System.out.println("Items Names :- " + items.getIname());
//				System.out.println("Items Price :- " + items.getPrice());
//				System.out.println("Items Quantity :- " + items.getQuantity());
//			}
//			System.out.println("Enter item id u want Delete");
//			int idi = sc.nextInt();
//
//			for (Items items : list) {
//
//				if (idi == items.getId()) {
//
//					System.out.println(cart.getItems());
//
//					session.remove(items);
//					session.update(cart);
//					session.delete(items);
//					session.beginTransaction().commit();
//				} else {
//
//					System.out.println("Cart Id is not Present");
//				}
//			}
//		}

		Session session = sf.openSession();
		System.out.println("Enter your Cart Id");
		int id = sc.nextInt();
		Cart cart = session.get(Cart.class, id);
		if (cart != null) {
			List<Items> items = cart.getItems();
			System.out.println(items);
			System.out.println("Enter Items Id");
			int id1 = sc.nextInt();
			boolean flag = false;
			Items item = null;

			for (Items i : items) {

				if (id1 == i.getId()) {
					item = i;
					flag = true;
					break;
				}
			}
			if (flag) {
				items.remove(item);
				session.update(cart);
				session.delete(item);
				session.beginTransaction().commit();
				System.out.println("Item Delete Sucessfully");
			} else {
				System.out.println("Cart Id Is Not Present..");
			}

		}
	}

	@Override
	public void deleteCartData() {

		Session session = sf.openSession();
		System.out.println("Enter Your Cart It");
		int id = sc.nextInt();
		Cart cart = session.get(Cart.class, id);
		if (cart != null) {

			session.delete(cart);
			session.beginTransaction().commit();
			System.out.println("Deleted Data Sucessfully");

		} else {

			System.out.println("Cart Id is Not Present");
		}

	}

}
