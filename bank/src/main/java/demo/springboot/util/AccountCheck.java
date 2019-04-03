package demo.springboot.util;

import java.security.Timestamp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class GetBalance {
	@JSONField(name = "Header")
	private String Header;
	@JSONField(name = "Body")
	private String Body;

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
	        GetBalance header = new GetBalance();
	        
		// header.getMESSNO();
		// header.getRQTIME();
	        header.setPKG("AccountPasswordCheck");
		return JSON.toJSONString(header);
	            
	        }
		
	public static String body() {
		GetBalance body = new GetBalance();
		body.setAccountNo(13);
		/*
		 * body.getCustomerID(); body.getPassword(); body.getAccountNo();
		 */
		return JSON.toJSONString(body);
		// String s2 = JSON.toJSONString(body);
	}

	// 在s1前加上"Header"，在s2前加上“Body”再组成一个报文
	public static String shape() {
	        GetBalance body = new GetBalance();
	        
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
