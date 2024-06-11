package com.company.learn_springboot.exception;

import com.company.learn_springboot.model.MyResponse;

public class MyResourceNotFoundException extends Exception{

    MyResponse response;
    public MyResourceNotFoundException(MyResponse response) {
        this.response = response;
    }

    public MyResponse getResponse() {
        return response;
    }
}
