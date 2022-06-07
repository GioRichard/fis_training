package bank.poi.tryit;

import java.sql.Date;

public class Transaction {
    private String type;
    private String Account;
    private double amount;
    private  String message;
    private Date dateTime;

    public Transaction() {
    }

    public Transaction(String type, String account, Double amount,
                       String message, Date dateTime) {
        this.type = type;
        Account = account;
        this.amount = amount;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", Account='" + Account + '\'' +
                ", amount=" + amount +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
