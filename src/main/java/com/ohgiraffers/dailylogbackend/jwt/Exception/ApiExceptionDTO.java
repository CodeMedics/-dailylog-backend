package com.ohgiraffers.dailylogbackend.jwt.Exception;

public class ApiExceptionDTO {

    private int state;
    private String message;

    public ApiExceptionDTO(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiExceptionDTO{" +
                "state=" + state +
                ", message='" + message + '\'' +
                '}';
    }
}
