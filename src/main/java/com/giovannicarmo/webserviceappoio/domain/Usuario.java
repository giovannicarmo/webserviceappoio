package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giovannicarmo.webserviceappoio.domain.enums.Profile;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoUsuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String senha;

    private String telefone;
    private Integer tipo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PERFIS")
    private Set<Integer> profiles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<RecomendacaoMedica> recomendacoesMedicas = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "usuarios")
    private List<Crianca> criancas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private Set<Rotina> rotinas = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioRemetente")
    private Set<MensagemUsuario> usuariosRemetente = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "usuarioReceptor")
    private Set<MensagemUsuario> usuariosReceptor = new HashSet<>();

    public Usuario(){ addProfile(Profile.CLIENT); }

    public Usuario(String nome, String email, String senha, String telefone, TipoUsuario tipo) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipo = (tipo == null) ? null : tipo.getId();
        addProfile(Profile.CLIENT);
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

    public TipoUsuario getTipo() {
        return TipoUsuario.toEnum(tipo);
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo.getId();
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getId());
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
