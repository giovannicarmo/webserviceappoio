package com.giovannicarmo.webserviceappoio.domain;

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
    private Date data;
    private String atividades, obs;
    private Integer tipo, comportamento, interacao, humor, alimentacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

    public Rotina(){}

    public Rotina(Integer id, Date data, String atividades, String obs, TipoRotina tipo, Avaliacao comportamento,
                  Avaliacao interacao, Avaliacao humor, Avaliacao alimentacao, Usuario usuario, Crianca crianca) {
        this.id = id;
        this.data = data;
        this.atividades = atividades;
        this.obs = obs;
        this.tipo = tipo.getId();
        this.comportamento = comportamento.getId();
        this.interacao = interacao.getId();
        this.humor = humor.getId();
        this.alimentacao = alimentacao.getId();
        this.usuario = usuario;
        this.crianca = crianca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (!(o instanceof Rotina)) return false;
        Rotina rotina = (Rotina) o;
        return Objects.equals(getId(), rotina.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
