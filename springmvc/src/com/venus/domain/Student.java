package com.venus.domain;
import java.util.Date;

public class Student {

	private Integer Id;
	private String Name;
	private int ClassId;
	private String Sex;
	private Date Birthday;
	private String Nation;
	private int Status;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getClassId() {
		return ClassId;
	}
	public void setClassId(int classId) {
		ClassId = classId;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String Sex) {
		this.Sex = Sex;
	}
	public Date getBirthday() {
		return Birthday;
	}
	public void setBirthday(Date birthday) {
		Birthday = birthday;
	}
	public String getNation() {
		return Nation;
	}
	public void setNation(String nation) {
		Nation = nation;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", ClassId=" + ClassId + ", "
				+ "Sex="+Sex + ",Birthday="+Birthday+",Nation="+Nation+",Status"+Status+"]";
	
	}
}
