package model.exception;

public class InsufficientBalanceException extends RuntimeException{     // extending RuntimeExeption so this class obliges to treat the model.exception

    public InsufficientBalanceException(String message) {
        super(message);
    }

}
