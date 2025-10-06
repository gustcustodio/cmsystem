package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.entities.Registration;

import java.util.HashSet;
import java.util.Set;

public class CourseDetailsDTO {


    private Long id;
    private String name;
    private String description;

    private Set<StudentSummaryDTO> students = new HashSet<>();

    public CourseDetailsDTO() {
    }

    public CourseDetailsDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public CourseDetailsDTO(Course entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        for (Registration registration : entity.getRegistrations()) {
            StudentSummaryDTO studentSummaryDTO = new StudentSummaryDTO(registration.getStudent());
            students.add(studentSummaryDTO);
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

    public Set<StudentSummaryDTO> getStudents() {
        return students;
    }


}
