package demo.springboot.domain;

public enum LogType {
	
	LOGIN_LOGOUT('0', "登入登出"), REMITT_TRANS('1', "转账汇款"), ACCONUT_MISS('2',
			"账户加挂"), ACCOUNT_LIST('3', "账户列表"), TRANS_DETAIL('4', "交易明细"), LOG_QUERY(
			'5', "日志查询");
		
		private int index;
		private String name;
		/**
		 * @param index
		 * @param name
		 */
		private LogType(int index, String name) {
			this.index = index;
			this.name = name;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getIndex() {
			return index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
}

		
		