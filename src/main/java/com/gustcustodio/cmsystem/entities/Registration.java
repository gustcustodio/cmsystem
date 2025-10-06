package com.gustcustodio.cmsystem.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_registration")
public class Registration {

    @EmbeddedId
    private StudentCoursePK id = new StudentCoursePK();

    private LocalDate registrationDate;

    public Registration() {
    }

    public Registration(Student student, Course course, LocalDate registrationDate) {
        this.id.setStudent(student);
        this.id.setCourse(course);
        this.registrationDate = registrationDate;
    }

    public Student getStudent() {
        return id.getStudent();
    }

    public void setStudent(Student student) {
        id.setStudent(student);
    }

    public Course getCourse() {
        return id.getCourse();
    }

    public void setCourse(Course course) {
        id.setCourse(course);
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
