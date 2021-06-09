package by.exceptions;

public class IdNotFoundException extends Exception{
    private final String EXCEPTION;

    public IdNotFoundException(String exception) {
        this.EXCEPTION = exception;
    }

    public IdNotFoundException() {
        this.EXCEPTION = "Error! Wrong Id!";
    }

    @Override
    public String toString() {
        return this.EXCEPTION;
    }
}
