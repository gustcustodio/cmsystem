package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.CourseDTO;
import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.repositories.CourseRepository;
import com.gustcustodio.cmsystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public CourseDTO findById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow();
        return new CourseDTO(course);
    }

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAll(Pageable pageable) {
        Page<Course> coursePage = courseRepository.findAll(pageable);
        return coursePage.map(CourseDTO::new);
    }

    @Transactional
    public CourseDTO insert(CourseDTO courseDTO) {
        Course course = new Course(courseDTO);
        course = courseRepository.save(course);
        return new CourseDTO(course);
    }

    @Transactional
    public CourseDTO update(Long id, CourseDTO courseDTO) {
        try {
            Course course = courseRepository.getReferenceById(id);
            course.setName(courseDTO.getName());
            course.setDescription(courseDTO.getDescription());
            course = courseRepository.save(course);
            return new CourseDTO(course);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        courseRepository.deleteById(id);
    }

}
