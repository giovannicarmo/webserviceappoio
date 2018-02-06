package com.giovannicarmo.webserviceappoio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MensagemUsuarioPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario_remetente")
    private Usuario usuarioRemetente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario_receptor")
    private Usuario usuarioReceptor;

    @ManyToOne
    @JoinColumn(name = "id_mensagem")
    private Mensagem mensagem;

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

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MensagemUsuarioPK)) return false;
        MensagemUsuarioPK that = (MensagemUsuarioPK) o;
        return Objects.equals(getUsuarioRemetente(), that.getUsuarioRemetente()) &&
                Objects.equals(getUsuarioReceptor(), that.getUsuarioReceptor()) &&
                Objects.equals(getMensagem(), that.getMensagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuarioRemetente(), getUsuarioReceptor(), getMensagem());
    }
}
