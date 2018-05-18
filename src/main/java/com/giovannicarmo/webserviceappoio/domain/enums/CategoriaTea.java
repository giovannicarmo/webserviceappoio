package com.giovannicarmo.webserviceappoio.domain.enums;

public enum CategoriaTea {

    GRAVIDADE1 ("Gravidade 1"),
    GRAVIDADE2 ("Gravidade 2"),
    GRAVIDADE3 ("Gravidade 3");

    private String descricao;

    CategoriaTea(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static CategoriaTea toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (CategoriaTea x : CategoriaTea.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}
