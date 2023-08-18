package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String eName;
	private String Address;
	private long mobailno;
	private String Emailid;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getMobailno() {
		return mobailno;
	}

	public void setMobailno(long mobailno) {
		this.mobailno = mobailno;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eName=" + eName + ", Address=" + Address + ", mobailno=" + mobailno
				+ ", Emailid=" + Emailid + "]";
	}

}
