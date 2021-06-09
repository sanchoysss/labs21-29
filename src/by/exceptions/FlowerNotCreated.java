package by.exceptions;

public class FlowerNotCreated extends Exception{

    public FlowerNotCreated(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
