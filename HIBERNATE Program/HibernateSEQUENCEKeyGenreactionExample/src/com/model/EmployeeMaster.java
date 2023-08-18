package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class EmployeeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
	@SequenceGenerator(name = "mysequence", initialValue = 11, allocationSize = 5)

	private int pid;
	private String ename; 
	private String designtion;
	private String emailid;
	private long mobno;
	private double sallary;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getDesigntion() {
		return designtion;
	}

	public void setDesigntion(String designtion) {
		this.designtion = designtion;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getMobno() {
		return mobno;
	}

	public void setMobno(long mobno) {
		this.mobno = mobno;

	}

	public double getSallary() {
		return sallary;
	}

	public void setSallary(double sallary) {
		this.sallary = sallary;
	}

	@Override
	public String toString() {
		return "EmployeeMaster [pid=" + pid + ", ename=" + ename + ", designtion=" + designtion + ", emailid=" + emailid
				+ ", mobno=" + mobno + ", sallary=" + sallary + "]";
	}

}
