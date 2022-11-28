package com.daw2.lindovaldo.model;

public enum SituationModel {

    NONE("none"),
    ACCEPT("aceito"),
    NOT_ACCEPT("não aceito");

    private String descricao;

    private SituationModel(String descricao){this.descricao=descricao;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
