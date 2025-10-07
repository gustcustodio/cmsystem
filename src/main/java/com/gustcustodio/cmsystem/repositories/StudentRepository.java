package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
              SELECT DISTINCT obj\s
              FROM Student obj\s
              LEFT JOIN FETCH obj.registrations reg\s
              LEFT JOIN FETCH reg.id.course\s
            \s""",
            countQuery = "SELECT COUNT(obj) FROM Student obj")
    Page<Student> findStudentsWithCourses(Pageable pageable);

}
