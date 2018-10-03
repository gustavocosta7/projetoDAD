package ejb;


import controller.CompraController;
import controller.ProdutoController;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.IProdutoService;
import view.GerenciarProduto;
import view.RealizarCompra;
import modelo.ICarrinhoBean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Principal {
    public static void main(String[] args) throws NamingException {
        
        
        InitialContext context = new InitialContext();
//        IProdutoService produto = (IProdutoService) context.lookup("ejb:/dadStateless/ProdutoService!modelo.IProdutoService");
        
        ICarrinhoBean carrinho = (ICarrinhoBean) context.lookup("ejb:/dadStateful/CarrinhoBean!modelo.ICarrinhoBean?stateful");
        
        
//        RealizarCompra realizarCompra = new RealizarCompra();
//       
//        CompraController compraController = new CompraController(realizarCompra, carrinho, produto);
//    
//        realizarCompra.setVisible(true);
//        realizarCompra.setLocationRelativeTo(null);
//        
//        
//        GerenciarProduto gerenciarProduto = new GerenciarProduto();
//        ProdutoController produtoController = new ProdutoController(produto, gerenciarProduto);
//        gerenciarProduto.setVisible(true);
//        gerenciarProduto.setLocationRelativeTo(null);
    }
}
