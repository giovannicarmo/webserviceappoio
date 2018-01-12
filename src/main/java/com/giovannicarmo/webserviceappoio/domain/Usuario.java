package com.giovannicarmo.webserviceappoio.domain;

import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome, email, senha, telefone, foto;
    private Integer tipo;

    @OneToMany(mappedBy = "usuario")
    private List<Rotina> rotinas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<RecomendacaoMedica> recomendacoesMedicas = new ArrayList<>();

    @ManyToMany(mappedBy = "usuarios")
    private List<Crianca> criancas = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_remetente")
    private List<Mensagem> mensagens_remetente = new ArrayList<>();

    @OneToMany(mappedBy = "usuario_receptor")
    private List<Mensagem> mensagens_receptor = new ArrayList<>();

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

    public List<Rotina> getRotinas() {
        return rotinas;
    }

    public void setRotinas(List<Rotina> rotinas) {
        this.rotinas = rotinas;
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

    public List<Mensagem> getMensagens_remetente() {
        return mensagens_remetente;
    }

    public void setMensagens_remetente(List<Mensagem> mensagens_remetente) {
        this.mensagens_remetente = mensagens_remetente;
    }

    public List<Mensagem> getMensagens_receptor() {
        return mensagens_receptor;
    }

    public void setMensagens_receptor(List<Mensagem> mensagens_receptor) {
        this.mensagens_receptor = mensagens_receptor;
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
