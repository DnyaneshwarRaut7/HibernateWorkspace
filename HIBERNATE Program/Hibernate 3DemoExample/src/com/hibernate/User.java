package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserDetail")
public class User {
	@Id
	private int uid;
	
	@Column(name="UserName")
	private String uname;
	
	@Column(name="UserAddress")
	private String uaddress;
	
	@Column(name="UserMobailNO")
	private long mob;	
    @Column(name="UserEmailId")
	private String email;
    
    @Column(name="UserSallary")
	private double sallary;

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

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSallary() {
		return sallary;
	}

	public void setSallary(double sallary) {
		this.sallary = sallary;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + ", mob=" + mob + ", email=" + email
				+ ", sallary=" + sallary + "]";
	}

}
