package az.socar.gassupply.exception;

public class EmailIsIncorrectException extends RuntimeException{
    private String message;

    public EmailIsIncorrectException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
