package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.StudentDTO;
import com.gustcustodio.cmsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.findById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping
    public ResponseEntity<Page<StudentDTO>> findAll(Pageable pageable) {
        Page<StudentDTO> studentDTOS = studentService.findAll(pageable);
        return ResponseEntity.ok(studentDTOS);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> insert(@RequestBody StudentDTO studentDTO) {
        studentDTO = studentService.insert(studentDTO);
        URI uri =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(studentDTO.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(studentDTO);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        studentDTO = studentService.update(id, studentDTO);
        return ResponseEntity.ok(studentDTO);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<StudentDTO> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
