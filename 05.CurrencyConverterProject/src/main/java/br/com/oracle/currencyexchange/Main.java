package br.com.oracle.currencyexchange;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String apiKey = (args.length > 0) ? args[0] : "your_default_api_key";
        ApiRequest apiRequest = new ApiRequest(apiKey);
        CurrencyExchanger currencyExchanger = new CurrencyExchanger(apiRequest);

        System.out.println("*************************");
        System.out.println("* CURRENCY EXCHANGE APP *");
        System.out.println("*************************");

        while (true) {
            // Display menu options
            System.out.println("");
            System.out.println("Choose an option: ");
            System.out.println("1. Perform Exchange");
            System.out.println("2. History of transactions");
            System.out.println("3. Exit");
            System.out.print("Enter option number: ");

            // Get user input
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    performExchange(scanner, currencyExchanger);
                    break;
                case 2:
                    printTransactions(currencyExchanger);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void performExchange(Scanner scanner, CurrencyExchanger currencyExchanger) {

        printCurrencies();

        Integer baseIndex = retrieveCurrencyIntegerFromUser(scanner, "base");
        Integer targetIndex = retrieveCurrencyIntegerFromUser(scanner, "target");

        System.out.println("enter the amount of to exchange: ");
        BigDecimal amount = scanner.nextBigDecimal();

        String baseCode = Currency.fromIndex(baseIndex);
        String targetCode = Currency.fromIndex(targetIndex);

        System.out.println("\nExchanging " + amount + " " + baseCode + " for " + targetCode + "...");

        BigDecimal result = currencyExchanger.convert(baseCode, targetCode,
                amount);

        if (result == null) {
            System.out.println("Invalid input. Please try again.");
        }

        System.out.println(String.format("\nResult: %.2f %s\n", result, targetCode));
    }

    public static void printCurrencies() {
        for (Currency currency : Currency.values()) {

            System.out.println(
                    String.format("%d - %s currency | %s ", currency.getIndex(), currency.getDescription(),
                            currency.getCode()));
        }
    }

    public static Integer retrieveCurrencyIntegerFromUser(Scanner scanner, String currencyType) {
        System.out.println(String.format("enter the number of %s currency: ", currencyType));
        Integer index = scanner.nextInt();
        return index;
    }

    public static void printTransactions(CurrencyExchanger currencyExchanger) {

        for (Transactions transaction : currencyExchanger.getTransactions()) {
            System.out.println(
                    String.format("%s - Amount of %f of %s was exchange to %f %s", transaction.date(), transaction.amount(),
                            transaction.baseCurrency(), transaction.result(), transaction.targetCurrency()));
        }
    }
}