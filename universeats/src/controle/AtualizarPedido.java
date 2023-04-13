package controle;

import bean.Pedido;
import dao.PedidoDAO;

public class AtualizarPedido {
	public void atualizar(Pedido pedido, int estado) {
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		pedido.setEstado(estado);
		
		pedidoDAO.atualizaEstadoPedido(pedido);
	}
}
