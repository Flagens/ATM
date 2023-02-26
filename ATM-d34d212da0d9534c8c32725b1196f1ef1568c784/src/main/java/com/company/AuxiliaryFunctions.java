package com.company;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.IntStream;

import static com.company.Constants.consoleScanner;

public class AuxiliaryFunctions {
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static float getFloatInput(String errorMessage) {
        Float floatInput = null;
        while (floatInput == null) {
            try {
                floatInput = Float.parseFloat(consoleScanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.print(errorMessage);
            }
        }
        return floatInput;
    }

    public static int getIntsBySemicolons(String errorMessage, boolean extendedVersion) {
        int ret = 0;
        while (true) {
            try {
                String input = consoleScanner.nextLine();
                if (extendedVersion) {
                    if (Objects.equals(input.strip().toLowerCase(), "x")) {
                        return -1;
                    } else if (Objects.equals(input.strip().toLowerCase(), "z")) {
                        return -2;
                    }
                }
                String[] notes = input.split(";");
                int[] intNotes = Arrays.stream(notes).map(Integer::parseInt).mapToInt(i -> i).toArray();
                return IntStream.of(intNotes).sum();
            } catch (NumberFormatException ignored) {
                System.out.print(errorMessage);
            }
        }
    }

    public static float cutFloat(float number, int digits) {
        return Math.round(number * (float) Math.pow(10f, digits)) / (float) Math.pow(10f, digits);
    }

    public static String getStringInput(String message, int length) {
        while (true) {
            System.out.print(message);
            String input = consoleScanner.nextLine();
            if (input.length() == length) return input;
        }
    }

    public static Card getCard(String number, Boolean searchByBlik) {
        if (!searchByBlik)
            for (Card card : Constants.CARDS) {
                if (Objects.equals(card.getNumber(), number)) return card;
            }
        else
            for (Card card : Constants.CARDS) {
                if (Objects.equals(card.getBlikCode(), number)) return card;
            }
        return null;
    }

    public static float getRandomNumber(float min, float max) {
        return (float) ((Math.random() * (max - min)) + min);
    }

    public static int getIntInput(String errorMessage) {
        float input = getFloatInput(errorMessage);
        while (input != (int) input) {
            System.out.print(errorMessage);
            input = getFloatInput(errorMessage);
        }
        return (int) input;
    }

    public static int getIntInput(String errorMessage, int[] inTable) {
        int input = getIntInput(errorMessage);
        while (!contains(inTable, input)) {
            System.out.print(errorMessage);
            input = getIntInput(errorMessage);
        }
        return input;
    }

    public static boolean getRandom(double percentChance) {
        return Math.random() * 100 < percentChance;
    }

    public static JSONObject getJsonObject(String urlString) throws IOException, JSONException {
        HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
        connection.setRequestProperty("access-token", "r392jnfv2-almf92nww1-ld:fwfa");
        connection.connect();
//        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder jsonStringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            jsonStringBuilder.append(line);
        }
        JSONObject jsonObj = new JSONObject(jsonStringBuilder.toString());
        reader.close();
        return jsonObj;
    }




    public static void sendPostRequest(int id, String blikCode, int verified, int executed, float amount, Date date) {
        try {
            URL url = new URL(Constants.urltoPost);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setRequestProperty("access-token", "r392jnfv2-almf92nww1-ld:fwfa");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String mysqlDate = sdf.format(date);

            JSONObject jsonParam = new JSONObject();
            jsonParam.put("id", id);
            jsonParam.put("blikCode", blikCode);
            jsonParam.put("verified", verified);
            jsonParam.put("executed", executed);
            jsonParam.put("amount", amount);
            jsonParam.put("date",mysqlDate);

            DataOutputStream os = new DataOutputStream(connection.getOutputStream());
            os.writeBytes(jsonParam.toString());
            os.flush();
            os.close();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    public static Date getDate() {
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}








