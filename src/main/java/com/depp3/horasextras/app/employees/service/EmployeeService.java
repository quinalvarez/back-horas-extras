package com.depp3.horasextras.app.employees.service;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.mapper.EmployeeMapper;
import com.depp3.horasextras.app.employees.data.repository.EmployeeRepository;
import com.depp3.horasextras.generals.exception.response_body.error_message.InternalErrorObj;
import com.depp3.horasextras.generals.messages.Message;
import com.depp3.horasextras.app.employees.exception.EmployeeException;
import com.depp3.horasextras.generals.utils.Jsons;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;
    @Bean
    private EmployeeMapper createMapping() {
        return new EmployeeMapper();
    }

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
        this.mapper = createMapping();
    }

    public EmployeeDTO save(EmployeeDTO employee) {
        if (repository.existsByDni(employee.getDni())) {
            throw new EmployeeException(
                    HttpStatus.BAD_REQUEST,
                    Message.EXIST.value(),
                    Jsons.convertObjectToJson(new InternalErrorObj(employee, Message.EXIST.internalMessage())),
                    Message.EXIST.reason());
        }

        if (Objects.isNull(employee.getDni()) || employee.getDni().equals("")) {
            throw new EmployeeException(
                    HttpStatus.BAD_REQUEST,
                    Message.INVALID_DNI.value(),
                    Jsons.convertObjectToJson(new InternalErrorObj(employee, Message.INVALID_DNI.internalMessage())),
                    Message.INVALID_DNI.reason());
        }

        return mapper.toDTO(repository.save(mapper.toDomain(employee)));
    }

    public List<EmployeeDTO> findAll() {
        return repository.findAllOrderActive().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeDTO> findAllActive() {
        return repository.findAllActive().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
