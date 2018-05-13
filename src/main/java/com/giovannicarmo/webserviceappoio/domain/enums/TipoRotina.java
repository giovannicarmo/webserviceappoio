package com.giovannicarmo.webserviceappoio.domain.enums;

public enum TipoRotina {

    CASA (0, "Casa"),
    ESCOLA (1, "Escola");

    private int id;
    private String descricao;

    TipoRotina(int id, String descricao) {
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

    public static TipoRotina toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (TipoRotina x : TipoRotina.values()) {

            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + id);
    }
}
