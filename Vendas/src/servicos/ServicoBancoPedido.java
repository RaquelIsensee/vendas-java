package servicos;

import classes.Pedido;
import classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class ServicoBancoPedido {

    private final Conexao conexao = new Conexao();

    public void insert(Pedido pedido, Produto produto, int quantidade, String preco) throws SQLException {

        Connection con = conexao.getConexao();

        try (PreparedStatement pst = con.prepareStatement(
                "insert into pedido(numero_pedido,codigo_cliente)"
                + "values (0,?)"
        )) {
            pst.setInt(1, pedido.getNumero_pedido());
            pst.executeUpdate();
        }
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select last_insert_id()");

        update(produto, quantidade);

        if (rs.next()) {
            pedido.setNumero_pedido(rs.getInt(1));
        }
        try (PreparedStatement pst = con.prepareStatement(
                "insert into pedido_has_produto(quantidade,preco,data,numero_pedido,codigo_produto)"
                + "values (?,?,?,?,?)"
        )) {
            Date data = new Date(System.currentTimeMillis());

            pst.setInt(1, quantidade);
            pst.setString(2, preco);
            pst.setString(3, data.toString());
            pst.setInt(4, pedido.getNumero_pedido());
            pst.setInt(5, produto.getCodigo_produto());
            //Executa o codigo acima
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
}
