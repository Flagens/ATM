package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Objects;

import com.company.dto.BlikDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import static com.company.Graphics.printConfirmation;
import static com.company.Graphics.printReceipt;

public class PaymentMethods {

    public PaymentMethods() {
    }

    public boolean card(){
        if(AuxiliaryFunctions.getRandom(5)){
            System.out.println("Odczytanie karty nie poszło poprawnie!");
            return false;
        }
        String givenPin = AuxiliaryFunctions.getStringInput("Podaj PIN: ", 4);
        Card card =  AuxiliaryFunctions.getCard(Constants.CARD_NUMBER, false);
        if(card == null){
            System.out.println("Błąd karty!");
        } else if(!Objects.equals(card.getPin(), givenPin)){
            System.out.println("Błędny PIN!");
        } else if(card.getMoney() < Globals.price){
            System.out.println("Niewystarczające środki na karcie!");
        } else if(card.getDailyLimit() < Globals.price){
            System.out.println("Przekroczono dzienny limit karty!");
        } else if(AuxiliaryFunctions.getRandom(5)){
            System.out.println("Pobranie środków się nie udało!");
        } else {
            System.out.print("Czy drukować potwierdzenie (0 - nie, 1 - tak): ");
            if(AuxiliaryFunctions.getIntInput("Wpisz liczbę 0 lub 1 w zależności od twojego wyboru: ", new int[]{0, 1}) == 1){
                printConfirmation();
            }
            printReceipt();
        }
        return false;
    }

    public boolean blik() throws IOException, JSONException {
        String blikCode = AuxiliaryFunctions.getStringInput("Podaj kod BLIK: ", 6);

        JSONObject jsonObject = AuxiliaryFunctions.getJsonObject(MessageFormat.format("{0}blik/{1}/", Constants.url, blikCode));
        System.out.println(jsonObject);

        ObjectMapper objectMapper = new ObjectMapper();
        BlikDTO blikDTO = objectMapper.readValue(jsonObject.toString(), BlikDTO.class);
        System.out.println(blikDTO);
        System.out.println(AuxiliaryFunctions.getDate());
        System.out.println("Wysylam do banku");

       AuxiliaryFunctions.sendPostRequest(2,blikCode,0,0,10,AuxiliaryFunctions.getDate());



        return false;
    }

    public boolean cash(){
        System.out.print("Podaj banknoty: ");
        int payment = AuxiliaryFunctions.getIntsBySemicolons("Niepoprawna kwota, spróbuj jeszcze raz: ", false);
        int ret = cashHandler(payment);
        while(true){
            switch (ret){
                case -1:
                    return false;
                case -2:
                    return true;
                default:
                    payment += ret;
                    ret = cashHandler(payment);
            }
        }
    }

    private int cashHandler(int payment){
        float difference = -1 * (AuxiliaryFunctions.cutFloat(payment - Globals.price, 2));
        if(difference <= 0){
            System.out.println("Płatność zakończona sukcesem, reszta wynosi " + -1 * difference);
            printReceipt();
        } else {
            System.out.print("Za mało gotówki - brakuje ci " + difference + ". Dołóż banknoty albo wpisz \"X\" żeby zakończyć transakcję albo wpisz \"Z\" żeby zmienić sposób płatności: ");
            return AuxiliaryFunctions.getIntsBySemicolons("Wybierz \"X\", \"Z\" lub podaj banknoty rozdzielone \";\": ", true);
        }
        return -1;
    }
}
