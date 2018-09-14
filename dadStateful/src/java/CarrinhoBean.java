

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;

@Remote(ICarrinho.class)
@Stateful
public class CarrinhoBean implements ICarrinho{

    private List<Item> itens = new ArrayList<Item>();

    @Override
    public void inserir(Item item) {
        this.itens.add(item);
    }

    @Override
    public void remover(Item item) {
        this.itens.remove(item);
    }

    @Override
    public List<Item> listar() {
        return this.itens;
    }
    
}
