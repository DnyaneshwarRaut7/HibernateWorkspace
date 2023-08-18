package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	private String mname;
	private String mcompany;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "mobile")
	private Battery battery;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMcompany() {
		return mcompany;
	}

	public void setMcompany(String mcompany) {
		this.mcompany = mcompany;
	}

	public Battery getBattery() {
		return battery;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Mobile [mid=" + mid + ", mname=" + mname + ", mcompany=" + mcompany + " ,Battery id= "
				+ battery.getBid() + " ,Battery Name= " + battery.getBname() + ", battery Mh Power= " + battery.getMh()
				+ "]";
	}

}
