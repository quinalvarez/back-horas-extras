package com.depp3.horasextras.app.employees.data.repository;

import com.depp3.horasextras.app.employees.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
