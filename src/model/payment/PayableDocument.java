package model.payment;

import java.math.BigDecimal;

public interface PayableDocument {
    // all fields/method fields public & and abstract
    BigDecimal getTotalValue();
    boolean isPayed();
    void settlePayment();

    default void printReceipt() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
        System.out.println("RECEIPT: ");
        System.out.println("Total: " + getTotalValue());
        System.out.println("Payed: " + isPayed());
        System.out.println("* * * * * * * * * * * * * * * * * * * * *");
    }

}
