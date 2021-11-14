/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	                   "insert into produtos(codigo_produto, nome, descricao, preco)" +
	                           "values (0,?,?,?)"
	           )){
	            pst.setString(1, produto.getNome());
	            pst.setString(2, produto.getDescricao());
	            pst.setDouble(3, produto.getPreco());
	            pst.executeUpdate();
	         }

	        Statement st = con.createStatement(); 
	        ResultSet rs = st.executeQuery("select last_insert_id()") ;

	        if (rs.next()){
	            produto.setCodigo_produto(rs.getInt(1));
	        } 
	    conexao.close();
	    
		
	}
    
}
