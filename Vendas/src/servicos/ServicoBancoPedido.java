package servicos;

import classes.Pedido;
import classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class ServicoBancoPedido {

    private final Conexao conexao = new Conexao();
    public void insert(ArrayList<ServicoPedido> servicopedido) throws SQLException {

        Connection con = conexao.getConexao();
        float valor_total = 0;
        try (PreparedStatement pst = con.prepareStatement(
            "insert into pedido(numero_pedido,codigo_cliente)"
            + "values (0,?)"
            )) {
            pst.setInt(1, servicopedido.get(0).getPedido().getCodigo_cliente());
            pst.executeUpdate();
        }

        for (int i= 0; servicopedido.size() > i; i++){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select last_insert_id()");

            update(servicopedido.get(i).getProduto(), servicopedido.get(i).getQuantidade());

            if (rs.next()) {
                servicopedido.get(i).getPedido().setNumero_pedido(rs.getInt(1));
            }
            try (PreparedStatement pst = con.prepareStatement(
                    "insert into pedido_has_produto(quantidade,preco,data,numero_pedido,codigo_produto)"
                    + "values (?,?,?,?,?)"
            )) {
                Date data = new Date(System.currentTimeMillis());

                pst.setInt(1, servicopedido.get(i).getQuantidade());
                pst.setDouble(2, servicopedido.get(i).getPreco());
                pst.setString(3, data.toString());
                pst.setInt(4, servicopedido.get(i).getPedido().getNumero_pedido());
                pst.setInt(5, servicopedido.get(i).getProduto().getCodigo_produto());
                pst.executeUpdate();
            }
            valor_total += servicopedido.get(i).getPreco();
        }
        try (PreparedStatement pst = con.prepareStatement(
            "UPDATE pedido set valor_total = ? WHERE numero_pedido= ?")) {
            pst.setFloat(1, valor_total);
            pst.setInt(2, servicopedido.get(0).getPedido().getNumero_pedido());
            pst.executeUpdate();
        }

        

        conexao.close();
    }

    public void update(Produto produto, int quantidade) throws SQLException {
        Connection con = conexao.getConexao();
        try (PreparedStatement pst = con.prepareStatement("UPDATE produto set quantidade = quantidade - ? WHERE codigo_produto =?")) {
            pst.setInt(1, quantidade);
            pst.setInt(2, produto.getCodigo_produto());
            pst.executeUpdate();
        }
        conexao.close();
    }
    
    public ArrayList getClienteByListaString() throws SQLException{
    ArrayList dados = new ArrayList();
    
    try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("SELECT b.numero_pedido,b.quantidade,a.nome,b.preco,b.data,c.codigo_cliente,c.valor_total FROM ecommerce.produto a INNER JOIN ecommerce.pedido_has_produto b ON a.codigo_produto=b.codigo_produto INNER JOIN ecommerce.pedido c ON b.numero_pedido=c.numero_pedido")) {
         
        while (rs.next()){
          dados.add(new String [] { rs.getString("numero_pedido"),
                                    rs.getString("quantidade"),
                                    rs.getString("nome"),
                                    rs.getString("preco"),
                                    rs.getString("data"),
                                    rs.getString(("codigo_cliente")),
                                    rs.getString("valor_total")
                                   }); 
        }
    }
    
    return dados;           
  }
    
    public ArrayList getProdutosPedidoByLista(Pedido pedido) throws SQLException{
    ArrayList<Produto> dados = new ArrayList<>();
    
    try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("SELECT b.codigo_produto, b.quantidade, a.nome FROM ecommerce.produto a INNER JOIN ecommerce.pedido_has_produto b ON a.codigo_produto=b.codigo_produto where numero_pedido = " + pedido.getNumero_pedido())) {
         
        while (rs.next()){
          dados.add(new Produto(rs.getInt("codigo_produto"), rs.getInt("quantidade"), rs.getString("nome"))); 
        }
    }
    
    return dados;           
  } 
    public ArrayList getPedidoByLista() throws SQLException{
      ArrayList<Pedido> lista = new ArrayList<>();
     try (Statement st = conexao.getConexao().createStatement(); 
            ResultSet rs = st.executeQuery
             ("select * from pedido order by numero_pedido")) {
         
        while (rs.next()){
          lista.add(new Pedido(rs.getInt("numero_pedido"), rs.getInt("codigo_cliente")));
        }
    }
    
     return lista;
    }
}
