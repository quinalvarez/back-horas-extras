package com.depp3.horasextras.generals.enums;

public enum ExternalMessageError {

    INVALID_DNI_MGE("Ingrese un dni valido."),
    EMPLOYEE_NOT_EXIST_MGE("El empleado no existe."),
    EMPLOYEE_EXIST("Ya existe un empleado con el dni ingresado."),
    IDLE_EMPLOYEE("El empleado ya fue dado de baja");

    private final String message;

    ExternalMessageError(String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
