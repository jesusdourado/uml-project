package controle;

import java.util.ArrayList;
import java.util.List;
import bean.Cliente;
import dao.ClienteDAO;

public class FazerLoginCliente {
	public int logar (Cliente cliente) {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = new ArrayList<>();
		boolean flag = false;

		clientes = clienteDAO.getClientes();
		
		for(int i = 0; i < clientes.size(); i ++) {
			if(cliente.getCPF().equals(clientes.get(i).getCPF())) {
				flag = true;
				if(cliente.getSenha().equals(clientes.get(i).getSenha())){
					System.out.println("Login realizado! Bem-vindo, " + clientes.get(i).getNome() + "!");
					return clientes.get(i).getIDC();
				}
				else {
					System.out.println("Senha incorreta!");
				}
			}
		}
		
		if(flag == false) {
			System.out.println("Conta não existe!");
		}
		
		return -1;
	}
}
