package model;

import java.math.BigDecimal;

public class SpecialAcc extends Account {   // a checking account that requires no minimum balance but in which a small charge is made for each check issued or drawn and for monthly maintenance

    private BigDecimal valueLimit;

    public SpecialAcc(Client holder, String agency, int number, BigDecimal valueLimit) {
        super(holder, agency, number);
        this.valueLimit = valueLimit;

    }

    @Override
    public void debitMonthlyFee() {
        withdraw(new BigDecimal("20"));

    }

    @Override
    public BigDecimal getAvailableBalance() {
        return getBalance().add(getValueLimit());
    }

    public BigDecimal getValueLimit() {
        return valueLimit;
    }

    public void setValueLimit(BigDecimal valueLimit) {
        this.valueLimit = valueLimit;
    }
}
