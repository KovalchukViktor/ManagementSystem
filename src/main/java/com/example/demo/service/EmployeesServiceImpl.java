package com.example.demo.service;

import com.example.demo.model.Employees;
import com.example.demo.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public void create(Employees employees) {employeesRepository.save(employees);}

    @Override
    public ArrayList<Employees> readAll() {return (ArrayList<Employees>) employeesRepository.findAll(); }

    @Override
    public Employees read(int id) {return employeesRepository.getOne(id);   }

    @Override
    public boolean update(Employees employees, int id) {
        if (employeesRepository.existsById(id)) {
            employees.setId(id);
            employeesRepository.save(employees);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (employeesRepository.existsById(id)) {
            employeesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
