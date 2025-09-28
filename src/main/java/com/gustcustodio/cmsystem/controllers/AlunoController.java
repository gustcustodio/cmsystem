package com.gustcustodio.cmsystem.controllers;

import com.gustcustodio.cmsystem.dtos.AlunoDTO;
import com.gustcustodio.cmsystem.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> findAll(Pageable pageable) {
        Page<AlunoDTO> alunoDTOS = alunoService.findAll(pageable);
        return ResponseEntity.ok(alunoDTOS);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO alunoDTO) {
        alunoDTO = alunoService.insert(alunoDTO);
        URI uri =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(alunoDTO.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(alunoDTO);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {
        alunoDTO = alunoService.update(id, alunoDTO);
        return ResponseEntity.ok(alunoDTO);
    }

}
