package a10062024_kr3;

public class NotEnoughMoneyException extends Exception{
    NotEnoughMoneyException(String message) {
        super(message);
    }
}