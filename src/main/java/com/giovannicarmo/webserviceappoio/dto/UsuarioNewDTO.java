package com.giovannicarmo.webserviceappoio.dto;

import com.giovannicarmo.webserviceappoio.services.validation.UsuarioInsert;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import java.io.Serializable;

@UsuarioInsert
public class UsuarioNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo Obrigatório!")
    private String nome;

    @Column(unique=true)
    @NotEmpty(message = "Campo Obrigatório!")
    private String email;

    @NotEmpty(message = "Campo Obrigatório!")
    private String senha;

    private String telefone;

    private String tipo;

    public UsuarioNewDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
