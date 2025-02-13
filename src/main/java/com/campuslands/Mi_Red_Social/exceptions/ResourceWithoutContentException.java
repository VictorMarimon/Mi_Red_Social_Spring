package com.campuslands.Mi_Red_Social.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class ResourceWithoutContentException extends RuntimeException{
    public ResourceWithoutContentException(String message){
        super(message);
    }
}
