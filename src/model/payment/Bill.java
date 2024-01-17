package model.payment;

import model.Client;

import java.math.BigDecimal;

public class Bill implements PayableDocument, RefundPayment{

    private Client recipient;
    private BigDecimal value;
    private boolean isPayed;

    public Bill(Client recipient, BigDecimal value) {
        this.recipient = recipient;
        this.value = value;

    }

    @Override
    public BigDecimal getTotalValue() {
        return value;

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
    public void refundPayment() {
        isPayed = false;

    }

}
