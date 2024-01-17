package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentAcc extends Account{

    public InvestmentAcc(Client holder, String agency, int number) {
        super(holder, agency, number);
    }

    @Override
    public void debitMonthlyFee() {
        if (getBalance().compareTo(new BigDecimal("10000")) < 0) {
            withdraw(new BigDecimal("30"));
        }
    }

    public void creditIncome(BigDecimal interestPercentage) {
        BigDecimal valueIncome = (getBalance().multiply(interestPercentage))
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);    // bankers rounding

        deposit(valueIncome);
    }
}
