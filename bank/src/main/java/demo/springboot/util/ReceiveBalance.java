package demo.springboot.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ReceiveBalance {
	public static String receiveBalance(String accNumber) {
	    String res = HttpConnection.doPost(Core.getUrl_GetBalance(),
				GetBalance.shape(accNumber));

		JSONObject jsonObject= JSONObject.parseObject(res);
		Map<String,Object>returnJson=(Map<String,Object>)jsonObject;
		
		Map<String,Object>returnBody=(Map<String,Object>)returnJson.get("Body");
		
		return (String) returnBody.get("BALANCE");
		}

	public static boolean checkAccount(String accNumber, String password,
			String user_id) {
		String res = HttpConnection.doPost(Core.getUrl_AccountCheck(),
				VerifyPassword.shape(user_id, accNumber, password));

		System.out.println("res json=================" + res);

		Map map = JSONObject.parseObject(res, Map.class);
		System.out.println("res map=================" + map);

		Map header = (Map) JSONObject.parseObject(
				((JSONObject) map.get("Header")).toJSONString(), Map.class);
		Map body = (Map) JSONObject.parseObject(
				((JSONObject) map.get("Body")).toJSONString(), Map.class);

		String flag = (String) body.get("INFO");
		System.out.println("res info=================" + flag);

		return flag.equals("Password Correct");
	}
}
