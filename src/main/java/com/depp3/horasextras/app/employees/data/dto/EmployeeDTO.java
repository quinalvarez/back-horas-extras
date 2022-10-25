package com.depp3.horasextras.app.employees.data.dto;

public class EmployeeDTO {

    private String dni;
    private String name;
    private String lastname;
    private String active;

    public EmployeeDTO() {
        clear();
    }

    public EmployeeDTO(String dni, String name, String lastname, Boolean isActive) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.active = isActive ? "ACTIVE" : "INACTIVE";
    }

    private void clear() {
        dni = "";
        name = "";
        lastname = "";
        active = "ACTIVE";
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
