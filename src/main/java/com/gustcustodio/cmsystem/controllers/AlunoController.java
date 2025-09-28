package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.AlunoDTO;
import com.gustcustodio.cmsystem.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        AlunoDTO alunoDTO = alunoService.findById(id);
        return ResponseEntity.ok(alunoDTO);
    }

}
