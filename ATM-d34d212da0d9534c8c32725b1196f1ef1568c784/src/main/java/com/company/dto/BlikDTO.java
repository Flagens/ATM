package com.company.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BlikDTO {
    private String code;
    int accountId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expirationDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationDate;
    private final List<BlikTransactionDTO> transactions = new ArrayList<>();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<BlikTransactionDTO> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "BlikDTO{" +
                "\n\tcode='" + code + '\'' +
                "\n\taccountId=" + accountId +
                "\n\texpirationDate=" + expirationDate +
                "\n\tcreationDate=" + creationDate +
                "\n\ttransactions=[" + transactions.stream().map(Object::toString).collect(Collectors.joining("\n\t\t")) +
                "\n\t]" +
                "\n}";
    }
}