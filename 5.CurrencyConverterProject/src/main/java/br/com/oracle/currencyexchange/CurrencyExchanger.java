package br.com.oracle.currencyexchange;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CurrencyExchanger {

    private ApiRequest apiRequest = new ApiRequest();
    private List<Transactions> transactions = new ArrayList<>();

    CurrencyExchanger() {
    }

    CurrencyExchanger(ApiRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public BigDecimal convert(String baseCode, String targetCode, BigDecimal amount) {

        CurrencyExchangeResponse response = apiRequest
                .getConversionCurrencyFromBaseToTarget(baseCode, targetCode);

        BigDecimal result = amount.multiply(response.conversion_rate());
        transactions.add(new Transactions(amount, Currency.fromCode(baseCode), Currency.fromCode(targetCode), result,
                response.time_last_update_utc(), LocalDateTime.now()));
        return result;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }
}