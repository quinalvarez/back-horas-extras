package com.depp3.horasextras.generals.exception;

import com.depp3.horasextras.app.employees.exception.EmployeeException;
import com.depp3.horasextras.generals.exception.response_body.error_message.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmployeeException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> employeeExceptions(HttpServletRequest request, GenericException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(
                new ErrorMessage(
                        ex.getVisibleMessage(),
                        ex.getCode(),
                        request.getRequestURI()
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
