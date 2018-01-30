package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giovannicarmo.webserviceappoio.domain.enums.Avaliacao;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoRotina;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rotina implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RotinaPK id = new RotinaPK();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @Column(length = 2000)
    private String atividades;

    @Column(length = 2000)
    private String obs;

    private Integer tipo;
    private Integer comportamento;
    private Integer interacao;
    private Integer humor;
    private Integer alimentacao;

    public Rotina() {
    }

    public Rotina(Usuario usuario, Crianca crianca, Date data, String atividades, String obs, TipoRotina tipo,
                  Avaliacao comportamento, Avaliacao interacao, Avaliacao humor, Avaliacao alimentacao) {
        id.setUsuario(usuario);
        id.setCrianca(crianca);
        this.data = data;
        this.atividades = atividades;
        this.obs = obs;
        this.tipo = tipo.getId();
        this.comportamento = comportamento.getId();
        this.interacao = interacao.getId();
        this.humor = humor.getId();
        this.alimentacao = alimentacao.getId();
    }

    @JsonIgnore
    public Usuario getUsuario() {
        return id.getUsuario();
    }

    @JsonIgnore
    public Crianca getCrianca() {
        return id.getCrianca();
    }

    public void setId(RotinaPK id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public TipoRotina getTipo() {
        return TipoRotina.toEnum(tipo);
    }

    public void setTipo(TipoRotina tipo) {
        this.tipo = tipo.getId();
    }

    public Avaliacao getComportamento() {
        return Avaliacao.toEnum(comportamento);
    }

    public void setComportamento(Avaliacao comportamento) {
        this.comportamento = comportamento.getId();
    }

    public Avaliacao getInteracao() {
        return Avaliacao.toEnum(interacao);
    }

    public void setInteracao(Avaliacao interacao) {
        this.interacao = interacao.getId();
    }

    public Avaliacao getHumor() {
        return Avaliacao.toEnum(humor);
    }

    public void setHumor(Avaliacao humor) {
        this.humor = humor.getId();
    }

    public Avaliacao getAlimentacao() {
        return Avaliacao.toEnum(alimentacao);
    }

    public void setAlimentacao(Avaliacao alimentacao) {
        this.alimentacao = alimentacao.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rotina)) return false;
        Rotina rotina = (Rotina) o;
        return Objects.equals(id, rotina.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}