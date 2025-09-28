package com.gustcustodio.cmsystem.dtos;

import com.gustcustodio.cmsystem.entities.Aluno;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public AlunoDTO(Aluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
