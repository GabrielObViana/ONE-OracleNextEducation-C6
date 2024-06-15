package br.com.oracle.currencyexchange;

import java.math.BigDecimal;
import java.math.BigInteger;

public record CurrencyExchangeResponse (
    String result,
    String documentation,
    String terms_of_use,
    BigInteger time_last_update_unix,
    BigInteger timenext_update_unix,
    String time_last_update_utc,
    String time_next_update_utc,
    String base_code,
    String target_code,
    BigDecimal conversion_rate) {}