package com.depp3.horasextras.app.employees.service;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.entity.Employee;
import com.depp3.horasextras.generals.enums.InternalMessageError;
import com.depp3.horasextras.generals.enums.CodeError;
import com.depp3.horasextras.generals.enums.ExternalMessageError;
import com.depp3.horasextras.app.employees.data.mapper.EmployeeMapper;
import com.depp3.horasextras.app.employees.data.repository.EmployeeRepository;
import com.depp3.horasextras.generals.exception.response_body.error_message.InternalErrorObj;
import com.depp3.horasextras.app.employees.exception.EmployeeException;
import com.depp3.horasextras.generals.utils.Jsons;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                    CodeError.EXIST_OBJ.code(),
                    Jsons.convertObjectToJson(new InternalErrorObj(employee, InternalMessageError.EMP_SAVE.value())),
                    ExternalMessageError.EMPLOYEE_EXIST.value()
                    );
        }

        if (Objects.isNull(employee.getDni()) || employee.getDni().equals("")) {
            throw new EmployeeException(
                    HttpStatus.BAD_REQUEST,
                    CodeError.INVALID_DATA.code(),
                    Jsons.convertObjectToJson(new InternalErrorObj(employee, InternalMessageError.EMP_SAVE.value())),
                    ExternalMessageError.INVALID_DNI_MGE.value());
        }

        return mapper.toDTO(repository.save(mapper.toDomain(employee)));
    }

    public List<EmployeeDTO> findAll(Integer tipo) {
        List<EmployeeDTO> employees = new ArrayList<>();

        if (tipo == 0) {
            employees = repository.findAllOrderActive().stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } else if (tipo == 1) {
            employees = repository.findAllActive().stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } else if (tipo == 2){
            employees = repository.findAllInactive().stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        }

        return employees;
    }

    public EmployeeDTO findByDni(String dni) {
        return mapper.toDTO(repository.findByDni(dni).orElseThrow(() -> new EmployeeException(
                    HttpStatus.BAD_REQUEST,
                    CodeError.NON_EXIST_OBJ.code(),
                    Jsons.convertObjectToJson(new InternalErrorObj(dni, InternalMessageError.EMP_FIND_DNI.value())),
                    ExternalMessageError.EMPLOYEE_NOT_EXIST_MGE.value()
            )));
    }

    public EmployeeDTO update(EmployeeDTO employee) {
        repository.findByDni(employee.getDni()).orElseThrow(() -> new EmployeeException(
                HttpStatus.BAD_REQUEST,
                CodeError.NON_EXIST_OBJ.code(),
                Jsons.convertObjectToJson(new InternalErrorObj(employee, InternalMessageError.EMP_FIND_DNI_UP.value())),
                ExternalMessageError.EMPLOYEE_NOT_EXIST_MGE.value()
        ));

        repository.save(mapper.toDomain(employee));

        return employee;
    }

    public EmployeeDTO delete(String dni) {
        Employee employee = repository.findByDni(dni).orElseThrow(() -> new EmployeeException(
                HttpStatus.BAD_REQUEST,
                CodeError.NON_EXIST_OBJ.code(),
                Jsons.convertObjectToJson(new InternalErrorObj(dni, InternalMessageError.EMP_DELETE.value())),
                ExternalMessageError.EMPLOYEE_NOT_EXIST_MGE.value()
        ));

        if (!employee.getActive()) {
            throw new EmployeeException(
                    HttpStatus.BAD_REQUEST,
                    CodeError.INVALID_DATA.code(),
                    Jsons.convertObjectToJson(new InternalErrorObj(employee, InternalMessageError.EMP_DELETE.value())),
                    ExternalMessageError.IDLE_EMPLOYEE.value()
            );
        }

        employee.setActive(false);

        repository.save(employee);

        return mapper.toDTO(employee);
    }
}
