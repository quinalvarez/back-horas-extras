package com.depp3.horasextras.app.employees.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    private String dni;
    private String name;
    private String lastname;
    private Boolean isActive;

    public Employee() {}

    public Employee(String dni, String name, String lastname, Boolean isActive) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.isActive = isActive;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
