package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ICarrinho;
import modelo.IProdutoService;
import modelo.Item;
import modelo.Produto;
import view.RealizarCompra;

/**
 *
 * @author fernando
 */
public class CompraController {
    
    private RealizarCompra view;
    private ICarrinho carrinho;
    private IProdutoService iProduto;

    public CompraController(RealizarCompra view, ICarrinho carrinho, IProdutoService produto) {
        this.view = view;
        this.carrinho = carrinho;
        this.iProduto = produto;
        
        view.addBtnIncluirListener(new IncluirListener());
    }

    class IncluirListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String data = view.getTfData();
            String nomeProduto = view.getCbProduto();
            int quantidade = view.getTfQtd();
            
//            Produto produto = iProduto;
            
//            carrinho.inserir(item);
        }
    }    
}
