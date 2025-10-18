package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.RegistrationDTO;
import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.entities.Registration;
import com.gustcustodio.cmsystem.entities.Student;
import com.gustcustodio.cmsystem.entities.StudentCoursePK;
import com.gustcustodio.cmsystem.repositories.CourseRepository;
import com.gustcustodio.cmsystem.repositories.RegistrationRepository;
import com.gustcustodio.cmsystem.repositories.StudentRepository;
import com.gustcustodio.cmsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    @Transactional(readOnly = true)
    public RegistrationDTO findByStudentAndCourseId(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno de ID " + studentId + " não encontrado"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso de ID " + courseId + " não encontrado"));

        StudentCoursePK studentCoursePK = new StudentCoursePK();
        studentCoursePK.setStudent(student);
        studentCoursePK.setCourse(course);

        Registration registration = registrationRepository.findById(studentCoursePK).orElseThrow();

        return new RegistrationDTO(registration);
    }

}
