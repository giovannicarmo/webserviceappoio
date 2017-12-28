package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Avaliacao {

    RUIM (1, "Ruim"),
    REGULAR (2, "Regular"),
    BOM (3, "Bom"),
    OTIMO (4, "Otimo");

    private int id;
    private String descricao;

    Avaliacao(int id, String descricao) {
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

    public static Avaliacao toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (Avaliacao x : Avaliacao.values()) {

            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + id);
    }
}
