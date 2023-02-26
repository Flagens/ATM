package com.company;

public class Card {
    private String number;
    private String pin;
    private Float money;
    private Float dailyLimit;
    private String blikCode;

    public Card(String number, String pin, Float money, Float dailyLimit, String blikCode) {
        this.number = number;
        this.pin = pin;
        this.money = money;
        this.dailyLimit = dailyLimit;
        this.blikCode = blikCode;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public Float getMoney() {
        return money;
    }

    public Float getDailyLimit() {
        return dailyLimit;
    }

    public String getBlikCode() {
        return blikCode;
    }
}
