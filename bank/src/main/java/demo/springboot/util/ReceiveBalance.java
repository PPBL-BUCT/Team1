package demo.springboot.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ReceiveBalance{
	
	public double getBalance() {
    String res = HttpConnection.doPost(Core.getUrl_GetBalance(),
	GetBalance.shape("6218129087231776"));


    System.out.println(res);
	JSONObject jsonObject= JSONObject.parseObject(res);
	Map<String,Object>returnJson=(Map<String,Object>)jsonObject;
	
	Map<String,Object>returnBody=(Map<String,Object>)returnJson.get("Body");
	
	System.out.println(returnBody.get("Balance"));
	return (double) returnBody.get("Balance");
	}

	
	
}
	


