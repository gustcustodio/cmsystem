package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Student;

public class StudentSummaryDTO {

    private Long id;
    private String name;
    private String email;

    public StudentSummaryDTO() {
    }

    public StudentSummaryDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public StudentSummaryDTO(Student entity) {
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
