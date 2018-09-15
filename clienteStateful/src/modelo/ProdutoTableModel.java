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
public class ProdutoTableModel extends AbstractTableModel {
    List<Produto> produtos = new ArrayList<Produto>();

    public String[] colunas = {"Codigo", "Nome", "Valor"};
    
    public ProdutoTableModel(List<Produto> produtos){
        this.produtos = produtos;        
    }
    
    @Override
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
    @Override
    public int getRowCount() {        
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    public Produto getPessoa(int linha){
        return this.produtos.get(linha);
    }
            
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = produtos.get(rowIndex);
        
        
        switch(columnIndex){
            case 0: return produto.getCodigo();            
            case 1: return produto.getNome();           
            case 2: return produto.getValor();

        }
        return null;
    }
        
    
}
