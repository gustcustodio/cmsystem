package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.entities.Registration;

import java.util.HashSet;
import java.util.Set;

public class CourseDTO {

    private Long id;
    private String name;
    private String description;

    private Set<RegistrationDTO> registrations = new HashSet<>();

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
        for (Registration registration : entity.getRegistrations()) {
            registrations.add(new RegistrationDTO(registration));
        }
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

    public Set<RegistrationDTO> getRegistrations() {
        return registrations;
    }

}
