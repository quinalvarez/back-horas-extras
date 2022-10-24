package com.depp3.horasextras.app.employees.exception;

import com.depp3.horasextras.generals.exception.GenericException;
import org.springframework.http.HttpStatus;

public class EmployeeException extends GenericException {

    public EmployeeException(HttpStatus status, Integer code, String internalMessage, String visibleMessage) {
        super(status, code, internalMessage, visibleMessage);
    }
}
