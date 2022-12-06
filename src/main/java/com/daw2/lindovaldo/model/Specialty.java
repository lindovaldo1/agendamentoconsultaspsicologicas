package com.daw2.lindovaldo.model;

public enum Specialty {

    NONE("não selecionado"),
    PSICOLOGIA_SOCIAL("psicologia social"),
    NEUROPSICOLOGIA("neuropsicologia"),
    PSICOLOGIA_SAUDE("psicologi em saúde");

    private String descricao;

    private Specialty(String descricao){this.descricao=descricao;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
