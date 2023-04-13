package controle;

import bean.*;
import dao.PedidoDAO;

public class VCP {
	public void adicionarPedido(Cliente cliente, Produto produto, int quant) {
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		Vendedor vendedor = new Vendedor ();
		
		vendedor.setIDV(produto.getVendedor().getIDV());
		
		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		pedido.setVendedor(vendedor);
		pedido.setEstado(0);
		pedido.setQuantidade(quant);
		
		pedidoDAO.cadastrarPedido(pedido);
	}
}
