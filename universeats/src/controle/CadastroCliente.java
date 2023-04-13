package controle;

import dao.ClienteDAO;
import bean.Cliente;

public class CadastroCliente {	
	public boolean Cadastrar (Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			clienteDAO.cadastrarCliente(cliente);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
	
}
