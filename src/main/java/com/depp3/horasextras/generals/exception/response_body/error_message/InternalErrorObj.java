package com.depp3.horasextras.generals.exception.response_body.error_message;

public class InternalErrorObj {

    private Object object;
    private String message;

    public InternalErrorObj() {}

    public InternalErrorObj(Object object, String message) {
        this.object = object;
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public String getMessage() {
        return message;
    }
}
