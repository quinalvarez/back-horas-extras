package com.depp3.horasextras.generals.enums;

public enum CodeError {

    EXIST_OBJ(1000),
    INVALID_DATA(1001),
    NON_EXIST_OBJ(1002);

    private final int code;

    CodeError(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
