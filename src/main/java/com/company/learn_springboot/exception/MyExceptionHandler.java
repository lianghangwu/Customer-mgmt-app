package com.company.learn_springboot.exception;

import com.company.learn_springboot.model.MyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {MyBadRequestException.class, MyResourceNotFoundException.class})
    public ResponseEntity<MyResponse> handleMyBadRequestException(Exception ex) {
        MyBadRequestException obj1;
        MyResourceNotFoundException obj2;
        MyResponse res = null;

        if(ex instanceof  MyBadRequestException) {
            obj1 = (MyBadRequestException)ex;
            res = obj1.getResponse();
        }
        if(ex instanceof  MyResourceNotFoundException) {
            obj2 = (MyResourceNotFoundException)ex;
            res = obj2.getResponse();
        }

        System.out.println("----------------In @RestControllerAdvice------------------");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
