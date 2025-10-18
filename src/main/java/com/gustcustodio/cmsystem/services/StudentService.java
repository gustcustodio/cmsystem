package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.CourseDTO;
import com.gustcustodio.cmsystem.dtos.StudentDTO;
import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.entities.Registration;
import com.gustcustodio.cmsystem.entities.Student;
import com.gustcustodio.cmsystem.repositories.CourseRepository;
import com.gustcustodio.cmsystem.repositories.RegistrationRepository;
import com.gustcustodio.cmsystem.repositories.StudentRepository;
import com.gustcustodio.cmsystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Transactional(readOnly = true)
    public StudentDTO findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno de ID " + id + " não encontrado"));
        return new StudentDTO(student);
    }

    @Transactional(readOnly = true)
    public Page<StudentDTO> findStudentsWithCourses(Pageable pageable) {
        Page<Student> studentPage = studentRepository.findStudentsWithCourses(pageable);
        return studentPage.map(StudentDTO::new);
    }

    @Transactional
    public StudentDTO insert(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        for (CourseDTO courseDTO : studentDTO.getCourses()) {
            Course course = courseRepository.getReferenceById(courseDTO.getId());
            Registration registration = new Registration(student, course, LocalDate.now());
            student.getRegistrations().add(registration);
        }

        studentRepository.save(student);
        registrationRepository.saveAll(student.getRegistrations());

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
            throw new ResourceNotFoundException("Aluno de ID " + id + " não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno de ID " + id + " não encontrado");
        }

        studentRepository.deleteById(id);
    }

}
