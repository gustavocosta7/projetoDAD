package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import modelo.IProdutoService;
import modelo.Item;
import modelo.ItemTableModel;
import modelo.Produto;
import view.RealizarCompra;
import modelo.ICarrinhoBean;
import util.DataUtil;

/**
 *
 * @author fernando
 */
public class CompraController {

    private final RealizarCompra view;
    private final ICarrinhoBean carrinho;
    private  IProdutoService iProduto;
    private List<Item> itens = new ArrayList<>();
    private List<Produto> produtosList;

    public CompraController(RealizarCompra view, ICarrinhoBean carrinho, IProdutoService produto) {

        this.view = view;
        this.carrinho = carrinho;
        this.iProduto = produto;
        produtosList = iProduto.listar();
        
        view.setBtnUpdate(new AtualizarListener());
        this.view.setTbItens(new ItemTableModel(itens));
        view.addBtnIncluirListener(new IncluirListener());

    }

    public class PopulaTable implements ActionListener {
        
        public PopulaTable(List<Item>itens) {
            view.setTbItens(new ItemTableModel(itens));
        
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
    }

    class AtualizarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (Produto p : iProduto.listar()) {
                model.addElement(p.getNome());
            }
            view.setCbProduto(model);
        }

    }

    class IncluirListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Calendar data = DataUtil.ConverterTextoEmData(view.getTfData());
            } catch (ParseException ex) {
                Logger.getLogger(CompraController.class.getName()).log(Level.SEVERE, null, ex);
            }
            int quantidade = view.getTfQtd();
            
            Produto produto = new Produto();
            produto = produtosList.get(view.getCombo().getSelectedIndex());
            Item item = new Item(produto,quantidade);
            carrinho.inserir(item);

            itens = carrinho.listar();

            view.addBtnIncluirListener(new PopulaTable(itens));

        }
    }
}
