package demo.springboot.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ReceiveAccountValidate {
	public static  boolean  receiveAccountValidate(String password,String accNumber,String smsCode,String IDType,String IDNO,String phoneNo) {
	    String res = HttpConnection.doPost(Core.getUrl_AccountValidate(),
				GetAccountValidate.shape(password,accNumber,smsCode,IDType,IDNO,phoneNo));

		Map map = JSONObject.parseObject(res, Map.class);
	
		Map header = (Map) JSONObject.parseObject(
				((JSONObject) map.get("Header")).toJSONString(), Map.class);
		Map body = (Map) JSONObject.parseObject(
				((JSONObject) map.get("Body")).toJSONString(), Map.class);

		String flag = (String) body.get("INFO");
		System.out.println("res info=================" + flag);

		return flag.equals("send error");//0为正确1为错误
       }
}
