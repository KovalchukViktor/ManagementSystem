package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Employees")
@Table(name = "employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employees {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "employeesIdSeq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeesIdSeq")
    private Integer id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "email")
    private String email;

    @Column (name = "position")
    private String position;

    @Column (name = "date_of_employment")
    private Date dateOfEmployment;

    @Column (name = "department_id")
    private Integer departmentId;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id;    }

    public String getFullName() {   return fullName;    }

    public void setFullName(String fullName) {  this.fullName = fullName;   }

    public Date getDateOfBirth() {  return dateOfBirth; }

    public void setDateOfBirth(Date dateOfBirth) {  this.dateOfBirth = dateOfBirth; }

    public String getPhoneNumber() {    return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) {    this.phoneNumber = phoneNumber; }

    public String getEmail() {  return email;   }

    public void setEmail(String email) {    this.email = email; }

    public String getPosition() {   return position;    }

    public void setPosition(String position) {  this.position = position;   }

    public Date getDateOfEmployment() { return dateOfEmployment;    }

    public void setDateOfEmployment(Date dateOfEmployment) {    this.dateOfEmployment = dateOfEmployment;   }

    public Integer getDepartmentId() { return departmentId; }

    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }
}
