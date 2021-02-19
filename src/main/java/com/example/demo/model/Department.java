package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;




@Entity(name = "Department")
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "departmentsIdSeq", sequenceName = "departments_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmenstIdSeq")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column (name = "phone_number_department")
    private String phoneNumberDepartment;

    @Column (name = "date_of_formation")
    private Date dateOfFormation;

    @OneToMany(mappedBy = "departmentId")
    private List<Employees> employeesSet = new ArrayList<>();

    public Integer getId() {  return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumberDepartment() {
        return phoneNumberDepartment;
    }

    public void setPhoneNumberDepartment(String phoneNumberDepartment) { this.phoneNumberDepartment = phoneNumberDepartment; }

    public Date getDateOfFormation() {
        return dateOfFormation;
    }

    public void setDateOfFormation(Date dateOfFormation) {
        this.dateOfFormation = dateOfFormation;
    }

    public List<Employees> getEmployeesSet() {
        return employeesSet;
    }

    public void setEmployeesSet(List<Employees> employeesSet) {
        this.employeesSet = employeesSet;
    }
}
