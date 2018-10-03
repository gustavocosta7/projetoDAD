/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class ItemTableModel extends AbstractTableModel {
    List<Item> itens = new ArrayList<Item>();

    public String[] colunas = {"Codigo", "Nome", "Valor", "Qtd.", "Total"};
    
    public ItemTableModel(List<Item> produtos){
        this.itens = produtos;        
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    @Override
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() { 
        if (itens == null)
            return 0;
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    public Item getPessoa(int linha){
        return this.itens.get(linha);
    }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = itens.get(rowIndex);
        
        
        switch(columnIndex){
            case 0: return item.getProduto().getCodigo();            
            case 1: return item.getProduto().getNome();           
            case 2: return item.getProduto().getValor();
            case 3: return item.getQuantidade();
            case 4: return item.getTotalItem();
        }
        return null;
    }
        
    
}
