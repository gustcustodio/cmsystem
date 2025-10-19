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

import java.time.LocalDate;

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

    @Transactional
    public RegistrationDTO updateStudentCourse(Long studentId, Long oldCourseId, Long newCourseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno de ID " + studentId + " não encontrado"));

        Course oldCourse = courseRepository.findById(oldCourseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso de ID " + oldCourseId + " não encontrado"));

        StudentCoursePK oldStudentCoursePK = new StudentCoursePK();
        oldStudentCoursePK.setStudent(student);
        oldStudentCoursePK.setCourse(oldCourse);
        registrationRepository.deleteById(oldStudentCoursePK);

        Course newCourse = courseRepository.findById(newCourseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso de ID " + newCourseId + " não encontrado"));

        StudentCoursePK newStudentCoursePK = new StudentCoursePK();
        newStudentCoursePK.setStudent(student);
        newStudentCoursePK.setCourse(newCourse);

        Registration registration = new Registration(newStudentCoursePK.getStudent(), newStudentCoursePK.getCourse(), LocalDate.now());
        registrationRepository.save(registration);

        return new RegistrationDTO(registration);
    }

    public void delete(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno de ID " + studentId + " não encontrado"));

        Course oldCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso de ID " + courseId + " não encontrado"));

        StudentCoursePK oldStudentCoursePK = new StudentCoursePK();
        oldStudentCoursePK.setStudent(student);
        oldStudentCoursePK.setCourse(oldCourse);

        if (!registrationRepository.existsById(oldStudentCoursePK)) {
            throw new ResourceNotFoundException("Registro não encontrado");
        }

        registrationRepository.deleteById(oldStudentCoursePK);
    }

}
