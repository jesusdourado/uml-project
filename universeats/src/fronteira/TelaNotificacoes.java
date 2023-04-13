package fronteira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bean.*;
import controle.AtualizarPedido;
import controle.ListaPedidos;
import controle.ListarProdutos;
import controle.VerificarPedidos;
import dao.ClienteDAO;
import dao.VendedorDAO;

public class TelaNotificacoes {
	public void mostrar (Vendedor vendedor) {
		ListarProdutos listaProdutos = new ListarProdutos();
		ClienteDAO clienteDAO = new ClienteDAO();
		VerificarPedidos verificarPedidos = new VerificarPedidos();
		AtualizarPedido atualizarPedido = new AtualizarPedido();
		
		List<Pedido> pedidos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		Scanner leitor = new Scanner(System.in);
		int opcao;
		String escolha;
		
		pedidos = verificarPedidos.verificar(vendedor);
		produtos = listaProdutos.listar();
		clientes = clienteDAO.getClientes();
		
		System.out.println("--- NOTIFICAÇÕES DE PEDIDOS ---");
		
		for(int i = 0; i < pedidos.size(); i ++) {
			if(pedidos.get(i).getEstado() == 0) {
				System.out.println("> PEDIDO " + (i + 1)
						+ "\n   > Produto: " + produtos.get(pedidos.get(i).getProduto().getIDPr() - 1).getNome()
		                + "\n   > Quantidade: " + pedidos.get(i).getQuantidade() 
		                + "\n   > Cliente: " + clientes.get(pedidos.get(i).getCliente().getIDC() - 1).getNome()
				        + "\n   > ID Pedido: " + pedidos.get(i).getIDPe());
				System.out.println("   > Situação: PENDENTE");
			}
			else if(pedidos.get(i).getEstado() == 1) {
				System.out.println("> PEDIDO " + (i + 1)
						+ "\n   > Produto: " + produtos.get(pedidos.get(i).getProduto().getIDPr() - 1).getNome()
		                + "\n   > Quantidade: " + pedidos.get(i).getQuantidade() 
		                + "\n   > Cliente: " + clientes.get(pedidos.get(i).getCliente().getIDC() - 1).getNome()
				        + "\n   > ID Pedido: " + pedidos.get(i).getIDPe());
				System.out.println("   > Situação: ACEITO");
			}
		}
		
		System.out.println("Escolha um pedido para gerenciar: ");
		opcao = Integer.parseInt(leitor.nextLine());
		
		System.out.println("> PEDIDO " + opcao + " SELECIONADO"
				+ "\n   > Produto: " + produtos.get(pedidos.get(opcao - 1).getProduto().getIDPr() - 1).getNome()
				+ "\n   > Descrição: " + produtos.get(pedidos.get(opcao - 1).getProduto().getIDPr() - 1).getDescricao()
                + "\n   > Quantidade: " + pedidos.get(opcao - 1).getQuantidade() 
                + "\n   > Cliente: " + clientes.get(pedidos.get(opcao - 1).getCliente().getIDC() - 1).getNome()
		        + "\n   > ID Pedido: " + pedidos.get(opcao - 1).getIDPe());
		
		if(pedidos.get(opcao - 1 ).getEstado() == 0) {
			System.out.println("   > Situação: PENDENTE");
			
			System.out.println("Aceitar ou Recusar?");
			escolha = leitor.nextLine();
			
			if(escolha.equals("aceitar")) {
				atualizarPedido.atualizar(pedidos.get(opcao - 1), 1);
				System.out.println("Pedido de " + clientes.get(pedidos.get(opcao - 1).getCliente().getIDC() - 1).getNome() + " aceito!");
			}
			else if(escolha.equals("recusar")) {
				atualizarPedido.atualizar(pedidos.get(opcao - 1), 2);
				System.out.println("Pedido de " + clientes.get(pedidos.get(opcao - 1).getCliente().getIDC() - 1).getNome() + " recusado!");
			}
		}
		else if(pedidos.get(opcao - 1 ).getEstado() == 1) {
			System.out.println("   > Situação: ACEITO");
			
			System.out.println("Finalizar entrega?");
			escolha = leitor.nextLine();
			
			if(escolha.equals("finalizar")) {
				atualizarPedido.atualizar(pedidos.get(opcao - 1), 3);
				System.out.println("Pedido de " + clientes.get(pedidos.get(opcao - 1).getCliente().getIDC() - 1).getNome() + " entregue!");
			}
		}
		
		
		
	}
}
