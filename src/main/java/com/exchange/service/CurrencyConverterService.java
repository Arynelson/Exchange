package com.exchange.service;

import com.exchange.api.ExchangeApiClient;
import com.exchange.model.ConversionResult;

public class CurrencyConverterService {

    private final ExchangeApiClient apiClient = new ExchangeApiClient();

    public double convert(String from, String to, double amount) {
        double rate = apiClient.getExchangeRate(from, to);
        double converted = amount * rate;

        ConversionResult result = new ConversionResult(from, to, amount, converted);
        logResult(result); // apenas para demonstração

        return result.convertedAmount();
    }

    private void logResult(ConversionResult result) {
        System.out.printf("Conversão: %.2f %s → %.2f %s%n",
                result.originalAmount(),
                result.from(),
                result.convertedAmount(),
                result.to());
    }
}
