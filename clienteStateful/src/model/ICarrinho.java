package model;



import model.Item;
import java.util.List;


public interface ICarrinho{

    public void inserir(Item item);
    public void remover(Item item);
    public  List<Item> listar();
}
