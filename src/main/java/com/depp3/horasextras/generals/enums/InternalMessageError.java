package com.depp3.horasextras.generals.enums;

public enum InternalMessageError {

    EMP_SAVE("Error en ServiceEmployee.save(EmployeeDTO)"),
    EMP_FIND_DNI("Error en ServiceEmployee.findByDni(String)"),
    EMP_FIND_DNI_UP("Error en ServiceEmployee.update(EmployeeDTO)"),
    EMP_DELETE("Error en ServiceEmployee.delete(String)");

    private final String message;

    InternalMessageError (String message) {
        this.message = message;
    }

    public String value() {
        return message;
    }
}
