package conv.domain;

public interface CurrencyDTO {

    double getRate();
    void setRate(double rate);
    void setFromCurrency(String fromCurrency);
    String getFromCurrency();
    String getToCurrency();
    void setToCurrency(String toCurrency);
}
