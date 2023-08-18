package com.amazone.addcart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	private String cname;

	private long cmobileno;

	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_I_ID")
	private List<Items> items = new ArrayList<Items>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public long getCmobileno() {
		return cmobileno;
	}

	public void setCmobileno(long cmobileno) {
		this.cmobileno = cmobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;

	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", cname=" + cname + ", cmobileno=" + cmobileno + ", email=" + email + ", items="
				+ items + "]";
	}

}
