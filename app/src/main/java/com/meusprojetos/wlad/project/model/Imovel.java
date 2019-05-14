package com.meusprojetos.wlad.project.model;

import java.io.Serializable;

public class Imovel implements Serializable {

    private Long idImovel;

    private String tipoImovel;
    private String tipoNegociacao;
    private String obs;
    private String proprietario;

    private String ocupacao;

    private Integer qtdQuartos;
    private Integer qtdSuite;
    private Integer qtdBanheiro;
    private Integer cidade;

    private Double valor;
    private Double area;

    public Imovel() {

    }

    public Imovel(Long idImovel, String tipoImovel, String tipoNegociacao,
                  Integer qtdQuartos, Integer qtdSuite, Integer qtdBanheiro,
                  Double valor, Double area, String obs, String ocupacao,
                  Integer cidade, String proprietario) {
        this.idImovel = idImovel;
        this.tipoImovel = tipoImovel;
        this.tipoNegociacao = tipoNegociacao;
        this.qtdQuartos = qtdQuartos;
        this.qtdSuite = qtdSuite;
        this.qtdBanheiro = qtdBanheiro;
        this.valor = valor;
        this.area = area;
        this.obs = obs;
        this.ocupacao = ocupacao;
        this.cidade = cidade;
        this.proprietario = proprietario;
    }

    public Long getIdImovel() {
        return idImovel;
    }

    public void setIdImovel(Long idImovel) {
        this.idImovel = idImovel;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getTipoNegociacao() {
        return tipoNegociacao;
    }

    public void setTipoNegociacao(String tipoNegociacao) {
        this.tipoNegociacao = tipoNegociacao;
    }

    public Integer getQtdQuartos() {
        return qtdQuartos;
    }

    public void setQtdQuartos(Integer qtdQuartos) {
        this.qtdQuartos = qtdQuartos;
    }

    public Integer getQtdSuite() {
        return qtdSuite;
    }

    public void setQtdSuite(Integer qtdSuite) {
        this.qtdSuite = qtdSuite;
    }

    public Integer getQtdBanheiro() {
        return qtdBanheiro;
    }

    public void setQtdBanheiro(Integer qtdBanheiro) {
        this.qtdBanheiro = qtdBanheiro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Integer getCidade() {
        return cidade;
    }

    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "idImovel=" + idImovel +
                ", tipoImovel='" + tipoImovel + '\'' +
                ", tipoNegociacao='" + tipoNegociacao + '\'' +
                ", qtdQuartos=" + qtdQuartos +
                ", qtdSuite=" + qtdSuite +
                ", qtdBanheiro=" + qtdBanheiro +
                ", valor=" + valor +
                ", area=" + area +
                ", obs='" + obs + '\'' +
                ", ocupacao=" + ocupacao +
                ", cidade=" + cidade +
                ", proprietario='" + proprietario + '\'' +
                '}';
    }
}
