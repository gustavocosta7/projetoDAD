/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Produto;

/**
 *
 * @author Aluno
 */

public class ProdutoDAO {

    private EntityManager em;
    
    public ProdutoDAO(EntityManager em) {
        this.em = em;
    }

    
     public void inserir(Produto p){
         
        em.persist(p);
//        Connection conexao = FabricaConexao.getConnection();
//        try {
//            String query = "insert into produto(pronome,provalor) values(?, ?)";
//            PreparedStatement st = conexao.prepareStatement(query);
//            st.setString(1, p.getNome());
//            st.setDouble(2, p.getValor());
//            st.execute();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
     
    public void delete(Produto p){
        em.remove(p);
//        Connection conexao = FabricaConexao.getConnection();
//        try {
//            String query = "delete from produto where id=?";
//            PreparedStatement st = conexao.prepareStatement(query);
//            st.setInt(1, p.getCodigo());
//            st.execute();
//        } catch (SQLException ex) {
//            System.out.println("não conectado");
//            System.out.println(ex.getMessage());
//        }
    }
    
    public List<Produto> listarProdutos(){
        String query = "select p from Produto p";
        Query consulta = em.createQuery(query);
        return (List<Produto>) consulta.getResultList();
        
//        List<Produto> produtos = new ArrayList<Produto>();
//        Connection conexao = FabricaConexao.getConnection();
//        
//        try {
//            //ABRE CONEXAO COM BANCO DE DADOS
//
//            // CRIA O COMANDO SQL PARA SELECIONAR TODOS OS DADOS DO BANCO
//            String sql = "SELECT proid,pronome,provalor FROM produto";
//            //PREPARA O COMANDO PARA UMA INSTRUCAO ACEITAVEL DO SQL
//            PreparedStatement instrucao = conexao.prepareStatement(sql);
//            //EXECULTA E ALOCA O RESULTADO EM UM OBJETO RESULTSET
//            ResultSet resultados = instrucao.executeQuery();
//            
//            while (resultados.next()) {
//                Produto pro = new Produto();
//                pro.setCodigo(resultados.getInt("proid"));
//                
//                pro.setNome(resultados.getString("pronome"));
//                
//                pro.setValor(resultados.getDouble("provalor"));
//
//                produtos.add(pro);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } 
//
//        return produtos;
    }
    
    
    public Produto findProduto(Produto p){
        
        return em.find(Produto.class, p);
//        Produto produto;
//        try{
//            //ABRE CONEXAO COM BANCO DE DADOS
//            Connection conexao = FabricaConexao.getConnection();
//            // CRIA O COMANDO SQL PARA SELECIONAR TODOS OS DADOS DO BANCO
//            String sql = "SELECT proid,pronome,provalor FROM produto WHERE pronome = ?" ;
//            //PREPARA O COMANDO PARA UMA INSTRUCAO ACEITAVEL DO SQL
//            PreparedStatement instrucao = conexao.prepareStatement(sql);
//            instrucao.setString(1, p.getNome());
//            //EXECULTA E ALOCA O RESULTADO EM UM OBJETO RESULTSET
//            ResultSet resultSet = instrucao.executeQuery();
//            produto = new Produto(resultSet.getInt("proid"), resultSet.getString("pronome"), resultSet.getDouble("provalor"));
//            return  produto;
//        }catch(SQLException e){
//            System.out.println("modelo.dao.ProdutoDAO.findProduto() "+ e);
//        }
//        return null;
    }   
}
