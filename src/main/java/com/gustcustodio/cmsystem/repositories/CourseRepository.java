package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query(value = """
              SELECT DISTINCT obj\s
              FROM Course obj\s
              LEFT JOIN FETCH obj.registrations reg\s
              LEFT JOIN FETCH reg.id.student\s
            \s""",
            countQuery = "SELECT COUNT(obj) FROM Course obj")
    Page<Course> findCourseWithStudents(Pageable pageable);

}
