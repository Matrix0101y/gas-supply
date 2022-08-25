package az.socar.gassupply.exception;

public class ExpirationCodeIsExpiredException extends RuntimeException{
    private String message;

    public ExpirationCodeIsExpiredException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
