package com.giovannicarmo.webserviceappoio.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Mensagem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 2000)
    private String corpo;

    private String anexo;

   @ManyToOne
   @JoinColumn(name = "id_usuario_remetente")
   private Usuario usuario_remetente;

    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor")
    private Usuario usuario_receptor;

    public Mensagem(){}

    public Mensagem(Integer id, String corpo, String anexo, Usuario usuario_remetente, Usuario usuario_receptor) {

        this.id = id;
        this.corpo = corpo;
        this.anexo = anexo;
        this.usuario_remetente = usuario_remetente;
        this.usuario_receptor = usuario_receptor;
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

    public Usuario getUsuario_remetente() {
        return usuario_remetente;
    }

    public void setUsuario_remetente(Usuario usuario_remetente) {
        this.usuario_remetente = usuario_remetente;
    }

    public Usuario getUsuario_receptor() {
        return usuario_receptor;
    }

    public void setUsuario_receptor(Usuario usuario_receptor) {
        this.usuario_receptor = usuario_receptor;
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
