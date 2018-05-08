package com.giovannicarmo.webserviceappoio.dto;

import com.giovannicarmo.webserviceappoio.domain.Usuario;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;

import java.io.Serializable;


public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private TipoUsuario tipo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario object) {
        id = object.getId();
        nome = object.getNome();
        email = object.getEmail();
        telefone = object.getTelefone();
        tipo = object.getTipo();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
