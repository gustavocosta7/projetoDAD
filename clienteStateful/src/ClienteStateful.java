/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ICarrinho;
import modelo.Item;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.IProdutoService;
import modelo.Produto;
import view.GerenciarProduto;
import view.RealizarCompra;

/**
 *
 * @author fernando
 */
public class ClienteStateful {

    private GerenciarProduto viewProduto;
    private RealizarCompra viewCompra;
    private ICarrinho carrinho;
    private IProdutoService produto;
    
    

    public static void main(String[] args) throws NamingException {
        GerenciarProduto viewProduto = new GerenciarProduto();
        RealizarCompra viewCompra = new RealizarCompra();
        
        viewProduto.setVisible(true);
        viewCompra.setVisible(true);
        
        
        InitialContext contexto = new InitialContext();
        ICarrinho stateful = (ICarrinho) contexto.lookup("ejb:/dadStateful/!ejb.CarrinhoBean");
        
        contexto = new InitialContext();
        IProdutoService stateless = (IProdutoService) contexto.lookup("ejb:/dadStateless/ProdutoService!modelo.IProdutoService");
        
        ClienteStateful carrinho = new ClienteStateful(viewProduto, viewCompra, stateful,stateless);
        
        
        
    }

    private ClienteStateful(GerenciarProduto view, RealizarCompra viewCompra, ICarrinho service, IProdutoService stateless) {
        this.viewProduto = view;
        this.viewCompra = viewCompra;
        this.carrinho = service;
        this.produto = stateless;
        listarProduto();
        
        viewProduto.addBtnCadastrar(new Cadastrar());
        
    }
    
    
    public void listarProduto(){
        
    }
    
    class Cadastrar implements ActionListener{
      @Override
        public void actionPerformed(ActionEvent e) {

            viewProduto.getTfCodigo()

            produto.inserir(p);
        }

    }
}


