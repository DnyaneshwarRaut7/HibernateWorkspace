package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//Incensed the primary key value
	private int sid;
	
	private String sname;
	
	private String Saddress;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return Saddress;
	}

	public void setSaddress(String saddress) {
		Saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", Saddress=" + Saddress + "]";
	}
	
	

}
