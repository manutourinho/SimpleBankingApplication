package model;

import model.payment.PaySlip;

import java.math.BigDecimal;

public class SalaryAcc extends Account{

    public SalaryAcc(Client holder, String agency, int number) {
        super(holder, agency, number);

    }

    public void transferSalary(Account workersAcc, Account recipient) {
        recipient.deposit(getBalance());
        workersAcc.withdraw(getBalance());

    }

    @Override
    public void debitMonthlyFee() {

    }
}
