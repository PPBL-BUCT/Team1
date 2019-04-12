package demo.springboot.domain;

public class TransformRecode {
    private String amount; // 付款账户
    private String attachInfo; // 币种
    private String channel; // 收款账户
    private String currency; // 收款人名
    private String payeeAccountName;
    private String payeeAccountNo; // 金额
    private String payerAccountNo; // 用途
    private String status;
    private String transName;
    private String transTime;
    private String usage;
    private String dateTo;
    private String dateFrom;

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getAttachInfo() {
        return attachInfo;
    }

    public void setAttachInfo(String attachInfo) {
        this.attachInfo = attachInfo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPayeeAccountName() {
        return payeeAccountName;
    }

    public void setPayeeAccountName(String payeeAccountName) {
        this.payeeAccountName = payeeAccountName;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
