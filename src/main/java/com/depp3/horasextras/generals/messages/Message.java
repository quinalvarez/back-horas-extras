package com.depp3.horasextras.generals.messages;

public enum Message {

    // EMPLOYEES
    EXIST(1000, "Ya existe un empleado con el dni ingresado", InternalMessage.EMP_SAVE_METHOD.value()),
    INVALID_DNI(1001, "Ingrese un dni valido", InternalMessage.EMP_SAVE_METHOD.value());

    private final int value;
    private final String reason;
    private final String internalMessage;

    private Message(int value, String reason, String internalMessage) {
        this.value = value;
        this.reason = reason;
        this.internalMessage = internalMessage;
    }

    public int value(){
        return value;
    }

    public String reason() {
        return reason;
    }

    public String internalMessage() {
        return internalMessage;
    }

    public static enum InternalMessage {
        // EMPLOYEES
        EMP_SAVE_METHOD("Error en ServiceEmployee.save(EmployeeDTO)");

        private final String message;

        InternalMessage(String message) {
            this.message = message;
        }

        public String value() {
            return message;
        }
    }
}
