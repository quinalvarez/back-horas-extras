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

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> findAll(@RequestParam(required = false, defaultValue = "0") Integer tipo) {
        return ResponseEntity.ok(service.findAll(tipo));
    }

    @GetMapping("/{dni}")
    public ResponseEntity<EmployeeDTO> findByDni(@PathVariable String dni) {
        return ResponseEntity.ok(service.findByDni(dni));
    }

    @PutMapping()
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(service.update(employeeDTO));
    }

    @DeleteMapping()
    public ResponseEntity<EmployeeDTO> delete(@PathVariable String dni) {
        return ResponseEntity.ok(service.delete(dni));
    }
}
