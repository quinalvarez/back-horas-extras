package com.depp3.horasextras.app.employees.data.repository;

import com.depp3.horasextras.app.employees.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByDni(String dni);

    Optional<Employee> findByDni(String dni);

    @Procedure(name = "findAllEmployees")
    List<Employee> findAllEmployees(@Param("tipo") Integer tipo);
}
