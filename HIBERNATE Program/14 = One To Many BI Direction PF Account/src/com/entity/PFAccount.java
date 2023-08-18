package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class PFAccount {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer pid;

private String PFname;

private String PFnumber;
@ManyToOne(cascade = CascadeType.ALL)
private EPFAccount epfaccount;
public Integer getPid() {
	return pid;
}
public void setPid(Integer pid) {
	this.pid = pid;
}
public String getPFname() {
	return PFname;
}
public void setPFname(String pFname) {
	PFname = pFname;
}
public String getPFnumber() {
	return PFnumber;
}
public void setPFnumber(String pFnumber) {
	PFnumber = pFnumber;
}
public EPFAccount getEpfaccount() {
	return epfaccount;
}
public void setEpfaccount(EPFAccount epfaccount) {
	this.epfaccount = epfaccount;
}
@Override
public String toString() {
	return "PFAccount [pid=" + pid + ", PFname=" + PFname + ", PFnumber=" + PFnumber + ", epfaccount=" + epfaccount
			+ "]";
}



}
