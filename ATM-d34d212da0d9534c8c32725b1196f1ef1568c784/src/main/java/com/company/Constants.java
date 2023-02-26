package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Constants {
    public static final PaymentMethods paymentMethods = new PaymentMethods();
    public static final Scanner consoleScanner = new Scanner(System.in);
    public static final float LOWEST_PRICE = 100f;
    public static final float HIGHEST_PRICE = 200f;
    public static final String CARD_NUMBER = "12425444656565654644";
    public static final Card[] CARDS = new Card[]{
            new Card("12425444656565654644", "1242", 2000f, 200f, "4231"),
            new Card("34445444656565654644", "6565", 19400f, 1000f, "3241")
    };
    public static final String ACCESS_TOKEN = "r392jnfv2-almf92nww1-ld:fwfa";
    public static String url = "http://192.168.1.45:8080/api/";
    public static String urltoPost = "http://192.168.1.45:8080/api/transaction/blik/";

}
