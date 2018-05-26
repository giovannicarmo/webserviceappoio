package com.giovannicarmo.webserviceappoio.domain.enums;

public enum TipoUsuario {

    PAI ("Pai"),
    MAE ("Mae"),
    RESPONSAVEL ("Responsavel"),
    PROFESSOR ("Professor"),
    MEDIADOR ("Mediador"),
    COORDENADOR ("Coordenador"),
    DIRETOR ("Diretor"),
    PSICOLOGO ("Psicologo"),
    PSICIATRA ("Psiquiatra"),
    PEDIATRA ("Pediatra");

    private String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TipoUsuario toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (TipoUsuario x : TipoUsuario.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}
