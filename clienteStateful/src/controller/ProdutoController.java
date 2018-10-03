/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.IProdutoService;
import modelo.Produto;
import modelo.ProdutoTableModel;
import view.GerenciarProduto;

/**
 *
 * @author fernando
 */
public class ProdutoController {

    private final IProdutoService produto;
    private List<Produto> produtos;
    
    private final GerenciarProduto view;

    public ProdutoController(IProdutoService produto, GerenciarProduto view) {

        this.produto = produto;
        this.view = view;
        
        view.addBtnCadastrar(new CadastraProduto());
        
        produtos = produto.listar();
        view.getTblProduto().setModel(new ProdutoTableModel(produtos));
    }

    
    private class CadastraProduto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int cod = view.getTfCodigo();
            String nome = view.getTfNome();
            double valor = view.getTfValor();
            
            produto.inserir(new Produto(cod, nome, valor));
            produtos.clear();
            
            produtos = produto.listar();
        
            view.getTblProduto().setModel(new ProdutoTableModel(produtos));
        }
    }
    
    
    
}
