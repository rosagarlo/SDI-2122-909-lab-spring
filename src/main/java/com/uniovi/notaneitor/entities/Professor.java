package com.uniovi.notaneitor.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

    @Id
    @GeneratedValue
    private Long id;
    private String dni;
    private String name;
    private String lastName;
    private String department;

    public Professor() {}

    public Professor(Long id, String dni, String name, String lastName, String department) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "dni='" + dni + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
