package demo.springboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GetBalance {

	
//	@JSONField(name = "Header")
//	private String Header;
//	@JSONField(name = "Body")
//	private String Body;
//
//	@JSONField(name = "MESSNO")
//    private String MESSNO;
// 
//    @JSONField(name = "RQ-TIME")
//    private String RQTIME;
//
//    @JSONField(name = "PKG")
//    private String PKG;
//    
//    @JSONField(name = "accountNo")
//    private String accountNo;
//
//	public String getHeader() {
//		return Header;
//	}
//
//	public void setHeader(String header) {
//		Header = header;
//	}
//
//	public String getBody() {
//		return Body;
//	}
//
//	public void setBody(String body) {
//		Body = body;
//	}
//
//	public String getMESSNO() {
//		return MESSNO;
//	}
//
//	public void setMESSNO(String mESSNO) {
//		MESSNO = mESSNO;
//	}
//
//	public String getRQTIME() {
//		return RQTIME;
//	}
//
//	public void setRQTIME(String rQTIME) {
//		RQTIME = rQTIME;
//	}
//
//	public String getPKG() {
//		return PKG;
//	}
//
//	public void setPKG(String pKG) {
//		PKG = pKG;
//	}
//
//	public String getAccountNo() {
//		return accountNo;
//	}
//
//	public void setAccountNo(String accountNo) {
//		this.accountNo = accountNo;
//	}
//    
//	 public static String header() {
//		GetBalance header = new GetBalance();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Calendar calendar = Calendar.getInstance();
//		String dateName = df.format(calendar.getTime());
//	           header.setMESSNO("BF4CE7ACC9AA402CAC6BE5CE6E4186CB");
//		header.setRQTIME(dateName);
//	           header.setPKG("GetBalance");
//		return JSON.toJSONString(header);//.replace("\\", "");
//			
//		       
//	            	        }
//	
//	public static String body(String accountNo) {
//		GetBalance body = new GetBalance();
//    	
//    	 body.setAccountNo(accountNo);
//	     
//	     
//		return JSON.toJSONString(body);//.replace("\\", "");
//	
//    }
//	 
//	public static String shape(String accountNo) {
//		
//		GetBalance body = new GetBalance();
//		body.setHeader(header());
//		body.setBody(body(accountNo));
////		body.setHeader(header());
//		System.out.println(JSON.toJSONString(body));
//		return JSON.toJSONString(body);//.replace("\\", "");
//	}
//     
	  public static String shape(String accountNo) {
		  Map header= new HashMap();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String dateName = df.format(calendar.getTime());
		  header.put("MESSNO"," BF4CE7ACC9AA402CAC6BE5CE6E4186CB");
		header.put("RQ-TIME", dateName);
		  header.put("PKG", "GetBalance");
		  
		  Map body = new HashMap();
		  body.put("accountNo",accountNo);
		  
		  Map map=new HashMap();
		  map.put("Header", header);
		  map.put("Body", body);
		  String jsonString =JSON.toJSONString(map);
		System.out.println(jsonString);
		  return jsonString;
	  }
	
}
    