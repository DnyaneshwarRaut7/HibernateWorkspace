package Com.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;

	private String name;

	private String address;

	private String bachname;

	private String joindate;

	private double fees;

	@Type(type = "yes_no")
	private boolean flag;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
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

	public String getBachname() {
		return bachname;
	}

	public void setBachname(String bachname) {
		this.bachname = bachname;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", address=" + address + ", bachname=" + bachname
				+ ", joindate=" + joindate + ", fees=" + fees + ", flag=" + flag + "]";
	}

}
