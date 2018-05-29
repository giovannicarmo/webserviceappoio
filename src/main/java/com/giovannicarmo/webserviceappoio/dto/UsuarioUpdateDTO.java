package com.giovannicarmo.webserviceappoio.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class UsuarioUpdateDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo Obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo Obrigatório!")
    private String senha;

    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
