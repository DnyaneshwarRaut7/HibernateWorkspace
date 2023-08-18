package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//Increased the primary key id
	private int uid;

	@Column(name = "user_name")
	private String uname;
	@Column(name = "User_Address")
	private String Uadress;
	@Column(name = "MobailNo")
	private long mobno;
	private String Emailid;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUadress() {
		return Uadress;
	}

	public void setUadress(String uadress) {
		Uadress = uadress;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", Uadress=" + Uadress + ", mobno=" + mobno + ", Emailid="
				+ Emailid + "]";
	}

}
