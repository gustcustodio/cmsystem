package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Registration;
import com.gustcustodio.cmsystem.entities.StudentCoursePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, StudentCoursePK> {
}
