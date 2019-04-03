package demo.springboot.util;

import java.util.Date;

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
    private String RQTIME;

    @JSONField(name = "PKG")
    private String PKG;
    
    @JSONField(name = "accountNo")
    private String accountNo;

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

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
    
	 public static String header() {
	    	AccountCheck header = new AccountCheck();
	        
	           Date date = new Date();
	           header.setMESSNO("BF4CE7ACC9AA402CAC6BE5CE6E4186CB");
	           header.setRQTIME(date.toString());
	           header.setPKG("GetBalance");
		       return JSON.toJSONString(header);
		       
	            	        }
	
	 public static String body(String accountNo) {
    	 AccountCheck body = new AccountCheck();
    	
    	 body.setAccountNo(accountNo);
	     
	     
	     return JSON.toJSONString(body);
	
    }
	 
	 public static String shape(String accountNo) {
			AccountCheck body = new AccountCheck();
		    body.setHeader(header());
			body.setBody(body(accountNo));
			System.out.println(JSON.toJSONString(body));
			return JSON.toJSONString(body);
			// String s2 = JSON.toJSONString(body);
		        }
       
}
    