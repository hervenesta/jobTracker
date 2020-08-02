package io.cloudcomputing.jobtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JobIdException extends RuntimeException{
    public JobIdException(String message) {
        super(message);
    }
}
