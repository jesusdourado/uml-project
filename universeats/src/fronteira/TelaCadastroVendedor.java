package fronteira;

import java.util.Scanner;
import bean.Vendedor;
import controle.CadastroVendedor;
import utilitarios.ValidadorCPF;

public class TelaCadastroVendedor {
	public void cadastro() {
		Vendedor vendedor = new Vendedor();
		CadastroVendedor cadastro = new CadastroVendedor();
		ValidadorCPF validadorCPF = new ValidadorCPF();
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("-- CADASTRO VENDEDOR--");
		
		System.out.println("Nome: ");
		vendedor.setNome(leitor.nextLine());
		
		System.out.println("CPF: ");
		vendedor.setCPF(leitor.nextLine());
		
		System.out.println("Matricula: ");
		vendedor.setMatricula(leitor.nextLine());
		
		System.out.println("Senha: ");
		vendedor.setSenha(leitor.nextLine());
		
		if(validadorCPF.isCPF(vendedor.getCPF()) == true) {
			if(cadastro.cadastrar(vendedor) == true) {
				System.out.println("Cadastro efetuado!");
			}
			else {
				System.out.println("Erro no cadastro do vendedor!");
			}
		}
		else {
			System.out.println("CPF inválido");
		}
	}
}
