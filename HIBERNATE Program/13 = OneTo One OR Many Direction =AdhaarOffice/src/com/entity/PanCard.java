package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;

	private String PanName;

	private String panno;

	private long validDate;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPanName() {
		return PanName;
	}

	public void setPanName(String panName) {
		PanName = panName;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public long getValidDate() {
		return validDate;
	}

	public void setValidDate(long validDate) {
		this.validDate = validDate;
	}

	@Override
	public String toString() {
		return "PanCard [pid=" + pid + ", PanName=" + PanName + ", panno=" + panno + ", validDate=" + validDate + "]";
	}

}
