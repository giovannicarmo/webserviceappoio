package com.giovannicarmo.webserviceappoio.dto;

import com.giovannicarmo.webserviceappoio.domain.Crianca;

import java.io.Serializable;

public class CriancaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String colegio;

    public CriancaDTO() {
    }

    public CriancaDTO(Crianca object) {
        id = object.getId();
        nome = object.getNome();
        colegio = object.getColegio();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }
}
