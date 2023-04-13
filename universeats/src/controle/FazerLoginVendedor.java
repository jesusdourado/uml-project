package controle;

import dao.VendedorDAO;
import bean.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class FazerLoginVendedor {
	public int logar (Vendedor vendedor) {
		VendedorDAO vendedorDAO = new VendedorDAO();
		List<Vendedor> vendedores = new ArrayList<>();
		boolean flag = false;

		vendedores = vendedorDAO.getVendedores();
		
		for(int i = 0; i < vendedores.size(); i ++) {
			if(vendedor.getCPF().equals(vendedores.get(i).getCPF())) {
				flag = true;
				if(vendedor.getSenha().equals(vendedores.get(i).getSenha())){
					System.out.println("Login realizado! Bem-vindo, " + vendedores.get(i).getNome() + "!");
					return vendedores.get(i).getIDV();
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
