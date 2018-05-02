package com.giovannicarmo.webserviceappoio.domain.enums;

public enum TipoUsuario {

    PAI (0, "Pai"),
    MAE (1, "Mae"),
    RESPONSAVEL (2, "Responsavel"),
    PROFESSOR (3, "Professor"),
    MEDIADOR (4, "Mediador"),
    COORDENADOR (5, "Coordenador"),
    DIRETOR (6, "Diretor"),
    PSICOLOGO (7, "Psicologo"),
    PSICIATRA (8, "Psiquiatra"),
    PEDIATRA (9, "Pediatra");

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
