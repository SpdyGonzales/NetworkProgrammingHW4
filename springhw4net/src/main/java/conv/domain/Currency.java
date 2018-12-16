package conv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "rates")
public class Currency implements CurrencyDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "rate")
    private double rate;

    @Column(name = "from")
    private String fromCurrency;

    @Column(name = "to")
    private String toCurrency;

    protected Currency() {
    }

    public Currency(float rate, String fromCurrency, String toCurrency ) {
        this.rate = rate;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;

    }
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
}