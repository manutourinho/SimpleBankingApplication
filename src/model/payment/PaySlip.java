package model.payment;

import model.Client;
import model.SalaryAcc;

import java.math.BigDecimal;

public class PaySlip implements PayableDocument{

    private Client client;
    private BigDecimal valueHour;
    private int numberOfHours;
    private boolean isPayed;

    public PaySlip() {}

    public PaySlip(Client client, BigDecimal valueHour, int numberOfHours) {
        this.client = client;
        this.valueHour = valueHour;
        this.numberOfHours = numberOfHours;

    }

    @Override
    public BigDecimal getTotalValue() {
        return valueHour.multiply(new BigDecimal(numberOfHours));

    }

    @Override
    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public void settlePayment() {
        isPayed = true;
    }


    @Override
    public void printReceipt() {
        PayableDocument.super.printReceipt();
    }
}
