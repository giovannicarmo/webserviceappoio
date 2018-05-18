package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giovannicarmo.webserviceappoio.domain.enums.CategoriaTea;
import com.giovannicarmo.webserviceappoio.domain.enums.Sexo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Crianca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String colegio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    private String sexo;
    private String categoriaTea;

    @OneToMany(mappedBy = "crianca")
    private List<RecomendacaoMedica> recomendacoesMedicas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CRIANCA_USUARIO",
            joinColumns = @JoinColumn(name = "id_crianca"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    private List<Usuario> usuarios = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "crianca")
    private Set<Rotina> rotinas = new HashSet<>();

    public Crianca(){}

    public Crianca(Integer id, String nome, String colegio, Date dataNascimento, Sexo sexo, CategoriaTea categoriaTea) {
        this.id = id;
        this.nome = nome;
        this.colegio = colegio;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo.getDescricao();
        this.categoriaTea = categoriaTea.getDescricao();
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return Sexo.toEnum(sexo);
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo.getDescricao();
    }

    public CategoriaTea getCategoriaTea() {
        return CategoriaTea.toEnum(categoriaTea);
    }

    public void setCategoriaTea(CategoriaTea categoriaTea) {
        this.categoriaTea = categoriaTea.getDescricao();
    }

    public List<RecomendacaoMedica> getRecomendacoesMedicas() {
        return recomendacoesMedicas;
    }

    public void setRecomendacoesMedicas(List<RecomendacaoMedica> recomendacoesMedicas) {
        this.recomendacoesMedicas = recomendacoesMedicas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Rotina> getRotinas() {
        return rotinas;
    }

    public void setRotinas(Set<Rotina> rotinas) {
        this.rotinas = rotinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Crianca)) return false;
        Crianca crianca = (Crianca) o;
        return Objects.equals(getId(), crianca.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
