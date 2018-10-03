package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

    private final RealizarCompra view;
    private final ICarrinhoBean carrinho;
    private  IProdutoService iProduto;
    private List<Item> itens = null;

    public CompraController(RealizarCompra view, ICarrinhoBean carrinho, IProdutoService produto) {

        this.view = view;
        this.carrinho = carrinho;
        this.iProduto = produto;
        
        view.setBtnUpdate(new AtualizarListener());
        this.view.setTbItens(new ItemTableModel(itens));
        view.addBtnIncluirListener(new IncluirListener());

    }

    class AtualizarListener implements ActionListener {

        private AtualizarListener() {
     
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Produto p : iProduto.listar()) {
                System.out.println("Lista >" + p.getNome());
                model.addElement(p.getNome());
            }
            view.setCbProduto(model);
        }

    }

    class IncluirListener implements ActionListener {

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
