package controle;

import bean.Pedido;
import dao.PedidoDAO;

public class RemoverPedido {
	public void remover(Pedido pedido) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		// Deletar pedido
		pedidoDAO.deletarPedido(pedido);
	}
}
