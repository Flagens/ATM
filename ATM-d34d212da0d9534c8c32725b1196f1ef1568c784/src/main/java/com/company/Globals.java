package com.company;

public class Globals {
    public static float price;

    public static void initiatePrice(){
        float tempPrice = AuxiliaryFunctions.getRandomNumber(Constants.LOWEST_PRICE, Constants.HIGHEST_PRICE);
        price = AuxiliaryFunctions.cutFloat(tempPrice, 2);
    }
}
