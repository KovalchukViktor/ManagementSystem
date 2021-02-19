package com.example.demo.service;

import com.example.demo.model.Department;

import java.util.ArrayList;

public interface DepartmentService {

    /**
     * Создает новый отдел
     * @param department - отдел для создания
     */
    void create(Department department);

    /**
     * Возвращает список всех имеющихся отделов
     * @return список отделов
     */
    ArrayList<Department> readAll();

    /**
     * Возвращает отдел по его ID
     * @param id - ID отдела
     * @return - отдел с заданным ID
     */
    Department read(int id);

    /**
     * Обновляет отдел с заданным ID
     * @param department - отдел в котором нужно обновить данные
     * @param id - id отдела которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Department department, int id);


    /**
     * Удаляет отдел с заданным ID
     * @param id - id отдела, который нужно удалить
     * @return - true если отдел был удален, иначе false
     */
    boolean delete(int id);
}
