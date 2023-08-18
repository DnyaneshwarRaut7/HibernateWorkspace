package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class AdhaarInfoOffice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;

	private String centerName;

	private String centerAdders;
	
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "A_AP_Id")
	private List<AdhaarCard> adhar = new ArrayList<AdhaarCard>();

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterAdders() {
		return centerAdders;
	}

	public void setCenterAdders(String centerAdders) {
		this.centerAdders = centerAdders;
	}

	public List<AdhaarCard> getAdhar() {
		return adhar;
	}

	public void setAdhar(List<AdhaarCard> adhar) {
		this.adhar = adhar;
	}

	@Override
	public String toString() {
		return "AdhaarInfoOffice [cid=" + cid + ", centerName=" + centerName + ", centerAdders=" + centerAdders
				+ ", adhar=" + adhar + "]";
	}

}