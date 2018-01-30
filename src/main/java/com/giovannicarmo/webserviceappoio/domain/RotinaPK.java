package com.giovannicarmo.webserviceappoio.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RotinaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_crianca")
    private Crianca crianca;

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
        if (!(o instanceof RotinaPK)) return false;
        RotinaPK rotinaPK = (RotinaPK) o;
        return Objects.equals(getUsuario(), rotinaPK.getUsuario()) &&
                Objects.equals(getCrianca(), rotinaPK.getCrianca());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsuario(), getCrianca());
    }
}
