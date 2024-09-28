package com.example.Company.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_employee;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "last_name", length = 60)
    private String last_name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "employmentdate")
    private Integer employmentdate;

    
    public Employee() {

    }

    // Getters
    public Long getId_employee() {
        return this.id_employee;
    }

    public String getName() {
        return this.name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getEmploymentdate() {
        return this.employmentdate;
    }

    // Setters
    public void setId_employee(Long id_employee) {
        this.id_employee = id_employee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmploymentdate(Integer employmentdate) {
        this.employmentdate = employmentdate;
    }
}


