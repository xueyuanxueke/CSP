package cn.edu.njust.bean;

public class Confirm {
	public String stuID;
	public String stuName;
	public String IDnumber;
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getIDnumber() {
		return IDnumber;
	}
	public void setIDnumber(String iDnumber) {
		IDnumber = iDnumber;
	}
	public Confirm(String stuID, String stuName, String iDnumber) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		IDnumber = iDnumber;
	}
	public Confirm() {
		
	}
	
}
