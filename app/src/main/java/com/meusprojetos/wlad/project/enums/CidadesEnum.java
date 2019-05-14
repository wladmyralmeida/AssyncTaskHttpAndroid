package com.meusprojetos.wlad.project.enums;

public enum CidadesEnum {

    SELECIONE(0, "SELECIONE"),
    PATOS(1, "COMPRAR"),
    JOAO_PESSOA(2, "JOAO PESSOA"),
    CAMPINA_GRANDE(3, "CAMPINA GRANDE"),
    SANTA_TEREZINHA(4, "SANTA TEREZINHA"),
    CATINGUEIRA(5, "CATINGUEIRA"),
    TEIXEIRA(6, "TEIXEIRA"),
    CACIMBA_DE_AREIA(7, "CACIMBA DE AREIA"),
    SAO_JOSE_DO_BONFIM(8, "SAO JOSE DO BONFIM"),
    TAPEROA(9, "TAPEROA"),
    CAJAZEIRAS(10, "CAJAZEIRAS"),
    CABEDELO(11, "CABEDELO"),
    POMBAL(12, "POMBAL"),
    MALTA(13, "MALTA"),
    QUIXABA(14, "QUIXABA");


    private int cod;
    private String descricao;

    private CidadesEnum(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CidadesEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (CidadesEnum x : CidadesEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
