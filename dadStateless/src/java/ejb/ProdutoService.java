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

@Stateless
@Remote(IProdutoService.class)
public class ProdutoService implements IProdutoService{

    @Override
    public void inserir(Produto p) {
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void remover(Produto p) {
    }
    
}
