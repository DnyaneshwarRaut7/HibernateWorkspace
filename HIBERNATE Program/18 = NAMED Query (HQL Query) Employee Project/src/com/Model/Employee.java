package com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	//sellect name,address where uname=:un And pass=:ps  
	@NamedQuery(name = "findusingid", query = "from Employee where id=:id1") ,
    @NamedQuery(name = "findall",query ="from Employee"),
	@NamedQuery(name = "updatedata",query ="update Employee set name=:n,address=:a,uname=:u,pass=:p where id=:id1"),
	@NamedQuery(name = "deletesingleid",query ="delete from Employee where id=:id1"),
	//@NamedQuery(name = "nameaddress",query="from uname ")
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String address;

	private String uname;

	private String pass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getuNmae() {
		return uname;
	}

	public void setuNmae(String uNmae) {
		this.uname = uNmae;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", uname=" + uname + ", pass=" + pass
				+ "]";
	}

}
