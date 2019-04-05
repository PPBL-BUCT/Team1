package demo.springboot.domain;

import java.io.Serializable;

/**
 * account
 * @author 
 */
public class Account implements Serializable {
	private String account;

	private String password;

	private String userId;

    private Integer status;

    private Integer currency;

    private Integer type;
    
	private double balance;
    
	private double availa_balance;

    private static final long serialVersionUID = 1L;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAvaila_balance() {
		return availa_balance;
	}

	public void setAvaila_balance(double availa_balance) {
		this.availa_balance = availa_balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}