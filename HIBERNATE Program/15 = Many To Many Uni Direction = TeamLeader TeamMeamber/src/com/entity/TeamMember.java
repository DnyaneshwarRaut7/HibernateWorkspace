package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeamMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mid;
	
	private String TeamMemberName;
	
	private String ProjectName;
	
	private String EMailid;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTeamMemberName() {
		return TeamMemberName;
	}

	public void setTeamMemberName(String teamMemberName) {
		TeamMemberName = teamMemberName;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getEMailid() {
		return EMailid;
	}

	public void setEMailid(String eMailid) {
		EMailid = eMailid;
	}

	@Override
	public String toString() {
		return "TeamMember [mid=" + mid + ", TeamMemberName=" + TeamMemberName + ", ProjectName=" + ProjectName
				+ ", EMailid=" + EMailid + "]";
	}
	
	

}
