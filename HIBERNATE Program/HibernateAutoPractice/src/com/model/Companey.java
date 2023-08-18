package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Companey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String cname;
	private String Caddress;
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
	public String getCaddress() {
		return Caddress;
	}
	public void setCaddress(String caddress) {
		Caddress = caddress;
	}
	@Override
	public String toString() {
		return "Companey [cid=" + cid + ", cname=" + cname + ", Caddress=" + Caddress + "]";
	}
	
	

}
