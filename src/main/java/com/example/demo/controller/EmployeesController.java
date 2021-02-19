package com.example.demo.controller;

import com.example.demo.model.Employees;
import com.example.demo.service.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Employees", description = "Interaction with employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @PostMapping(value = "/employees")
    @Operation(summary = "Create employee", description = "Create employee")
    public ResponseEntity<?> create(@RequestBody Employees employees) {
        employeesService.create(employees);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/employees")
    @Operation(summary = "Get all employees", description = "Get all employees")
    public ResponseEntity<List<Employees>> read() {
        final List<Employees> employees = employeesService.readAll();

        return employees != null &&  !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/employees/{id}")
    @Operation(summary = "Get one employee", description = "Get one employee by ID")
    public ResponseEntity<Employees> read(@PathVariable(name = "id") int id) {
        final Employees employees = employeesService.read(id);

        return employees != null
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PutMapping(value = "/employees/{id}")
//    @Operation(summary = "Update employee", description = "Update employee")
//    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Employees employees) {
//        final boolean updated = employeesService.update(employees, id);

//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }

    @DeleteMapping(value = "/employees/{id}")
    @Operation(summary = "Delete employee", description = "Delete employee by ID")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = employeesService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}