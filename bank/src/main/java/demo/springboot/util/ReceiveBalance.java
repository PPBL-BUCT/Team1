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

		return true;
	}
}
