package fronteira;

import java.util.Scanner;

import bean.Cliente;
import controle.FazerLoginCliente;
import utilitarios.ValidadorCPF;

public class TelaLoginCliente {
	public Cliente login () {
		Cliente cliente = new Cliente();
		Scanner leitor = new Scanner(System.in);
		ValidadorCPF validadorCPF = new ValidadorCPF();
		FazerLoginCliente autenticador = new FazerLoginCliente();
		System.out.println("-- LOGIN CLIENTE --");
			
		System.out.println("CPF: ");
		cliente.setCPF(leitor.nextLine());
			
		System.out.println("Senha: ");
		cliente.setSenha(leitor.nextLine());
		
		if(validadorCPF.isCPF(cliente.getCPF())) {
			// Tentando autenticar o vendedor
			cliente.setIDC(autenticador.logar(cliente));
			
			if(cliente.getIDC() != -1) {
				return cliente;
			}
		}
		else {
			System.out.println("CPF inválido!");
		}
		return null;
	}
}