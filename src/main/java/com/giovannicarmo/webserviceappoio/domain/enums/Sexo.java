package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Sexo {

    MASCULINO (1, "Masculino"),
    FEMININO (2, "Feminino");

    private int id;
    private String descricao;

    Sexo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Sexo toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (Sexo x : Sexo.values()) {

            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + id);
    }
}
