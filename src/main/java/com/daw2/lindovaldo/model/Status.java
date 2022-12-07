package com.daw2.lindovaldo.model;

public enum Status {

    NONE("none"),
    ATIVO("ativo"),
    INATIVO("inativo");

    private String descricao;

    private Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
