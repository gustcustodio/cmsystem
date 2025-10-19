package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.RegistrationDTO;
import com.gustcustodio.cmsystem.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(value = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<RegistrationDTO> findByStudentAndCourseId(@PathVariable Long studentId, @PathVariable Long courseId) {
        RegistrationDTO registrationDTO = registrationService.findByStudentAndCourseId(studentId, courseId);
        return ResponseEntity.ok(registrationDTO);
    }

    @PostMapping(value = "/student/{studentId}/oldCourse/{oldCourseId}/newCourse/{newCourseId}")
    public ResponseEntity<RegistrationDTO> updateStudentCourse(@PathVariable Long studentId, @PathVariable Long oldCourseId, @PathVariable Long newCourseId) {
        RegistrationDTO registrationDTO = registrationService.updateStudentCourse(studentId, oldCourseId, newCourseId);
        return ResponseEntity.ok(registrationDTO);
    }

    @DeleteMapping(value = "/student/{studentId}/course/{courseId}")
    public ResponseEntity<RegistrationDTO> delete(@PathVariable Long studentId, @PathVariable Long courseId) {
        registrationService.delete(studentId, courseId);
        return ResponseEntity.noContent().build();
    }

}
