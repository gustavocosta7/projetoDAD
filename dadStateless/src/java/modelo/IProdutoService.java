/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.List;

/**
 *
 * @author Aluno
 */
public interface IProdutoService {
    public void inserir(Produto p);
    public List<Produto> listar();
    public void remover(Produto p);
    public Produto getProduto(Produto p);
}
