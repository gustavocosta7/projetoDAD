package ejb;


import controller.ProdutoController;
import java.security.AccessControlContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import modelo.ICarrinho;
import modelo.IProdutoService;
import modelo.Produto;
import sun.rmi.log.ReliableLog;
import view.GerenciarProduto;
import view.RealizarCompra;

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
        IProdutoService produto = (IProdutoService) context.lookup("ejb:/dadStateless/ProdutoService!modelo.IProdutoService");
       
        
        
//        
//        RealizarCompra realizarCompra = new RealizarCompra();
//       
//        CompraController compraController = new CompraController(realizarCompra, carrinho, produto);
//    
//        realizarCompra.setVisible(true);
//        realizarCompra.setLocationRelativeTo(null);
        
        
        GerenciarProduto gerenciarProduto = new GerenciarProduto();
        ProdutoController produtoController = new ProdutoController(produto, gerenciarProduto);
        gerenciarProduto.setVisible(true);
        gerenciarProduto.setLocationRelativeTo(null);
    }
}
