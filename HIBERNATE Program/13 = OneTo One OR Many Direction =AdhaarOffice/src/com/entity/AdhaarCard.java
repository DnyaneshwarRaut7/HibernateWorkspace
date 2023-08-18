package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdhaarCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aid;
	
	private String HolderName;
	
	private String Address;
	
	private String dateofbirth;
	
	private long mobileNO;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PanCard pancard;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getHolderName() {
		return HolderName;
	}

	public void setHolderName(String holderName) {
		HolderName = holderName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public long getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(long mobileNO) {
		this.mobileNO = mobileNO;
	}

	public PanCard getPancard() {
		return pancard;
	}

	public void setPancard(PanCard pancard) {
		this.pancard = pancard;
	}

	@Override
	public String toString() {
		return "AdhaarCard [aid=" + aid + ", HolderName=" + HolderName + ", Address=" + Address + ", dateofbirth="
				+ dateofbirth + ", mobileNO=" + mobileNO + ", pancard=" + pancard + "]";
	}
	

}
