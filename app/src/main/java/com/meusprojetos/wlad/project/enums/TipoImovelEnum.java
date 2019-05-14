package com.meusprojetos.wlad.project.enums;

public enum TipoImovelEnum {

    SELECIONE(0, "SELECIONE"),
    RESIDENCIAL(1, "RESIDENCIAL"),
    COMERCIAL(2, "COMERCIAL"),
    RURAL(3, "RURAL"),
    LOTE(4, "LOTE"),
    OUTRO(5, "OUTRO");

    private int cod;
    private String descricao;

    private TipoImovelEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoImovelEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TipoImovelEnum x : TipoImovelEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
