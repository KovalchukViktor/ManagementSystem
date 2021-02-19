package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public ArrayList<Department> readAll() {
        return (ArrayList<Department>) departmentRepository.findAll();
    }

    @Override
    public Department read(int id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public boolean update(Department department, int id) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            departmentRepository.save(department);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
