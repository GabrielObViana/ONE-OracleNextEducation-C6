package br.com.oracle.currencyexchange;

public enum Currency {
    ARS("Argentine Peso", "ARS", 1),
    BOB("Bolivian Peso", "BOB", 2),
    BRL("Brazilian Real", "BRL", 3),
    CLP("Chilean Peso", "CLP", 4),
    COP("Colombian Peso", "COP", 5),
    USD("US Dollar", "USD", 6);

    private String description;
    private String code;
    private Integer index;

    Currency(String description, String code, Integer index) {
        this.description = description;
        this.code = code;
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public Integer getIndex() {
        return index;
    }

    public static String fromIndex(Integer index) {
        return values()[index].getCode();
    }

    public static Currency fromCode(String code) {
        for (Currency currency : values()) {
            if (currency.getCode().equals(code)) {
                return currency;
            }
        }
        return null;
    }
}
