package controle;

import java.util.ArrayList;
import java.util.List;
import bean.Cliente;
import bean.Pedido;
import dao.PedidoDAO;

public class ListaPedidos {
	public List<Pedido> listar (Cliente cliente) {
		PedidoDAO pedidoDAO = new PedidoDAO ();
		List<Pedido> pedidos_aux = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		
		pedidos_aux = pedidoDAO.getPedidos();
		
		for(int i = 0; i < pedidos_aux.size(); i ++) {
			if(pedidos_aux.get(i).getCliente().getIDC() == cliente.getIDC()) {
				pedidos.add(pedidos_aux.get(i));
			}
		}

		return pedidos;
	}
}
