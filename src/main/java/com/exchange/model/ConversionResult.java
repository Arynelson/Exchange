package com.exchange.model;
//ConversionResult.java: modelo para guardar o valor convertido



public record ConversionResult(String from, String to, double originalAmount, double convertedAmount) {
}
