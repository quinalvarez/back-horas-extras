package com.depp3.horasextras.app.employees.service;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.mapper.EmployeeMapper;
import com.depp3.horasextras.app.employees.data.repository.EmployeeRepository;
import com.depp3.horasextras.generals.messages.Message;
import com.depp3.horasextras.app.employees.exception.EmployeeException;
import com.depp3.horasextras.generals.utils.Jsons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private EmployeeMapper mapper;
    @Bean
    private EmployeeMapper createMapping() {
        return new EmployeeMapper();
    }

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
        this.mapper = createMapping();
    }

    public EmployeeDTO save(EmployeeDTO employee) {
        String object = Jsons.convertObjectToJson(employee);

        if (repository.existsByDni(employee.getDni())) {
            throw new EmployeeException(HttpStatus.BAD_REQUEST, Message.EXIST.value(), object, Message.EXIST.reason());
        }

        if (Objects.isNull(employee.getDni()) || employee.getDni().equals("")) {
            throw new EmployeeException(HttpStatus.BAD_REQUEST, Message.INVALID_DNI.value(), object, Message.INVALID_DNI.reason());
        }

        return mapper.toDTO(repository.save(mapper.toDomain(employee)));
    }
}
