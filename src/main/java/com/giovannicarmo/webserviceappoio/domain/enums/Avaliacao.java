package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Avaliacao {

    RUIM ("Ruim"),
    REGULAR ("Regular"),
    BOM ("Bom"),
    OTIMO ("Otimo");

    private String descricao;

    Avaliacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Avaliacao toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (Avaliacao x : Avaliacao.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}
