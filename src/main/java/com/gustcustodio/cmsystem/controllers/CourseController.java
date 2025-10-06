package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.CourseDTO;
import com.gustcustodio.cmsystem.dtos.CourseDetailsDTO;
import com.gustcustodio.cmsystem.dtos.StudentDTO;
import com.gustcustodio.cmsystem.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDetailsDTO> findById(@PathVariable Long id) {
        CourseDetailsDTO courseDetailsDTO = courseService.findById(id);
        return ResponseEntity.ok(courseDetailsDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> findAll(Pageable pageable) {
        Page<CourseDTO> courseDTOS = courseService.findAll(pageable);
        return ResponseEntity.ok(courseDTOS);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@RequestBody CourseDTO courseDTO) {
        courseDTO = courseService.insert(courseDTO);
        URI uri =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(courseDTO.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(courseDTO);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        courseDTO = courseService.update(id, courseDTO);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
