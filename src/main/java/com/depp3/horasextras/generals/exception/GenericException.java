package com.depp3.horasextras.generals.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{

    private HttpStatus status;
    private Integer code;
    private String visibleMessage;

    public GenericException(HttpStatus status, Integer code, String internalMessage, String visibleMessage) {
        super(internalMessage);
        this.status = status;
        this.code = code;
        this.visibleMessage = visibleMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getVisibleMessage() {
        return visibleMessage;
    }
}
