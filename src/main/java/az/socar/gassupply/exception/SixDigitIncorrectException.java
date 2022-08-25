package az.socar.gassupply.exception;

public class SixDigitIncorrectException extends RuntimeException{
    private String message;

    public SixDigitIncorrectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
