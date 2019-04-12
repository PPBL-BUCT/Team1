package demo.springboot.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import demo.springboot.domain.TransformRecode;

public class ReceiveTransList {
	public static List<TransformRecode> receiveTransList(String acctNo,
			String dateFrom, String dateTo, String pageSize, String pageNum) {
	    String res = HttpConnection.doPost(Core.getUrl_GetTransList(),
 GetTransList.shape(acctNo,
						dateFrom, dateTo, pageSize, pageNum));


	    System.out.println(res);
		JSONObject jsonObject= JSONObject.parseObject(res);
		// Map<String,Object>returnJson=(Map<String,Object>)jsonObject;
		
		// System.out.println(returnBody.get("TransList"));
		JSONArray items = jsonObject.getJSONObject("Body").getJSONArray(
				"TransList");
		JSONObject row = null;
		List<TransformRecode> list = new ArrayList<TransformRecode>();
		for (int i = 0; i < items.size(); i++) {
			row = items.getJSONObject(i);
			TransformRecode tmp = new TransformRecode();
			tmp.set;
			System.out.println(row.get("attachInfo"));
		}
		return list;
		
	}

	public static void main(String[] args) {
		receiveTransList("6218129087231776", "2018-04-11", "2019-05-01",
				"10", "1");

	}
}
