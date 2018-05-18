package com.giovannicarmo.webserviceappoio.domain.enums;

public enum Profile {

    ADIMIN ("ROLE_ADMIN"),
    CLIENT ("ROLE_CLIENT");
    
    private String descricao;

    Profile(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Profile toEnum(String descricao) {

        if (descricao == null) {
            return null;
        }

        for (Profile x : Profile.values()) {

            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Tipo inválido: " + descricao);
    }
}