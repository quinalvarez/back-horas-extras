package com.depp3.horasextras.app.employees.data.mapper;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.entity.Employee;

public class EmployeeMapper {

    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getDni(),
                employeeDTO.getName(),
                employeeDTO.getLastname(),
                employeeDTO.getActive()
        );
    }

    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getDni(),
                employee.getName(),
                employee.getLastname(),
                employee.getActive()
        );
    }
}
