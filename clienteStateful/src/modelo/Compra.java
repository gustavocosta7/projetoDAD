
package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Compra implements Serializable{
    
    private static final long serialVersion = 1L;
    private Calendar dataDaCompra;
    private List<Item> itens;

    public Calendar getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Calendar dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Compra(Calendar dataDaCompra, List<Item> itens) {
        this.dataDaCompra = dataDaCompra;
        this.itens = itens;
    }

    
    public double getTotalGeral(){
        double saida = 0.0;
        for (Item i : itens){
            saida += i.getTotalItem();
        }
        
        return saida;
        
    }
    
}
