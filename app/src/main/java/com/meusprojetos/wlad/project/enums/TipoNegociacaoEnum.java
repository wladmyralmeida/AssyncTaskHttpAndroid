package com.meusprojetos.wlad.project.enums;

public enum TipoNegociacaoEnum {

    SELECIONE(0, "SELECIONE"),
    COMPRA(1, "COMPRAR"),
    VENDA(2, "VENDER"),
    ALUGUEL(3, "ALUGAR"),
    HIPOTECA(4, "HIPOTECAR"),
    TEMPORADA(5, "TEMPORADA"),
    OUTRO(6, "OUTRO");

    private int cod;
    private String descricao;

    private TipoNegociacaoEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoNegociacaoEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TipoNegociacaoEnum x : TipoNegociacaoEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}
