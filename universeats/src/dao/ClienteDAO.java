package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Cliente;

public class ClienteDAO {
    private Connection connection;

    public ClienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void cadastrarCliente(Cliente cliente) {
        String sql
                = "insert into cliente "
                + "(nome, cpf, matricula, senha) "
                + "values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF());
            stmt.setString(3, cliente.getMatricula());
            stmt.setString(4, cliente.getSenha());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public List<Cliente> getClientes() {
        try {
            String sql = "select * from cliente";
            List<Cliente> clientes = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setIDC(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setMatricula(rs.getString("matricula"));
                cliente.setSenha(rs.getString("senha"));

                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
