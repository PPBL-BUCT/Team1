package com.venus.domain;
import java.util.Date;
public class Student {
	
		private Integer sId;
		private String sName;
		private String sClass;//Password
		private int sAge;//email
		private int sSex;//0男1女
		private String sBirthplace;
		private int sType;
	    private Date sBirthday;
		
	    public Integer getsId() {
			return sId;
		}

		public void setsId(Integer sId) {
			this.sId = sId;
		}

		public String getsName() {
			return sName;
		}

		public void setsName(String sName) {
			this.sName = sName;
		}

		public String getsClass() {
			return sClass;
		}

		public void setsClass(String sClass) {
			this.sClass = sClass;
		}

		public int getsAge() {
			return sAge;
		}

		public void setsAge(int sAge) {
			this.sAge = sAge;
		}


		public int getsSex() {
			return sSex;
		}
		
		public void setsSex(int sSex) {
			this.sSex = sSex;
		}
		
		public String getsBirthplace() {
			return sBirthplace;
		}
		
		public void setsSex(String sBirthplace) {
			this.sBirthplace = sBirthplace;
		}
		 
		public void setsType(int sType) {
			this.sType = sType;
		}


		public int getsType() {
			return sType;
		}
		
		public void setsBirthday(Date sBirthday) {
			this.sBirthday = sBirthday;
		}

		public Date getsBirthday() {
			return sBirthday;
		}
		
		@Override
		public String toString() {
			return "Student [sId=" + sId + ", sName=" + sName + ", sClass=" + sClass + ", sAge="
					+ sAge + ",sSex="+sSex+",sBirthplace="+sBirthplace+",userType="+sType+"]";
		}
	}

