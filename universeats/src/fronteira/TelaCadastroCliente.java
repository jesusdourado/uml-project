package fronteira;

import java.util.Scanner;
import bean.Cliente;
import controle.CadastroCliente;
import utilitarios.ValidadorCPF;

public class TelaCadastroCliente {
	public void cadastrar() {
		Cliente cliente = new Cliente();
		CadastroCliente cadastro = new CadastroCliente();
		ValidadorCPF validadorCPF = new ValidadorCPF();
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("--- CADASTRO CLIENTE ---");
		
		System.out.println("Nome: ");
		cliente.setNome(leitor.nextLine());
		
		System.out.println("CPF: ");
		cliente.setCPF(leitor.nextLine());
		
		System.out.println("Matricula: ");
		cliente.setMatricula(leitor.nextLine());
		
		System.out.println("Senha: ");
		cliente.setSenha(leitor.nextLine());
		
		if(validadorCPF.isCPF(cliente.getCPF()) == true) {
			if(cadastro.Cadastrar(cliente) == true) {
				System.out.println("Cadastro efetuado!");
			}
			else {
				System.out.println("Erro no cadastro do cliente!");
			}
		}
		else {
			System.out.println("CPF inválido!");
		}
	}
}
