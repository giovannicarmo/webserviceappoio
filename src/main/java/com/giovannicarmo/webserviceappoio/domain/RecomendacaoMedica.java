package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class RecomendacaoMedica implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2000)
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

    public RecomendacaoMedica(){}

    public RecomendacaoMedica(Integer id, String observacao, Usuario usuario, Crianca crianca) {
        this.id = id;
        this.observacao = observacao;
        this.usuario = usuario;
        this.crianca = crianca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    public void setCrianca(Crianca crianca) {
        this.crianca = crianca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecomendacaoMedica)) return false;
        RecomendacaoMedica that = (RecomendacaoMedica) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
