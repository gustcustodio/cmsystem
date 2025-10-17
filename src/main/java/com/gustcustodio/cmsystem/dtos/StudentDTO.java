package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Registration;
import com.gustcustodio.cmsystem.entities.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    private Long id;

    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 10, max = 80, message = "Email precisa ter de 10 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String email;

    private Set<CourseDTO> courses = new HashSet<>();

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
        for (Registration registration : entity.getRegistrations()) {
            CourseDTO courseDTO = new CourseDTO(registration.getCourse());
            courses.add(courseDTO);
        }
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

    public Set<CourseDTO> getCourses() {
        return courses;
    }

}
