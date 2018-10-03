/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.IProdutoService;
import modelo.Produto;
import modelo.dao.ProdutoDAO;

@Stateless
@Remote(IProdutoService.class)
public class ProdutoService implements IProdutoService{
        
    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public void inserir(Produto p) {
        
        ProdutoDAO dao = new ProdutoDAO(em);
        dao.inserir(p);
        
    }

    @Override
    public List<Produto> listar() {
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.listarProdutos();
    }

    @Override
    public void remover(Produto p) {
        ProdutoDAO dao = new ProdutoDAO(em);
        dao.delete(p);
    }

    @Override
    public Produto getProduto(Produto p) {
        ProdutoDAO dao = new ProdutoDAO(em);
        return dao.findProduto(p);
//        return null;
    }
}
