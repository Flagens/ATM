package com.company;

import org.json.JSONException;

import java.io.IOException;

import static com.company.Constants.paymentMethods;

public class    Main {

    public static void main(String[] args) {
        Globals.initiatePrice();
        System.out.println("Do zapłaty: " + Globals.price);
        boolean repeat;
        do {
            System.out.print("Wybierz sposób płatności:\n1. Karta\n2. BLIK\n3. Gotówka\nWpisz liczbę odpowiadającą Twojemu wyborowi: ");
            int paymentMethodId = AuxiliaryFunctions.getIntInput("Nieobsługiwana metoda, wybierz numer 1-3: ", new int[]{1, 2, 3});
            PaymentMethodEnum paymentMethod = PaymentMethodEnum.getMethod(paymentMethodId);
            if (paymentMethod == PaymentMethodEnum.CARD || paymentMethod == PaymentMethodEnum.BLIK) {
                if (AuxiliaryFunctions.getRandom(5)) {
                    System.out.println("Terminal nie działa, przyjdź jutro!");
                    return;
                }
                if (AuxiliaryFunctions.getRandom(5)) {
                    System.out.println("Internet nie działa, przyjdź jutro!");
                    return;
                }
                if (paymentMethod == PaymentMethodEnum.CARD) {
                    repeat = paymentMethods.card();
                } else {
                    try {
                        repeat = paymentMethods.blik();
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                        repeat = false;
                    }
                }
            } else {
                repeat = paymentMethods.cash();
            }
        } while(repeat);
    }
}
