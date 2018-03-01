package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class MensagemUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataEnvio;

    @Column(length = 2000)
    private String corpo;

    private String anexo;

    @ManyToOne
    @JoinColumn(name = "id_usuario_remetente")
    private Usuario usuarioRemetente;

    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor")
    private Usuario usuarioReceptor;

    public MensagemUsuario() {
    }

    public MensagemUsuario(Integer id, Usuario usuarioRemetente, Usuario usuarioReceptor,
                           Date dataEnvio, String corpo, String anexo) {
        this.id = id;
        this.usuarioRemetente = (usuarioRemetente);
        this.usuarioReceptor = (usuarioReceptor);
        this.dataEnvio = dataEnvio;
        this.corpo = corpo;
        this.anexo = anexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Usuario getUsuarioRemetente() {
        return usuarioRemetente;
    }

    public void setUsuarioRemetente(Usuario usuarioRemetente) {
        this.usuarioRemetente = usuarioRemetente;
    }

    public Usuario getUsuarioReceptor() {
        return usuarioReceptor;
    }

    public void setUsuarioReceptor(Usuario usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
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
        if (!(o instanceof MensagemUsuario)) return false;
        MensagemUsuario that = (MensagemUsuario) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDataEnvio(), that.getDataEnvio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataEnvio());
    }
}
