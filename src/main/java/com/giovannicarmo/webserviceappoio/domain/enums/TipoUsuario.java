package com.giovannicarmo.webserviceappoio.domain.enums;

public enum TipoUsuario {

    PAI (1, "Pai"),
    MAE (2, "Mae"),
    RESPONSAVEL (3, "Responsavel"),
    PROFESSOR (4, "Professor"),
    MEDIADOR (5, "Mediador"),
    COORDENADOR (6, "Coordenador"),
    DIRETOR (7, "Diretor"),
    PSICOLOGO (8, "Psicologo"),
    PSICIATRA (9, "Psiciatra"),
    PEDIATRA (10, "Pediatra");

    private int id;
    private String descricao;

    TipoUsuario(int id, String descricao) {
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

    public static TipoUsuario toEnum(Integer id) {

        if (id == null) {
            return null;
        }

        for (TipoUsuario x : TipoUsuario.values()) {

            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id invalido: " + id);
    }
}
