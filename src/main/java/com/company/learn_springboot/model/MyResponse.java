package com.company.learn_springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyResponse {

    @JsonProperty("message")
    private String message;
    @JsonProperty("code")
    private int code;
    @JsonProperty("status")
    private String status;

    public MyResponse() {

    }

    public MyResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
