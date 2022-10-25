package com.depp3.horasextras.app.employees.data.repository;

import com.depp3.horasextras.app.employees.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Boolean existsByDni(String dni);

    Optional<Employee> findByDni(String dni);

    @Query(
            value = "SELECT * FROM employees e ORDER BY e.is_active DESC",
            nativeQuery = true
    )
    List<Employee> findAllOrderActive();

    @Query(
            value = "SELECT * FROM employees e WHERE e.is_active = 1",
            nativeQuery = true
    )
    List<Employee> findAllActive();

    @Query(
            value = "SELECT * FROM employees e WHERE e.is_active = 0",
            nativeQuery = true
    )
    List<Employee> findAllInactive();
}
