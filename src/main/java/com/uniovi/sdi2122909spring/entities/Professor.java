package com.uniovi.sdi2122909spring.entities;

public class Professor {

    private Long id;
    private String dni;
    private String department;

    public Professor() {}

    public Professor(Long id, String dni, String department) {
        this.id = id;
        this.dni = dni;
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

    @Override
    public String toString() {
        return "Professor{" +
                "dni='" + dni + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
