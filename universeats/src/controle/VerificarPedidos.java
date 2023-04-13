package controle;

import java.util.ArrayList;
import java.util.List;
import bean.Pedido;
import bean.Vendedor;
import dao.PedidoDAO;

public class VerificarPedidos {
	public List<Pedido> verificar(Vendedor vendedor) {
		PedidoDAO pedidoDAO = new PedidoDAO ();
		List<Pedido> pedidos_aux = new ArrayList<>();
		List<Pedido> pedidos = new ArrayList<>();
		
		pedidos_aux = pedidoDAO.getPedidos();
		
		for(int i = 0; i < pedidos_aux.size(); i ++) {
			if(pedidos_aux.get(i).getVendedor().getIDV() == vendedor.getIDV()) {
				pedidos.add(pedidos_aux.get(i));
			}
		}
		
		return pedidos;
	}
}
