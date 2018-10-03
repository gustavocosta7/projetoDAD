package ejb;



import modelo.ICarrinhoBean;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import modelo.Compra;
import modelo.Item;

@Remote(ICarrinhoBean.class)
@Stateful
public class CarrinhoBean implements ICarrinhoBean{

    private Compra compra;
    
    @Override
    public void inserir(Item item) {
        this.compra.getItens().add(item);
    }

    @Override
    public void remover(Item item) {
        this.compra.getItens().remove(item);
    }

    @Override
    public List<Item> listar() {
        return this.compra.getItens();
    }

}
