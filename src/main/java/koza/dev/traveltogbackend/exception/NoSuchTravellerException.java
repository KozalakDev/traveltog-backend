package koza.dev.traveltogbackend.exception;


public class NoSuchTravellerException
        extends RuntimeException {

    private String message;

    public NoSuchTravellerException() {}

    public NoSuchTravellerException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}