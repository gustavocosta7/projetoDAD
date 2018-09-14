package modelo;


import java.rmi.Remote;
import java.util.List;


public interface ICarrinhoBean extends Remote{

    public void inserir(Item item);
    public void remover(Item item);
    public  List<Item> listar();
}
