package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
