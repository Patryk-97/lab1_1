package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money implements Comparable<Money> {

    private BigDecimal denomination;
    private String currency;

    public Money(BigDecimal denomination, String currency) {
        this.denomination = denomination;
        this.currency = currency;
    }

    public BigDecimal getDenomination() {
        return this.denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.denomination, this.currency);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;
        return Objects.equals(denomination, other.getDenomination()) && Objects.equals(currency, other.getCurrency());
    }

    @Override
    public int compareTo(Money other) {
        return this.denomination.compareTo(other.getDenomination());
    }
}
