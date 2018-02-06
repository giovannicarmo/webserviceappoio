package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class MensagemUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private MensagemUsuarioPK id = new MensagemUsuarioPK();

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataEnvio;

    public MensagemUsuario() {
    }

    public MensagemUsuario(Usuario usuarioRemetente, Usuario usuarioReceptor, Mensagem mensagem, Date dataEnvio) {

        id.setUsuarioRemetente(usuarioRemetente);
        id.setUsuarioReceptor(usuarioReceptor);
        id.setMensagem(mensagem);
        this.dataEnvio = dataEnvio;
    }

    @JsonIgnore
    public Usuario getUsuarioRemetente(){
        return id.getUsuarioRemetente();
    }

    @JsonIgnore
    public Usuario getUsuarioReceptor(){
        return id.getUsuarioRemetente();
    }

    @JsonIgnore
    public Mensagem getMensagem(){
        return id.getMensagem();
    }

    public MensagemUsuarioPK getId() {
        return id;
    }

    public void setId(MensagemUsuarioPK id) {
        this.id = id;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
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
