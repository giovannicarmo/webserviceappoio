package com.giovannicarmo.webserviceappoio.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CriancaNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo Obrigatório!")
    private String nome;

    private String colegio;

    @NotEmpty(message = "Campo Obrigatório!")
    private Date dataNascimento;

    @NotEmpty(message = "Campo Obrigatório!")
    private Integer sexo;

    private Integer categoriaTea;

    private List<Integer> usuariosID;

    public CriancaNewDTO() {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public Integer getCategoriaTea() {
        return categoriaTea;
    }

    public void setCategoriaTea(Integer categoriaTea) {
        this.categoriaTea = categoriaTea;
    }

    public List<Integer> getUsuariosID() {
        return usuariosID;
    }

    public void setUsuariosID(List<Integer> usuariosID) {
        this.usuariosID = usuariosID;
    }
}
