package fronteira;

import java.util.ArrayList;
import java.util.List;
import bean.*;
import controle.ListaPedidos;
import controle.ListarProdutos;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.VendedorDAO;

public class TelaPedidos {
	public void mostrar (Cliente cliente) {
		ListaPedidos listaPedidos = new ListaPedidos();
		ListarProdutos listaProdutos = new ListarProdutos();
		VendedorDAO vendedorDAO = new VendedorDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Vendedor> vendedores = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		pedidos = listaPedidos.listar(cliente);
		produtos = listaProdutos.listar();
		vendedores = vendedorDAO.getVendedores();
		clientes = clienteDAO.getClientes();
		
		System.out.println("--- LISTA DE MEUS PEDIDOS ---");
		
		for(int i = 0; i < pedidos.size(); i ++) {
			System.out.println("> PEDIDO " + (i + 1)
					+ "\n   > Produto: " + produtos.get(pedidos.get(i).getProduto().getIDPr() - 1).getNome()
	                + "\n   > Quantidade: " + pedidos.get(i).getQuantidade() 
	                + "\n   > Vendedor: " + vendedores.get(pedidos.get(i).getVendedor().getIDV() - 1).getNome());
			if(pedidos.get(i).getEstado() == 0) {
				System.out.println("   > Situação: PENDENTE");
			}
			else if(pedidos.get(i).getEstado() == 1) {
				System.out.println("   > Situação: ACEITO");
			}
			else if(pedidos.get(i).getEstado() == 2) {
				System.out.println("   > Situação: RECUSADO");
			}
			else if(pedidos.get(i).getEstado() == 3) {
				System.out.println("   > Situação: ENTREGUE");
			}
		}
	}
}
