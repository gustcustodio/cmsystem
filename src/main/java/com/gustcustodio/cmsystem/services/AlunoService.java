package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.AlunoDTO;
import com.gustcustodio.cmsystem.entities.Aluno;
import com.gustcustodio.cmsystem.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        return new AlunoDTO(aluno);
    }

}
