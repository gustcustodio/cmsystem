package com.gustcustodio.cmsystem.services;

import com.gustcustodio.cmsystem.dtos.AlunoDTO;
import com.gustcustodio.cmsystem.entities.Aluno;
import com.gustcustodio.cmsystem.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional
    public AlunoDTO insert(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return new AlunoDTO(aluno);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO alunoDTO) {
        try {
            Aluno aluno = alunoRepository.getReferenceById(id);
            aluno.setNome(alunoDTO.getNome());
            aluno.setEmail(alunoDTO.getEmail());
            aluno = alunoRepository.save(aluno);
            return new AlunoDTO(aluno);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Recurso não encontrado");
        }
    }

}
