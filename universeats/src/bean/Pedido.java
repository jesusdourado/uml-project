package bean;

public class Pedido {
    private int IDPe;
    private int estado;
    private int quantidade;
    private Cliente cliente;
    private Vendedor vendedor;
    private Produto produto;

    public Pedido() {
    }

    public Pedido(int IDPe, int estado, int quantidade, Cliente cliente, Vendedor vendedor, Produto produto) {
        this.IDPe = IDPe;
        this.estado = estado;
        this.quantidade = quantidade;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produto = produto;
    }

    public int getIDPe() {
        return IDPe;
    }

    public void setIDPe(int IDPe) {
        this.IDPe = IDPe;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "IDPe=" + IDPe + ", estado=" + estado + ", quantidade=" + quantidade + ", cliente=" + cliente + ", vendedor=" + vendedor + ", produto=" + produto + '}';
    }
    
}