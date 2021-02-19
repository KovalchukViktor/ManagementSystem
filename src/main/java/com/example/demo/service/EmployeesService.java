package com.example.demo.service;

import com.example.demo.model.Employees;

import java.util.ArrayList;

public interface EmployeesService {

    /**
     * Создает нового сотрудника
     * @param employees - сотрудник для создания
     */
    void create(Employees employees);

    /**
     * Возвращает список всех имеющихся сотрудников
     * @return список сотрудников
     */
    ArrayList<Employees> readAll();

    /**
     * Возвращает сотрудника по его ID
     * @param id - ID сотрудника
     * @return - объект сотрудника с заданным ID
     */
    Employees read(int id);

    /**
     * Обновляет сотрудника с заданным ID,
     * в соответствии с переданным сотрудником
     * @param employees - сотрудник в соответсвии с которым нужно обновить данные
     * @param id - id сотрудника которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Employees employees, int id);

    /**
     * Удаляет сотрудника с заданным ID
     * @param id - id сотрудника, которого нужно удалить
     * @return - true если сотрудник был удален, иначе false
     */
    boolean delete(int id);
}

