package com.gustcustodio.cmsystem.entities;

import com.gustcustodio.cmsystem.dtos.StudentDTO;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "id.student")
    private Set<Registration> registrations = new HashSet<>();

    public Student() {
    }

    public Student(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Student(StudentDTO studentDTO) {
        this.id = studentDTO.getId();
        this.name = studentDTO.getName();
        this.email = studentDTO.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Registration> getRegistrations() {
        return registrations;
    }

}
