package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.StudentDTO;
import com.gustcustodio.cmsystem.entities.Student;
import com.gustcustodio.cmsystem.repositories.StudentRepository;
import com.gustcustodio.cmsystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow();
        return new StudentDTO(student);
    }

    @Transactional(readOnly = true)
    public Page<StudentDTO> findStudentsWithCourses(Pageable pageable) {
        Page<Student> studentPage = studentRepository.findStudentsWithCourses(pageable);
        return studentPage.map(StudentDTO::new);
    }

    @Transactional
    public StudentDTO insert(StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        student = studentRepository.save(student);
        return new StudentDTO(student);
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO studentDTO) {
        try {
            Student student = studentRepository.getReferenceById(id);
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student = studentRepository.save(student);
            return new StudentDTO(student);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        studentRepository.deleteById(id);
    }

}
