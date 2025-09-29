package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Student;

public class StudentDTO {

    private Long id;
    private String name;
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public StudentDTO(Student entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
