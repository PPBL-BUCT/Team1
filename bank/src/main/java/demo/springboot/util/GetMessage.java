package demo.springboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GetMessage {
	 public static String shape(String code) {
		  Map header= new HashMap();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		String dateName = df.format(calendar.getTime());
		  header.put("MESSNO"," 5F9829F7644D47F3B6BCEAC11BC6CF4C");
		  header.put("RQ-TIME", dateName);
		  header.put("PKG", "SendSMS");
		  
		  Map body = new HashMap();
		  body.put("customerID","68923574986311018747");
		  body.put("code",code);
		  
		  Map map=new HashMap();
		  map.put("Header", header);
		  map.put("Body", body);
		  String jsonString =JSON.toJSONString(map);
		System.out.println(jsonString);
		  return jsonString;
	  }
}
