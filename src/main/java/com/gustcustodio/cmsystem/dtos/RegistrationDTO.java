package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Registration;

import java.time.LocalDate;

public class RegistrationDTO {

    private LocalDate registrationDate;
    private String studentName;
    private String studentEmail;
    private String courseName;
    private String courseDescription;

    public RegistrationDTO() {
    }

    public RegistrationDTO(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public RegistrationDTO(Registration entity) {
        this.registrationDate = entity.getRegistrationDate();
        this.studentName = entity.getStudent().getName();
        this.studentEmail = entity.getStudent().getEmail();
        this.courseName = entity.getCourse().getName();
        this.courseDescription = entity.getCourse().getDescription();
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

}
