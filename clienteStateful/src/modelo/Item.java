package modelo;


import java.io.Serializable;



public class Item implements Serializable{
    
    private Produto produto;
    private int quantidade;

    public Item(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

   


    public double getTotalItem() {
        return produto.getValor() * quantidade;
        }

    
}
