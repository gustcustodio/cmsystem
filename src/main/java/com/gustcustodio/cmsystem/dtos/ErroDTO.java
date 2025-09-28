package com.gustcustodio.cmsystem.dtos;

import java.time.Instant;

public class ErroDTO {

    private Instant timestamp;
    private Integer status;
    private String erro;
    private String caminho;

    public ErroDTO() {
    }

    public ErroDTO(Instant timestamp, Integer status, String erro, String caminho) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.caminho = caminho;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getCaminho() {
        return caminho;
    }

}
