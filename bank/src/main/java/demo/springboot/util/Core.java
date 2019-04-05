package demo.springboot.util;


public class Core {

	public final static String IP = "118.25.143.204"; // 流类型-流
	public final static String PORT = "8080"; // 流类型-流

	public final static String NAME = "HostSimulator"; // 流类型-流
	public static final String GET_BALANCE = "GetAccountBalance.do";
    public static final String ACCOUNT_CHECK= "AccountPasswordValidate.do";
	
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
}
