package servicos;

import classes.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServicoBancoCliente {
    private final Conexao conexao = new Conexao();  
    
    //inserir cliente na tabela cliente
    public void insert(Cliente cliente) throws SQLException {
        //Criando variavel conexao
        Connection con = conexao.getConexao();

        try(PreparedStatement pst = con.prepareStatement(
                   "insert into cliente(codigo_cliente, nome, cpf, sexo, telefone)" +
                           "values (0,?,?,?,?)"
           )){
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getCpf());
            pst.setString(3, cliente.getSexo());
            pst.setString(4, cliente.getTelefone());
            //Executa o codigo acima
            pst.executeUpdate();
         }

        Statement st = con.createStatement(); 
        //executa o cod abaixo
        ResultSet rs = st.executeQuery("select last_insert_id()") ;

        if (rs.next()){
            cliente.setCodigoCliente(rs.getInt(1));
        } 
    conexao.close();
    }
    
  public ArrayList<Cliente> getClienteByLista()throws SQLException{
      ArrayList<Cliente> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from cliente order by nome")) {
         
        while (rs.next()){
          lista.add(new Cliente(rs.getInt("codigo_cliente"), rs.getString("nome"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("telefone"), rs.getString("situacao")));
        }
    }
    
     return lista;
 }
  
    public void update(Cliente cliente) throws SQLException{
        Connection con = conexao.getConexao();    
        try (PreparedStatement pst = con.prepareStatement
            ("update cliente set nome = ?, cpf = ?, telefone = ?, sexo = ?, situacao = ? where (codigo_cliente = ?)")) {
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getCpf());
        pst.setString(3, cliente.getTelefone());
        pst.setString(4, cliente.getSexo());
        pst.setString(5, cliente.getSituacao());
        pst.setInt(6, cliente.getCodigoCliente());
        pst.executeUpdate();
        }
        conexao.close();
    }
}
