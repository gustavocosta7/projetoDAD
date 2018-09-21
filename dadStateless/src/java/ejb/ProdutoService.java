/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import modelo.IProdutoService;
import modelo.Produto;
import modelo.dao.ProdutoDAO;

@Stateless
@Remote(IProdutoService.class)
public class ProdutoService implements IProdutoService{
    ProdutoDAO dao = new ProdutoDAO();
    @Override
    public void inserir(Produto p) {
        dao.inserir(p);
        
    }

    @Override
    public List<Produto> listar() {
        return dao.listarProdutos();
    }

    @Override
    public void remover(Produto p) {
        dao.delete(p);
    }

    @Override
    public Produto getProduto(Produto p) {
        return dao.findProduto(p);
    }
}
