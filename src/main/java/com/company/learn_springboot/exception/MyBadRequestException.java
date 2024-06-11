package com.company.learn_springboot.exception;

import com.company.learn_springboot.model.MyResponse;

public class MyBadRequestException extends Exception{

    MyResponse response;
    public MyBadRequestException(MyResponse response) {
        this.response = response;
    }

    public MyResponse getResponse() {
        return response;
    }
}
