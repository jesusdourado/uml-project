package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.*;

public class PedidoDAO {

    private Connection connection;

    public PedidoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarPedido(Pedido pedido) {
        String sql
                = "insert into pedido "
                + "(estado, quantidade, cliente_idcliente, vendedor_idvendedor, produto_idproduto) "
                + "values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, pedido.getEstado());
            stmt.setInt(2, pedido.getQuantidade());
            stmt.setInt(3, pedido.getCliente().getIDC());
            stmt.setInt(4, pedido.getVendedor().getIDV());
            stmt.setInt(5, pedido.getProduto().getIDPr());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Pedido> getPedidos() {
        try {
            String sql = "select * from pedido";
            List<Pedido> pedidos = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setIDPe(rs.getInt("idpedido"));
                pedido.setEstado(rs.getInt("estado"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                Cliente c = new Cliente();
                c.setIDC(rs.getInt("cliente_idcliente"));
                pedido.setCliente(c);
                Vendedor v = new Vendedor();
                v.setIDV(rs.getInt("vendedor_idvendedor"));
                pedido.setVendedor(v);
                Produto p = new Produto();
                p.setIDPr(rs.getInt("produto_idproduto"));
                pedido.setProduto(p);

                pedidos.add(pedido);
            }
            rs.close();
            stmt.close();
            return pedidos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaEstadoPedido(Pedido pedido) {
        String sql
                = "update pedido set "
                + "estado = ? "
                + "where idpedido = ? ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, pedido.getEstado());
            stmt.setLong(2, pedido.getIDPe());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarPedido(Pedido pedido) {
        try {
            String sql = "delete from pedido where idpedido = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setLong(1, pedido.getIDPe());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}