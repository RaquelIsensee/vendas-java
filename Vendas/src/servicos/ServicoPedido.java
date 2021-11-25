package servicos;

import classes.Pedido;
import classes.Produto;

public class ServicoPedido {
    private Pedido pedido;
    private int quantidade;
    private double preco;
    private Produto produto;

    public ServicoPedido() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    public ServicoPedido(Pedido pedido, int quantidade, double preco, Produto produto) {
        this.pedido = pedido;
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
   
}
