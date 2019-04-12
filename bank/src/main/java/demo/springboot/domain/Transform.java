package demo.springboot.domain;

public class Transform {
	private String payaccount; // 付款账户
	private String currency; // 币种
	private String recieveaccount; // 收款账户

	private String payeename; // 收款人名
	private String transferway;
	private Integer amount; // 金额
	private String purpose; // 用途
	private String transferpassword;
	private String dynamicpassword;

	public String getPayaccount() {
		return payaccount;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getRecieveaccount() {
		return recieveaccount;
	}

	public void setRecieveaccount(String recieveaccount) {
		this.recieveaccount = recieveaccount;
	}

	public String getPayeename() {
		return payeename;
	}

	public void setPayeename(String payeename) {
		this.payeename = payeename;
	}

	public String getTransferway() {
		return transferway;
	}

	public void setTransferway(String transferway) {
		this.transferway = transferway;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTransferpassword() {
		return transferpassword;
	}

	public void setTransferpassword(String transferpassword) {
		this.transferpassword = transferpassword;
	}

	public String getDynamicpassword() {
		return dynamicpassword;
	}

	public void setDynamicpassword(String dynamicpassword) {
		this.dynamicpassword = dynamicpassword;
	}
}
