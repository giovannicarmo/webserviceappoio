package com.giovannicarmo.webserviceappoio.domain.enums;

public enum CategoriaTea {

    GRAVIDADE1 (0, "Gravidade 1"),
    GRAVIDADE2 (1, "Gravidade 2"),
    GRAVIDADE3 (2, "Gravidade 3");

    private int id;
    private String descricao;

    CategoriaTea(int id, String descricao) {
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

    public static CategoriaTea toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (CategoriaTea x : CategoriaTea.values()) {

            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + id);
    }
}
