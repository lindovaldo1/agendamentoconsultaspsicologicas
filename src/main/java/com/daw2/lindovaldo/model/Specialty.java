package com.daw2.lindovaldo.model;

public enum Specialty {

    NONE("não selecionado"),
    PSICOLOGIA_SOCIAL("Psicologia Social"),
    NEUROPSICOLOGIA("Neuropsicologia"),
    PSICOLOGIA_SAUDE("Psicologia em Saúde");

    private String descricao;

    private Specialty(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
