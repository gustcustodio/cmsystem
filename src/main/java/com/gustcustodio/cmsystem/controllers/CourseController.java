package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.CourseDTO;
import com.gustcustodio.cmsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.findById(id);
        return ResponseEntity.ok(courseDTO);
    }

}
