package com.giovannicarmo.webserviceappoio.domain;

import java.io.Serializable;
import java.util.Objects;

public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String corpo, anexo;

    public Mensagem(){}

    public Mensagem(Integer id, String corpo, String anexo) {

        this.id = id;
        this.corpo = corpo;
        this.anexo = anexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensagem)) return false;
        Mensagem mensagem = (Mensagem) o;
        return Objects.equals(getId(), mensagem.getId()) &&
                Objects.equals(getCorpo(), mensagem.getCorpo()) &&
                Objects.equals(getAnexo(), mensagem.getAnexo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCorpo(), getAnexo());
    }
}
