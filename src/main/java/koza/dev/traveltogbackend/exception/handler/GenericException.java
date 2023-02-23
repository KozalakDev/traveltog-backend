package koza.dev.traveltogbackend.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericException extends RuntimeException {
    private HttpStatus httpStatus;
    private String errorMessage;

}
