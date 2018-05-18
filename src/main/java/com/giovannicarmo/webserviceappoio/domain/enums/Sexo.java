package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Sexo {

    MASCULINO ("Masculino"),
    FEMININO ("Feminino");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Sexo toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (Sexo x : Sexo.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}
