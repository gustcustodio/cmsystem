package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Course;

public class CourseDTO {

    private Long id;
    private String name;
    private String description;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CourseDTO(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
