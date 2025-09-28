package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.AlunoDTO;
import com.gustcustodio.cmsystem.entities.Aluno;
import com.gustcustodio.cmsystem.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        return new AlunoDTO(aluno);
    }

    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAll(Pageable pageable) {
        Page<Aluno> alunoPage = alunoRepository.findAll(pageable);
        return alunoPage.map(AlunoDTO::new);
    }

}
