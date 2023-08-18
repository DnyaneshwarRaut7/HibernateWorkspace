package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EPFAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	private String ename;
	
	private String userName;
	
	private String passward;
	@OneToMany(cascade = CascadeType.ALL)
	private List<PFAccount> plist = new ArrayList<PFAccount>();
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public List<PFAccount> getPlist() {
		return plist;
	}
	public void setPlist(List<PFAccount> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "EPFAccount [eid=" + eid + ", ename=" + ename + ", userName=" + userName + ", passward=" + passward
				+ ", plist=" + plist + "]";
	}
	
	
	

}
