/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import classes.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Produto;

/**
 *
 * @author matheus.aviz
 */
public class ServicoBancoProduto {
	
    private final Conexao conexao = new Conexao(); 

	public void insert(Produto produto) throws SQLException {
	        Connection con = conexao.getConexao();

	        try(PreparedStatement pst = con.prepareStatement(
	                   "insert into produto (nome, descricao, preco, quantidade)" +
	                           "values (?,?,?,?)"
	           )){
	            pst.setString(1, produto.getNome());
	            pst.setString(2, produto.getDescricao());
	            pst.setDouble(3, produto.getPreco());
	            pst.setDouble(4, produto.getQuantidade());
	            pst.executeUpdate();
	         }

	        Statement st = con.createStatement(); 
	        ResultSet rs = st.executeQuery("select last_insert_id()") ;

	        if (rs.next()){
	            produto.setCodigo_produto(rs.getInt(1));
	        } 
	    conexao.close();
	    
		
	}
	 public ArrayList<Produto> getProdutoByLista()throws SQLException{
	      ArrayList<Produto> lista = new ArrayList<>();
	     try (Statement st = conexao.getConexao().createStatement(); 
	            ResultSet rs = st.executeQuery
	             ("select * from produto order by nome")) {
	         
	        while (rs.next()){
	          lista.add(new Produto(rs.getInt("codigo_produto"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), rs.getInt("quantidade")));
	        }
	    }
	    
	     return lista;
	 }

	public void update(Produto produto) throws SQLException{
	        Connection con = conexao.getConexao();    
	        try (PreparedStatement pst = con.prepareStatement
	            ("update produto set nome = ?, descricao = ?, preco = ?, quantidade = ? where (codigo_produto = ?)")) {
	        pst.setString(1, produto.getNome());
	        pst.setString(2, produto.getDescricao());
	        pst.setDouble(3, produto.getPreco());
	        pst.setInt(4, produto.getQuantidade());
	        pst.setInt(5, produto.getCodigo_produto());
	        pst.executeUpdate();
	        }
	        conexao.close();
	    }
        
	public void update_produto_pedido(Produto produto, Pedido pedido) throws SQLException{
	        Connection con = conexao.getConexao();    
	        try (PreparedStatement pst = con.prepareStatement
	            ("update pedido_has_produto set quantidade = ? where codigo_produto = ? and numero_pedido = ?")) {
	        pst.setInt(1, produto.getQuantidade());
	        pst.setInt(2, produto.getCodigo_produto());
	        pst.setInt(3, pedido.getNumero_pedido());
	        pst.executeUpdate();
	        }
	        conexao.close();
	    }        
        public ArrayList getProdutoByListaString() throws SQLException{
		    ArrayList dados = new ArrayList();
		    
		    try (Statement st = conexao.getConexao().createStatement(); 
		            ResultSet rs = st.executeQuery
		             ("select * from produto order by codigo_produto ")) {
		         
		        while (rs.next()){
		          dados.add(new String [] { rs.getString("codigo_produto"), 
		                                    rs.getString("nome"), 
		                                    rs.getString("descricao"),
		                                    rs.getString("preco"),
		                                    rs.getString("quantidade")
		                                   }); 
		        }
	}
			return dados;
	  }
}
    

