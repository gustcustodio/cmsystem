package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.RegistrationDTO;
import com.gustcustodio.cmsystem.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/students/{studentId}/courses/{courseId}")
    public ResponseEntity<RegistrationDTO> findByStudentAndCourseId(@PathVariable Long studentId, @PathVariable Long courseId) {
        RegistrationDTO registrationDTO = registrationService.findByStudentAndCourseId(studentId, courseId);
        return ResponseEntity.ok(registrationDTO);
    }

}
