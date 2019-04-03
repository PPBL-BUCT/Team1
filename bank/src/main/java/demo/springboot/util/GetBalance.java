package demo.springboot.util;

import java.security.Timestamp;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class GetBalance {

	
	    @JSONField(name = "MESSNO")
	    private String MESSNO;
	 
	    @JSONField(name = "RQ-TIME")
	    private Timestamp RQTIME;
	
	    @JSONField(name = "PKG")
	    private String PKG;
	    
	    @JSONField(name = "customerID")
	    private Integer customerID;
	    
	    @JSONField(name = "password")
	    private Integer password;
	  
	    @JSONField(name = "accountNo")
	    private Integer accountNo;
  	    
	    
		public String getMESSNO() {
			return MESSNO;
		}

		public void setMESSNO(String mESSNO) {
			MESSNO = mESSNO;
		}

		public Timestamp getRQTIME() {
			return RQTIME;
		}

		public void setRQTIME(Timestamp rQTIME) {
			RQTIME = rQTIME;
		}

		public String getPKG() {
			return PKG;
		}

		public void setPKG(String pKG) {
			PKG = pKG;
		}

		public Integer getCustomerID() {
			return customerID;
		}

		public void setCustomerID(Integer customerID) {
			this.customerID = customerID;
		}

		public Integer getPassword() {
			return password;
		}

		public void setPassword(Integer password) {
			this.password = password;
		}

		public Integer getAccountNo() {
			return accountNo;
		}


		public void setAccountNo(Integer accountNo) {
			this.accountNo = accountNo;
		}



		public void header() {
	        GetBalance header = new GetBalance();
	        
	        header.getMESSNO();
	        header.getRQTIME();
	        header.setPKG("AccountPasswordCheck");
	        	 
	        String s1 = JSON.toJSONString(header);
	            
	        }
		
		public void body() {
	        GetBalance body = new GetBalance();
	        
	        body.getCustomerID();
	        body.getPassword();
	        body.getAccountNo();
	        	 
	        String s2 = JSON.toJSONString(body);
	        }

		//在s1前加上"Header"，在s2前加上“Body”再组成一个报文

		

	 
}
