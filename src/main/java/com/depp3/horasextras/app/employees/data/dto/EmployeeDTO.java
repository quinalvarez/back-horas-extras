package com.depp3.horasextras.app.employees.data.dto;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String lastname;
    private Boolean isActive;

    public EmployeeDTO() {
        clear();
    }

    public EmployeeDTO(String name, String lastname, Boolean isActive) {
        this(null, name, lastname, isActive);
    }

    public EmployeeDTO(Long id, String name, String lastname, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.isActive = isActive;
    }

    private void clear() {
        id = null;
        name = "";
        lastname = "";
        isActive = true;
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
