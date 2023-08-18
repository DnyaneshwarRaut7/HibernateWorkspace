package com.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class UserDataRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String Address;

	@Lob
	private byte[] fdata;

	private String fname;

	private String uoloadeddate;

	private LocalDateTime modifydate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public byte[] getFdata() {
		return fdata;
	}

	public void setFdata(byte[] fdata) {
		this.fdata = fdata;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUoloadeddate() {
		return uoloadeddate;
	}

	public void setUoloadeddate(String uoloadeddate) {
		this.uoloadeddate = uoloadeddate;

	}

	public LocalDateTime getModifydate() {
		return modifydate;
	}

	public void setModifydate(LocalDateTime modifydate) {
		this.modifydate = modifydate;
	}

	@Override
	public String toString() {
		return "UserDataRecord [id=" + id + ", name=" + name + ", Address=" + Address + ", fdata="
				+ Arrays.toString(fdata) + ", fname=" + fname + ", uoloadeddate=" + uoloadeddate + ", modifydate="
				+ modifydate + "]";
	}

	// private uploadeddate

}
