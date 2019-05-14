package com.meusprojetos.wlad.project.enums;

public enum OcupacaoEnum {

    SELECIONE(0, "SELECIONE"),
    OCUPADO(1, "DISPONIVEL"),
    DISPONIVEL(2, "OCUPADO"),
    OUTRO(3, "OUTRO");

    private int cod;
    private String descricao;

    private OcupacaoEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static OcupacaoEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (OcupacaoEnum x : OcupacaoEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
