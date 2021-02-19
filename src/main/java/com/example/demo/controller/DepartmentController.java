package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Departments", description = "Interaction with departments ")
public class DepartmentController {

    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(value = "/department")
    @Operation(summary = "Create department", description = "Create department")
    public ResponseEntity<?> create(@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/department")
    @Operation(summary = "Get all departments", description = "Get all departments with their users")
    public ResponseEntity<List<Department>> read() {
        final List<Department> department = departmentService.readAll();

        return department != null &&  !department.isEmpty()
                ? new ResponseEntity<>(department, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/department/{id}")
    @Operation(summary = "Get one department", description = "Get one department by ID")
    public ResponseEntity<Department> read(@PathVariable(name = "id") int id) {
        final Department department = departmentService.read(id);

        return department != null
                ? new ResponseEntity<>(department, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/department/{id}")
    @Operation(summary = "Update department", description = "Update department")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Department department) {
        final boolean updated = departmentService.update(department, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/department/{id}")
    @Operation(summary = "Delete department", description = "Delete department by ID")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = departmentService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
