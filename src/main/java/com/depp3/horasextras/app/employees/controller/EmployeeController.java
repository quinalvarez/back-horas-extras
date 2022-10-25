package com.depp3.horasextras.app.employees.controller;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(service.save(employeeDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
