package model.atm;

import model.Account;
import model.payment.Bill;
import model.payment.PaySlip;
import model.payment.PayableDocument;
import model.payment.RefundPayment;

public class Atm {

    public static void printInfo(Account account) {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("Account: " + account.getAgency() + " / " + account.getNumber());
        System.out.println("Holder: " + account.getHolder());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Available balance: " + account.getAvailableBalance());
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    }

    public static void payBill(Bill bill, Account account) {
        if (bill.isPayed()) {
            throw new IllegalStateException("you already payed this bill 💸");
        }

        account.withdraw(bill.getTotalValue());

        bill.settlePayment();

    }

    public static void paySalary(PaySlip paySlip, Account account, Account worker) {
        if (paySlip.isPayed()) {
            throw new IllegalStateException("the worker already received their salary 💸");
        }

        account.withdraw(paySlip.getTotalValue());
        worker.deposit(paySlip.getTotalValue());

        paySlip.settlePayment();

    }

    public static void refund(RefundPayment document, Account account) {
        if (!document.isPayed()) {
            throw new IllegalStateException("you didn't pay this YET D:<");
        }

        account.deposit(document.getTotalValue());
        document.refundPayment();

    }
 }
