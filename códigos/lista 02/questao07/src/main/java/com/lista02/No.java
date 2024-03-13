package com.lista02;

public class No {

    private String no;
    private int grauEnttrada;
    private int grauSaida;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getGrauEnttrada() {
        return grauEnttrada;
    }

    public void setGrauEnttrada(int grauEnttrada) {
        this.grauEnttrada = grauEnttrada;
    }

    public int getGrauSaida() {
        return grauSaida;
    }

    public void setGrauSaida(int grauSaida) {
        this.grauSaida = grauSaida;
    }

    @Override
    public String toString() {
        return "nó=" + no + ", grauEnttrada=" + grauEnttrada + ", grauSaida=" + grauSaida + "";
    }

}
