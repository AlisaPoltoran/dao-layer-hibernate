package ru.netology.daolayerhibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class DataBaseExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> invalidPersonIdHandler (InvalidPersonId invalidPersonId) {
        return new ResponseEntity<>(invalidPersonId.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
}
