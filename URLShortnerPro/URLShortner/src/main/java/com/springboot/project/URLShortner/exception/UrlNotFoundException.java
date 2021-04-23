package com.springboot.project.URLShortner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "Short URL not found")
public class UrlNotFoundException extends RuntimeException{

    public UrlNotFoundException(String message) {
        super(message);
    }

}
