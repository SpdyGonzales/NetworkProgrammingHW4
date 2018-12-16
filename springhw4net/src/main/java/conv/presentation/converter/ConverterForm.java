package conv.presentation.converter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConverterForm {

    @NotNull(message = "Please specify amount")
    @Positive(message = "Amount must be greater than zero")
    private int amount = 0;
    private double result;
    private String fromCurrency;
    private String toCurrency;

    public int getAmount() {
        return this.amount;
    }
    public void setAmount(int amount){this.amount = amount;}
    public void setResult(double result) {
        this.result = result;
    }
    public double getResult(){return this.result;}
    public String getFromCurrency(){return this.fromCurrency;}
    public String getToCurrency(){return this.toCurrency;}
    public void setToCurrency(String toCurrency){this.toCurrency = toCurrency;}
    public void setFromCurrency(String fromCurrency){this.fromCurrency = fromCurrency;}
}
