package com.giovannicarmo.webserviceappoio.dto;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


public class UsuarioNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Campo Obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo Obrigatório!")
    private String email;

    @NotEmpty(message = "Campo Obrigatório!")
    private String senha;

    private String telefone;

    private String foto;

    @NotEmpty(message = "Campo Obrigatório!")
    private Integer tipo;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
}
