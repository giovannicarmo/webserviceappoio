package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String foto;
    private Integer tipo;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<RecomendacaoMedica> recomendacoesMedicas = new ArrayList<>();

    @ManyToMany(mappedBy = "usuarios")
    private List<Crianca> criancas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.usuario")
    private Set<Rotina> rotinas = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.usuarioRemetente")
    private Set<MensagemUsuario> usuariosRemetente = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.usuarioReceptor")
    private Set<MensagemUsuario> usuariosReceptor = new HashSet<>();

    public Usuario(){}

    public Usuario(Integer id, String nome, String email, String senha, String telefone, String foto, TipoUsuario tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.foto = foto;
        this.tipo = tipo.getId();
    }

    @JsonIgnore
    public List<Crianca> getRotinaCriancas() {
        List<Crianca> list = new ArrayList<>();
        for (Rotina x : rotinas) {
            list.add(x.getCrianca());
        }
        return list;
    }

    @JsonIgnore
    public List<Usuario> getMensagemUsuarios() {
        List<Usuario> list = new ArrayList<>();
        for (MensagemUsuario x : usuariosReceptor) {
            list.add(x.getUsuarioRemetente());
        }
        return list;
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

    public TipoUsuario getTipo() {
        return TipoUsuario.toEnum(tipo);
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo.getId();
    }

    public List<RecomendacaoMedica> getRecomendacoesMedicas() {
        return recomendacoesMedicas;
    }

    public void setRecomendacoesMedicas(List<RecomendacaoMedica> recomendacoesMedicas) {
        this.recomendacoesMedicas = recomendacoesMedicas;
    }

    public List<Crianca> getCriancas() {
        return criancas;
    }

    public void setCriancas(List<Crianca> criancas) {
        this.criancas = criancas;
    }

    public Set<Rotina> getRotinas() {
        return rotinas;
    }

    public void setRotinas(Set<Rotina> rotinas) {
        this.rotinas = rotinas;
    }

    public Set<MensagemUsuario> getUsuariosRemetente() {
        return usuariosRemetente;
    }

    public void setUsuariosRemetente(Set<MensagemUsuario> usuariosRemetente) {
        this.usuariosRemetente = usuariosRemetente;
    }

    public Set<MensagemUsuario> getUsuariosReceptor() {
        return usuariosReceptor;
    }

    public void setUsuariosReceptor(Set<MensagemUsuario> usuariosReceptor) {
        this.usuariosReceptor = usuariosReceptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(getId(), usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
