package demo.springboot.util;


public class Core {

	public final static String IP = "118.25.78.207"; // 流类型-流
	public final static String PORT = "8080"; // 流类型-流
    public final static String smsIP="118.25.78.207";
	public final static String NAME = "HostSimulator"; // 流类型-流
	public static final String GET_BALANCE = "GetAccountBalance.do";
    public static final String ACCOUNT_CHECK= "AccountPasswordValidate.do";
	public static final String GET_TREANSFER = "InnerTransfer.do";
	public static final String GET_TRANSLIST = "TransList.do";
	public static final String GET_MESSAGE = "SendSMS.do";
	public static final String GET_ACCOUNTMESSAGE = "AccountValidate.do";
	
	public static String getUrl_GetBalance() {
		
		String url_GetBalance = "http://" + IP + ":" + PORT + "/" + NAME + "/"
				+ GET_BALANCE;
		 
		return url_GetBalance;
	}
            	        
    
	public static String getUrl_AccountCheck() {
				
		String url_AccountCheck = "http://" + IP + ":" + PORT + "/" + NAME
				+ "/" + ACCOUNT_CHECK;
	 
		return url_AccountCheck;
	}

	public static void main(String[] args) {
		System.out.println(getUrl_AccountCheck());
		System.out.println(getUrl_GetBalance());
	}

	public static String getUrl_GetTransfer() {
		String url_GetBalance = "http://" + IP + ":" + PORT + "/" + NAME + "/"
				+ GET_TREANSFER;

		return url_GetBalance;
	}

	public static String getUrl_GetTransList() {
		String url_GetBalance = "http://" + IP + ":" + PORT + "/" + NAME + "/"
				+ GET_TRANSLIST;

		return url_GetBalance;
	}
	
	public static String getUrl_GetMessage() {
		String url_GetBalance = "http://" + smsIP + ":" + PORT + "/" + NAME + "/"
				+ GET_MESSAGE;

		return url_GetBalance;
	}


	public static String getUrl_AccountValidate() {
		String url_GetBalance = "http://" + smsIP + ":" + PORT + "/" + NAME + "/"
				+ GET_ACCOUNTMESSAGE;

		return url_GetBalance;
	}
}
