package koza.dev.traveltogbackend.exception.handler;

import koza.dev.traveltogbackend.exception.AlreadyExistsException;
import koza.dev.traveltogbackend.exception.BaseException;
import koza.dev.traveltogbackend.exception.ErrorResponse;
import koza.dev.traveltogbackend.exception.NoSuchTravellerExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Ops! Something went wrong.", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ BaseException.class })
    public ResponseEntity<Object> handleGlobalBaseException(BaseException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}