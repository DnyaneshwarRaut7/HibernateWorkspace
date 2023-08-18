package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TeamLeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String teamleaderName;

	private String Designation;

	@Column(name = "E_MailId", nullable  = false, unique = true)
	private String Maild;

	private long Mobailno;

	@ManyToMany(cascade = CascadeType.ALL)
	List<TeamMember> list = new ArrayList<TeamMember>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTeamleaderName() {
		return teamleaderName;
	}

	public void setTeamleaderName(String teamleaderName) {
		this.teamleaderName = teamleaderName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getMaild() {
		return Maild;
	}

	public void setMaild(String maild) {
		Maild = maild;
	}

	public long getMobailno() {
		return Mobailno;
	}

	public void setMobailno(long mobailno) {
		Mobailno = mobailno;
	}

	public List<TeamMember> getList() {
		return list;
	}

	public void setList(List<TeamMember> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TeamLeader [id=" + id + ", teamleaderName=" + teamleaderName + ", Designation=" + Designation
				+ ", Maild=" + Maild + ", Mobailno=" + Mobailno + ", list=" + list + "]";
	}

}
