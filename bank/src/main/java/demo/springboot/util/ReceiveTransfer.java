package demo.springboot.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class ReceiveTransfer {
	public static boolean receiveTransfer(String acctForm, String accTo,
			String accToName, String amount, String currency, String password,
			String usgae, String comments) {
	    String res = HttpConnection.doPost(Core.getUrl_GetTransfer(),
				GetTransfer.shape(acctForm, accTo, "马云", "10.00", "CNY",
						"Ieor9494854958dfdjkd9fd98f", "还款", "转账"));
		// GetTransfer.shape("6218129087231776", "6218129084383484", "马云",
		// "10.00", "CNY", "Ieor9494854958dfdjkd9fd98f", "还款", "转账"));


	    System.out.println(res);
		JSONObject jsonObject= JSONObject.parseObject(res);
		Map<String,Object>returnJson=(Map<String,Object>)jsonObject;
		
		Map<String,Object>returnBody=(Map<String,Object>)returnJson.get("Body");
		
		System.out.println(returnBody.get("INFO"));
		String flag = (String) returnBody.get("INFO");
		// return (String) returnBody.get("Transfer");
		return flag.equals("sucess");
	}

	public static void main(String[] args) {
		receiveTransfer("621812908774484", "6218129084383484", "马云", "10.00",
				"CNY", "Ieor9494854958dfdjkd9fd98f", "还款", "转账");
	}

	
}

