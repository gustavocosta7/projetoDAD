/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import modelo.IProdutoService;
import modelo.Produto;
import modelo.ProdutoTableModel;
import view.GerenciarProduto;

/**
 *
 * @author fernando
 */
public class ProdutoController {

    private IProdutoService produto;
    private Map<String,Produto> map;
    private GerenciarProduto view;

    public ProdutoController(IProdutoService produto, GerenciarProduto view) {
        String[] coluna = {"Codigo","Nome","Valor"};
        this.produto = produto;
        this.view = view;
        map = new HashMap<String,Produto>();
        map.putAll(coluna,produto.listar());
        
        view.addBtnCadastrar(new CadastraProduto());
        view.setTblProduto(new DefaultTableModel());
    }

    private class CadastraProduto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            produto.inserir(new Produto(view.getTfCodigo(), view.getTfNome(), view.getTfValor()));
            
        }
    }
    
    
    
}
