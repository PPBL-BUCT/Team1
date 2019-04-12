package demo.springboot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GetTransList {
	 public static String shape(String acctNo,String dateFrom,String dateTo,String pageSize,
             String pageNum) {
		    Map header= new HashMap();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			String dateName = df.format(calendar.getTime());
			header.put("MESSNO","F228B8123BA24F239299A35EB4960031");
			header.put("RQ-TIME", dateName);
			header.put("PKG", "TransList");
			
			Map body = new HashMap();
			body.put("acctNo",acctNo);
			body.put("dateFrom",dateFrom);
			body.put("dateTo",dateTo);
			body.put("pageSize",pageSize);
			body.put("pageNum",pageNum);
			
			Map map=new HashMap();
			map.put("Header", header);
			map.put("Body", body);
			String jsonString =JSON.toJSONString(map);
			System.out.println(jsonString);
			return jsonString;

  }
}
