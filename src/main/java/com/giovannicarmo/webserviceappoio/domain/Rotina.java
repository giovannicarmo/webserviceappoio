package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.giovannicarmo.webserviceappoio.domain.enums.Avaliacao;
import com.giovannicarmo.webserviceappoio.domain.enums.TipoRotina;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rotina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataCriacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data;

    @Column(length = 2000)
    private String atividades;

    @Column(length = 2000)
    private String obs;

    private String tipo;
    private String comportamento;
    private String interacao;
    private String humor;
    private String alimentacao;

    public Rotina() {
    }

    public Rotina(Usuario usuario, Crianca crianca, Date dataCriacao, Date data, TipoRotina tipo, String atividades, String obs,
                  Avaliacao comportamento, Avaliacao interacao, Avaliacao humor, Avaliacao alimentacao) {
        this.usuario = (usuario);
        this.crianca = (crianca);
        this.dataCriacao = dataCriacao;
        this.data = data;
        this.tipo = tipo.getDescricao();
        this.atividades = atividades;
        this.obs = obs;
        this.comportamento = comportamento.getDescricao();
        this.interacao = interacao.getDescricao();
        this.humor = humor.getDescricao();
        this.alimentacao = alimentacao.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
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
        this.tipo = tipo.getDescricao();
    }

    public Avaliacao getComportamento() {
        return Avaliacao.toEnum(comportamento);
    }

    public void setComportamento(Avaliacao comportamento) {
        this.comportamento = comportamento.getDescricao();
    }

    public Avaliacao getInteracao() {
        return Avaliacao.toEnum(interacao);
    }

    public void setInteracao(Avaliacao interacao) {
        this.interacao = interacao.getDescricao();
    }

    public Avaliacao getHumor() {
        return Avaliacao.toEnum(humor);
    }

    public void setHumor(Avaliacao humor) {
        this.humor = humor.getDescricao();
    }

    public Avaliacao getAlimentacao() {
        return Avaliacao.toEnum(alimentacao);
    }

    public void setAlimentacao(Avaliacao alimentacao) {
        this.alimentacao = alimentacao.getDescricao();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rotina)) return false;
        Rotina rotina = (Rotina) o;
        return Objects.equals(getId(), rotina.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}