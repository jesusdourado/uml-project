package bean;

public class Produto {

    private int IDPr;
    private String nome;
    private String descricao;
    private double preco;
    private Vendedor vendedor;
    
    public Produto() {
    }

    public Produto(int IDPr, String nome, String descricao, double preco, Vendedor vendedor) {
        this.IDPr = IDPr;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.vendedor = vendedor;
    }

    public int getIDPr() {
        return IDPr;
    }

    public void setIDPr(int IDPr) {
        this.IDPr = IDPr;
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Produto{" + "IDPr=" + IDPr + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", vendedor=" + vendedor + '}';
    }
    
}