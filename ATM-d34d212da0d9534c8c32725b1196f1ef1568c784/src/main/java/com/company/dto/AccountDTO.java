package com.company.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class AccountDTO {
    private int id;
    private String name;
    private String surname;
    private BigDecimal money;
    private final Set<BlikDTO> bliks = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Set<BlikDTO> getBliks() {
        return bliks;
    }
}