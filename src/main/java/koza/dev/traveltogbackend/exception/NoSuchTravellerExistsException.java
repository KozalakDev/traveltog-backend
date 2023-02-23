package koza.dev.traveltogbackend.exception;


public class NoSuchTravellerExistsException
        extends RuntimeException {

    private String message;

    public NoSuchTravellerExistsException() {}

    public NoSuchTravellerExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}