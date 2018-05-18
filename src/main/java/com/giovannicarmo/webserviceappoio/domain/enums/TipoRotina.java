package com.giovannicarmo.webserviceappoio.domain.enums;

public enum TipoRotina {

    CASA ("Casa"),
    ESCOLA ("Escola");

    private String descricao;

    TipoRotina(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TipoRotina toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (TipoRotina x : TipoRotina.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}
