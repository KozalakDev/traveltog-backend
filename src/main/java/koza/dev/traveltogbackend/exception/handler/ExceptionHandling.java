package koza.dev.traveltogbackend.exception.handler;

import koza.dev.traveltogbackend.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ BusinessException.class })
    public ResponseEntity<Object> handleBusinessException(BusinessException ex, WebRequest request) {
        return new ResponseEntity<>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }




}