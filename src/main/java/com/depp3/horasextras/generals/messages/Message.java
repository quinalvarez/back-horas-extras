package com.depp3.horasextras.generals.messages;

public enum Message {

    // EMPLOYEES
    EXIST(1000, "Ya existe un empleado con el dni ingresado"),
    INVALID_DNI(1001, "Ingrese un dni valido");

    private int value;
    private String reason;

    private Message(int value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    public int value(){
        return value;
    }

    public String reason() {
        return reason;
    }
}
