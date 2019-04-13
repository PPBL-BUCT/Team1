package demo.springboot.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class GetAccountValidate {
	 public static String shape(String password,String accNumber,String smsCode,String phoneNo) {
		 
		 
		  Map header= new HashMap();
		  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Calendar calendar = Calendar.getInstance();
	      String dateName = df.format(calendar.getTime());
		  header.put("MESSNO","73E5D41A84234958A1C997A0B5A6C30D");
		  header.put("RQ-TIME", dateName);
		  header.put("RS-CODE", "000708");
		  header.put("PKG", "AccountValidate");
		  
		  Map body = new HashMap();
		  body.put("password", getSHA256(password + "BUCT"));
		  body.put("accountNo",accNumber);
		  body.put("smsCode",smsCode);
		  body.put("IDType","00");
		  body.put("IDNO","132629199301102312");
		  body.put("phoneNo",phoneNo);
		  
		  
		  Map map=new HashMap();
		  map.put("Header", header);
		  map.put("Body", body);
		  String jsonString =JSON.toJSONString(map);
		System.out.println(jsonString);
		  return jsonString;
	  }
	 
	public static String getSHA256(String str) {
		MessageDigest messageDigest;
		String encodestr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodestr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodestr;
	}

	/**
	 * 将byte转为16进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1得到一位的进行补0操作
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();
	}
	 
}
