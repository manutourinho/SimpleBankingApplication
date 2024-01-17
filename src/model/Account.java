package model;

import model.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Account {

    private Client holder;
    private String agency;
    private int number;
    private BigDecimal balance = BigDecimal.ZERO;   // initially instanced to zero to avoid NullPointExeption
    public abstract void debitMonthlyFee();    // to be implemented in children's classes

    Account() {

    }
    public Account(Client holder, String agency, int number) {
        Objects.requireNonNull(holder);

        this.holder = holder;
        this.agency = agency;
        this.number = number;
    }

    public void deposit(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("your deposit needs to be bigger than 0, dummy");
        }

        balance = balance.add(value);
    }

    public void withdraw(BigDecimal value) {
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("your balance needs to be bigger than the withdraw!!!");
        }

        if (getAvailableBalance().subtract(value).compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("your balance is insufficient :(");   // creating an model.exception extending RuntimeException!
        }

        balance = balance.subtract(value);
    }

    public void withdraw(BigDecimal value, BigDecimal fee) {    // method overload, calling the other method, in case the bank needs to charge a fee for the withdraw
        withdraw(value.add(fee));

    }

    // only getters for security purposes
    public Client getHolder() {
        return holder;
    }

    public String getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getAvailableBalance() {
        return getBalance();
    }


}
