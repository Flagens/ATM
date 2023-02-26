package com.company;

public enum PaymentMethodEnum {
    CARD, BLIK, CASH;

    public static PaymentMethodEnum getMethod(int id){
        if(id == 1) return CARD;
        else if(id == 2) return BLIK;
        else if(id == 3) return CASH;
        else return null;
    }
}
