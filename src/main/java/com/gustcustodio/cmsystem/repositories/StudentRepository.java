package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
