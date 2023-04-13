package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Vendedor;

public class VendedorDAO {

    private Connection connection;

    public VendedorDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastrarVendedor(Vendedor vendedor) {
        String sql
                = "insert into vendedor "
                + "(nome, cpf, matricula, senha) "
                + "values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCPF());
            stmt.setString(3, vendedor.getMatricula());
            stmt.setString(4, vendedor.getSenha());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Vendedor> getVendedores() {
        try {
            String sql = "select * from vendedor";
            List<Vendedor> vendedores = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendedor vendedor = new Vendedor();

                vendedor.setIDV(rs.getInt("idvendedor"));
                vendedor.setNome(rs.getString("nome"));
                vendedor.setCPF(rs.getString("cpf"));
                vendedor.setMatricula(rs.getString("matricula"));
                vendedor.setSenha(rs.getString("senha"));

                vendedores.add(vendedor);
            }
            rs.close();
            stmt.close();
            return vendedores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
