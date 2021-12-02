package classes;

public class Pedido {

    private int numero_pedido;
    private int codigo_cliente;

    public Pedido() {
    }

    public Pedido(int numero_pedido, int codigo_cliente) {
        this.numero_pedido = numero_pedido;
        this.codigo_cliente = codigo_cliente;
    }

    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Pedido(int codigoCliente) {
        this.codigo_cliente = codigoCliente;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    @Override
    public String toString(){
        return "Numero do pedido: " + this.numero_pedido;
    }
}
