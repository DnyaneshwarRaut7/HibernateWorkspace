package com.amazone.addcart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String iname;

	private long price;

	private int quantity;
	@Transient
	private float totalamount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", iname=" + iname + ", price=" + price + ", quantity=" + quantity + ", totalamount="
				+ totalamount + "]";
	}

}
