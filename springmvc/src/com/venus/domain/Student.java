package com.venus.domain;
import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private int classId;
	private String sex;
	private Date birthday;
	private String nation;
	private int status;
	
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String Sex) {
		this.sex = Sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "Student [Id=" + Id + ", Name=" + Name + ", ClassId=" + ClassId + ", "
//				+ "Sex="+Sex + ",Birthday="+Birthday+",Nation="+Nation+",Status"+Status+"]";
//	
//	}
}
