package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CourseDTO {

    private Long id;

    @Size(min = 10, max = 80, message = "Nome precisa ter de 10 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @Size(min = 10, max = 80, message = "Descrição precisa ter de 10 a 80 caracteres")
    @NotBlank(message = "Campo requerido")
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
