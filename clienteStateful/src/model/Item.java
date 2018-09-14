package model;


import java.io.Serializable;



public class Item implements Serializable{
    
    private String produto;
    private double valor;
    private double quantidade;

    public Item(String produto, double valor, double quantidade) {
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Item() {
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    
}
