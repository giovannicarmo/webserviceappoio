package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Avaliacao {

    RUIM (0, "Ruim"),
    REGULAR (1, "Regular"),
    BOM (2, "Bom"),
    OTIMO (3, "Otimo");

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
