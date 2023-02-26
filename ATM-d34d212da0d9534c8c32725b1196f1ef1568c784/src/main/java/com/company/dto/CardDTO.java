package com.company.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CardDTO {
    AccountDTO accountDto;
    private int cvv;
    private String number;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public AccountDTO getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDTO accountDto) {
        this.accountDto = accountDto;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
