package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name="Insertdata",query="insert into Employee (id,Name,Address,Uname,Pass)values(?,?,?,?,?)"),
	@NamedNativeQuery(name="getsingledata",query="select * from employee where id=?",resultClass = Employee.class),
	@NamedNativeQuery(name="likequery",query="select * from employee where Name like'%Suraj%'",resultClass = Employee.class),
	@NamedNativeQuery(name="alldata",query="select * from employee",resultClass = Employee.class),
	@NamedNativeQuery(name="updatesingledata",query="update employee set name =? where id=?"),
	//custom query only name & Address Show
	@NamedNativeQuery(name="customquery",query="select Name,Address from employee"),
	//custom query only name & Address Show using Id
	@NamedNativeQuery(name="customqueryusingid",query="select Name,Address from employee where id =?"),
	//count = all data fetch count
	@NamedNativeQuery(name="countquery",query="select count(*) from employee")
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String Name;

	private String Address;

	private String Uname;

	private String Pass;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Name=" + Name + ", Address=" + Address + ", Uname=" + Uname + ", Pass=" + Pass
				+ "]";
	}

}
