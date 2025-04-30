package com.exchange.ui;
//Menu.java: exibe as opções para o usuário e lê entrada
import com.exchange.service.CurrencyConverterService;

import java.util.Scanner;

public class Menu {
    private final CurrencyConverterService converterService = new CurrencyConverterService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        String option;

        do {
            printMenu();
            option = scanner.nextLine().trim().toUpperCase();

            switch (option) {
                case "1" -> convert("USD", "");
                case "2" -> convert("", "USD");
                case "3" -> convert("USD", "BRL");
                case "4" -> convert("BRL", "USD");
                case "5" -> convert("USD", "");
                case "6" -> convert("", "USD");
                case "7" -> convert("BRL", "BTC");
                case "8" -> convert("BRL", "EUR");
                case "9" -> convert("EUR", "BRL");
                case "S" -> System.out.println("Saindo... 👋");
                default -> System.out.println("Opção inválida ❌");
            }
        } while (!option.equals("S"));
    }

    private void printMenu() {
        System.out.println("\n=== CONVERSOR DE MOEDAS ===");
        System.out.println("1.Dólar → Peso Argentino");
        System.out.println("2. Peso Argentino → Dólar");
        System.out.println("3. Dólar → Real Brasileiro");
        System.out.println("4. Real Brasileiro → Dólar");
        System.out.println("5. Dólar → Peso Colombiano");
        System.out.println("6. Peso Colombiano → Dólar");
        System.out.println("7. Real Brasileiro → Biticoin");
        System.out.println("8. Real Brasileiro → Euro");
        System.out.println("9. Euro → Real Brasileiro");
        System.out.println("S. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void convert(String from, String to) {
        System.out.print("Digite o valor em " + from + ": ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            double result = converterService.convert(from, to, amount);
            System.out.printf("Valor convertido: %.4f %s%n", result, to);
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido ❗");
        } catch (RuntimeException e) {
            System.out.println("Erro na conversão: " + e.getMessage());
        }
    }
}
