package classes;

public class Produto {
   private int codigo_produto, quantidade;
   private String nome, descricao;
   private double preco;

public Produto(String nome, String descricao, double preco, int quantidade) {
    this.setNome(nome);
    this.setDescricao(descricao);
    this.setPreco(preco);
    this.setQuantidade(quantidade);
}

public Produto(int codigo_produto, String nome, String descricao, double preco, int quantidade) {
    this.setCodigo_produto(codigo_produto);
	this.setNome(nome);
    this.setDescricao(descricao);
    this.setPreco(preco);
    this.setQuantidade(quantidade);
}

public int getCodigo_produto() {
	return codigo_produto;
}

public void setCodigo_produto(int codigo_produto) {
	this.codigo_produto = codigo_produto;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public int getQuantidade() {
	return quantidade;
}

public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}    

@Override
public String toString(){
    return this.nome;
}

}