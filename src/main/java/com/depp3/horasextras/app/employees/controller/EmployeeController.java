package com.depp3.horasextras.app.employees.controller;

import com.depp3.horasextras.app.employees.data.dto.EmployeeDTO;
import com.depp3.horasextras.app.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Guardar un empleado cuando el dni no se encuentre en la base")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se guardo con exito",
                content = { @Content (mediaType = "application/json",
                    schema = @Schema(implementation = EmployeeDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "El empleado ya existe",
                content = @Content),
            @ApiResponse(responseCode = "400", description = "Ingrese un dni valido")
    })
    @PostMapping
    public ResponseEntity<EmployeeDTO> save(@Parameter(description = "Empleado que se guardara, dni unico dato requerido")
                                                @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(service.save(employeeDTO));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> findAll(@RequestParam(required = false, defaultValue = "2") Integer tipo) {
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
