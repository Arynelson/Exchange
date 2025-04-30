package com.exchange.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeApiClient {

    private static final String API_KEY = "74be7e686456235befad1080";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public double getExchangeRate(String from, String to) {
        try {
            String urlStr = BASE_URL + API_KEY + "/latest/" + from;
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.connect();

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Erro na conexão com API: " + connection.getResponseMessage());
            }

            Scanner scanner = new Scanner(url.openStream());
            StringBuilder json = new StringBuilder();
            while (scanner.hasNext()) {
                json.append(scanner.nextLine());
            }
            scanner.close();

            JsonObject jsonObject = JsonParser.parseString(json.toString()).getAsJsonObject();
            JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

            if (!rates.has(to)) {
                throw new RuntimeException("Moeda de destino não encontrada: " + to);
            }

            return rates.get(to).getAsDouble();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao consultar taxa de câmbio: " + e.getMessage(), e);
        }
    }
}
