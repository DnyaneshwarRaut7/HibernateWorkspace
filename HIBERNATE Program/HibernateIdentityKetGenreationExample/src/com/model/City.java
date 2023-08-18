package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity

public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@Column(name = "CityName")
	private String CName;
	private String Distric;
	@Type(type = "yes_no")
	private boolean active;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getDistric() {
		return Distric;
	}

	public void setDistric(String distric) {
		Distric = distric;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "City [cid=" + cid + ", CName=" + CName + ", Distric=" + Distric + ", active=" + active + "]";
	}

}
