package Entity;

public enum Currency {

    ARS("ARS"),
        ;

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
