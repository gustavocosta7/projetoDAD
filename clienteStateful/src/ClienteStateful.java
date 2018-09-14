/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import model.ICarrinho;
import model.Item;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author fernando
 */
public class ClienteStateful {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        
        InitialContext context = new InitialContext();  //global/dadStateful/CarrinhoBean!ICarrinho
        ICarrinho carrinho = (ICarrinho) context.lookup("ejb:/dadStateful/CarrinhoBean!ICarrinho?stateful");
        Item item = new Item("agua", 123, 12);
        carrinho.inserir(item);
        List<Item> lista = carrinho.listar();
        
        for(Item i : lista){
            System.out.println(i.getProduto());
            System.out.println(i.getQuantidade());
            System.out.println(i.getValor());
        }
        
    }
    
}
