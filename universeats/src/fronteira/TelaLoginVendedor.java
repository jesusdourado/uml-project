package fronteira;

import bean.Vendedor;
import java.util.Scanner;
import utilitarios.ValidadorCPF;
import controle.FazerLoginVendedor;

public class TelaLoginVendedor {
	public Vendedor login() {
		Vendedor vendedor = new Vendedor();
		Scanner leitor = new Scanner(System.in);
		ValidadorCPF validadorCPF = new ValidadorCPF();
		FazerLoginVendedor autenticador = new FazerLoginVendedor();
		System.out.println("-- LOGIN VENDEDOR --");
			
		System.out.println("CPF: ");
		vendedor.setCPF(leitor.nextLine());

		System.out.println("Senha: ");
		vendedor.setSenha(leitor.nextLine());
			
		if(validadorCPF.isCPF(vendedor.getCPF())) {
			// Tentando autenticar o vendedor
			vendedor.setIDV(autenticador.logar(vendedor));
			
			if(vendedor.getIDV() != -1) {
				return vendedor;
			}
		}
		else {
			System.out.println("CPF inválido!");
		}
		return null;
	}
}
