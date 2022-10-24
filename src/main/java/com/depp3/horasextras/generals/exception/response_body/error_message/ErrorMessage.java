package com.depp3.horasextras.generals.exception.response_body.error_message;

public class ErrorMessage {

    private String message;
    private Integer code;
    private String path;

    public ErrorMessage(String message, Integer code, String path) {
        this.message = message;
        this.code = code;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public String getPath() {
        return path;
    }
}
