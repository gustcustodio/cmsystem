package com.gustcustodio.cmsystem.repositories;

import com.gustcustodio.cmsystem.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
