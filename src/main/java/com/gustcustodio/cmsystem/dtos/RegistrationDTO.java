package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Registration;

import java.time.LocalDate;

public class RegistrationDTO {

    private Long id;
    private LocalDate registrationDate;

    public RegistrationDTO() {
    }

    public RegistrationDTO(Long id, LocalDate registrationDate) {
        this.id = id;
        this.registrationDate = registrationDate;
    }

    public RegistrationDTO(Registration registration) {
        this.id = registration.getId();
        this.registrationDate = registration.getRegistrationDate();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

}
