package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.CourseDTO;
import com.gustcustodio.cmsystem.entities.Course;
import com.gustcustodio.cmsystem.repositories.CourseRepository;
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

}
