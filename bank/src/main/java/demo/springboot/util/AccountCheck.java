package demo.springboot.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class AccountCheck {
	@JSONField(name = "Header")
	private String Header;
	@JSONField(name = "Body")
	private String Body;

	    @JSONField(name = "MESSNO")
	    private String MESSNO;
	 
	    @JSONField(name = "RQ-TIME")
	private String RQTIME;
	
	    @JSONField(name = "PKG")
	    private String PKG;
	    
	    @JSONField(name = "customerID")
	    private Integer customerID;
	    
	    @JSONField(name = "password")
	    private Integer password;
	  
	    @JSONField(name = "accountNo")
	private String accountNo;
  	    
	    
		public String getMESSNO() {
			return MESSNO;
		}

		public void setMESSNO(String mESSNO) {
			MESSNO = mESSNO;
		}

	public String getRQTIME() {
			return RQTIME;
		}

	public void setRQTIME(String rQTIME) {
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

	public String getAccountNo() {
			return accountNo;
		}


	public void setAccountNo(String accountNo2) {
		this.accountNo = accountNo2;
		}

	public String getHeader() {
		return Header;
	}

	public void setHeader(String header) {
		Header = header;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public static String header() {
		AccountCheck header = new AccountCheck();
	        
		// header.getMESSNO();
		// header.getRQTIME();
	        header.setPKG("AccountPasswordCheck");
		return JSON.toJSONString(header);
	            
	        }
		
	public static String body() {
		AccountCheck body = new AccountCheck();
		// body.setAccountNo(13);

		/*
		 * body.getCustomerID(); body.getPassword(); body.getAccountNo();
		 */
		return JSON.toJSONString(body);
		// String s2 = JSON.toJSONString(body);
	}

	// 在s1前加上"Header"，在s2前加上“Body”再组成一个报文
	public static String shape() {
		AccountCheck body = new AccountCheck();
	        
		body.setBody(body());
		body.setHeader(header());
		System.out.println(JSON.toJSONString(body));
		return JSON.toJSONString(body);
		// String s2 = JSON.toJSONString(body);
	        }

	public static void main(String[] args) {
		shape();
	}
		

	 
}
