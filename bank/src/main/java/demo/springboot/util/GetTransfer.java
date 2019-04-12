package demo.springboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GetTransfer {
	 public static String shape(String acctForm,String accTo,String accToName,String amount,
             String currency,String password,String usgae,String comments) {
		 
			Map header= new HashMap();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			String dateName = df.format(calendar.getTime());
			header.put("MESSNO","851A7103E0244F1ABB211DA831FE72AC");
			header.put("RQ-TIME", dateName);
			header.put("PKG", "InnerTransfer");
			
			Map body = new HashMap();
		body.put("acctFrom", acctForm);
		body.put("acctTo", accTo);
		body.put("acctToName", accToName);
			body.put("amount",amount);
			body.put("currency",currency);
		body.put("password", VerifyPassword.getSHA256(password + "BUCT"));
			body.put("usgae",usgae);
			body.put("comments",comments);
			
			Map map=new HashMap();
			map.put("Header", header);
			map.put("Body", body);
			String jsonString =JSON.toJSONString(map);
			System.out.println(jsonString);
			return jsonString;
  }
}

