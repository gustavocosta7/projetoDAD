package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.IProdutoService;
import modelo.Item;
import modelo.ItemTableModel;
import modelo.Produto;
import modelo.ProdutoTableModel;
import view.RealizarCompra;
import modelo.ICarrinhoBean;

/**
 *
 * @author fernando
 */
public class CompraController {
    
    private RealizarCompra view;
    private ICarrinhoBean carrinho;
    private IProdutoService iProduto;
    private ItemTableModel tableModel;
    private List<Item> itens;

    public CompraController(RealizarCompra view, ICarrinhoBean carrinho, IProdutoService produto) {
        this.view = view;
        this.carrinho = carrinho;
        this.iProduto = produto;
        itens = carrinho.listar();
        
        this.view.setTbItens(new ItemTableModel(itens));
        
        
        view.addBtnIncluirListener(new IncluirListener());
    }

    class IncluirListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String data = view.getTfData();
            String nomeProduto = view.getCbProduto();
            int quantidade = view.getTfQtd();
            Produto produto = iProduto.getProduto(new Produto(0, nomeProduto, 0));
            Item item = new Item(produto);
            carrinho.inserir(new Item(produto));
            itens.clear();
            itens = carrinho.listar();
            
            view.addBtnIncluirListener(new IncluirListener());
            
        }
    }    
}
