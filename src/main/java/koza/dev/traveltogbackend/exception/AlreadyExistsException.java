package koza.dev.traveltogbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AlreadyExistsException extends RuntimeException {

    private String message;


    public AlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;

    }

}