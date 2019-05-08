package demo.springboot.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import demo.springboot.domain.TransformRecode;

public class ReceiveTransList {
	public static Map<String, Object> receiveTransList(String acctNo,
													   String dateFrom, String dateTo, String pageSize, String pageNum) {

		String res = HttpConnection.doPost(Core.getUrl_GetTransList(),
 GetTransList.shape(acctNo,
						dateFrom, dateTo, pageSize, pageNum));


	    System.out.println(res);
		JSONObject jsonObject= JSONObject.parseObject(res);
		Map<String, Object> map = new HashMap<>();
		// Map<String,Object>returnJson=(Map<String,Object>)jsonObject;
		
		// System.out.println(returnBody.get("TransList"));
		JSONArray items = jsonObject.getJSONObject("Body").getJSONArray(
				"TransList");
		JSONObject total = jsonObject.getJSONObject("Body").getJSONObject("total");
		Integer Total = Integer.valueOf(String.valueOf(total));
		JSONObject row = null;
		List<TransformRecode> list = new ArrayList<TransformRecode>();
		for (int i = 0; i < items.size(); i++) {
			row = items.getJSONObject(i);
			TransformRecode tmp = new TransformRecode();
			BigDecimal amount = (BigDecimal) row.get("amount");
			tmp.setAmount(amount+"");
			tmp.setAttachInfo((String) row.get("attachInfo"));
			tmp.setChannel((String) row.get("channel"));
			tmp.setCurrency((String) row.get("currency"));
			tmp.setPayeeAccountName((String) row.get("payeeAccountName"));
			tmp.setPayeeAccountNo((String) row.get("payeeAccountNo"));
			tmp.setPayerAccountNo((String) row.get("payerAccountNo"));
			tmp.setStatus((String) row.get("status"));
			tmp.setTransName((String) row.get("transName"));
			Long time = (Long) row.get("transTime");
			tmp.setTransTime(time + "");
			tmp.setUsage((String) row.get("usage"));
			list.add(tmp);
			System.out.println(row.get("attachInfo"));
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", Total);
		map.put("data", list);
		return map;
		
	}

	public static void main(String[] args) {
		receiveTransList("6218129087231776", "2018-04-11", "2019-05-01",
				"10", "1");

	}
}
