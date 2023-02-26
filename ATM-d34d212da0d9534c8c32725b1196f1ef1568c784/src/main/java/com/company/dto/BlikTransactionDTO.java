package com.company.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class BlikTransactionDTO {
    private int id;
    private String blikCode;
    private boolean verified;
    private boolean executed;
    private BigDecimal amount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public String getBlikCode() {
        return blikCode;
    }

    public void setBlikCode(String blikCode) {
        this.blikCode = blikCode;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BlikTransactionDTO{" +
                "\nid=" + id +
                "\nblikCode='" + blikCode + '\'' +
                "\nverified=" + verified +
                "\nexecuted=" + executed +
                "\namount=" + amount +
                "\ndate=" + date +
                "\n}";
    }
}
