package com.depp3.horasextras.app.employees.data.mapper;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.data.entity.Employee;

public class EmployeeMapper {

    public Employee toDomain(EmployeeDTO employeeDTO) {
        return new Employee(
                employeeDTO.getDni(),
                employeeDTO.getName(),
                employeeDTO.getLastname(),
                employeeDTO.getActive().equals("ACTIVE")
        );
    }

    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getDni(),
                employee.getName(),
                employee.getLastname(),
                employee.getActive()
        );
    }
}
