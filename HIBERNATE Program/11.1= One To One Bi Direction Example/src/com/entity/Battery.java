package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Battery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;
	private String bname;
	private String mh;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="m_b_id")
	private Mobile mobile;

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getMh() {
		return mh;
	}

	public void setMh(String mh) {
		this.mh = mh;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Battery [bid=" + bid + ", bname=" + bname + ", mh=" + mh + ", mobile=" + mobile + "]";
	}

}
