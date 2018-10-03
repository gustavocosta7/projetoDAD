package modelo;


import java.rmi.Remote;
import java.util.List;
import modelo.Item;


public interface ICarrinhoBean extends Remote{

    public void inserir(Item item);
    public void remover(Item item);
    public  List<Item> listar();
}
