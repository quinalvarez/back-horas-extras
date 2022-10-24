package com.depp3.horasextras.app.employees.service;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.mapper.EmployeeMapper;
import com.depp3.horasextras.app.employees.data.repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
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
        if (repository.existsByDni(employee.getDni())) {
            throw new RuntimeException("El empleado ya existe");
        }
        if (Objects.isNull(employee.getDni()) || employee.getDni().equals("")) {
            throw new RuntimeException("Debe ingresar un dni valido");
        }
        return mapper.toDTO(repository.save(mapper.toDomain(employee)));
    }
}
