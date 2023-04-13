package fronteira;

import java.util.Scanner;
import bean.Cliente;
import bean.Produto;
import controle.VCP;

public class TelaPedido {
	public void pedir(Produto produto, Cliente cliente) {
		VCP vcp = new VCP();
		Scanner leitor = new Scanner(System.in);
		String opcao;
		
		System.out.println("--- PRODUTO ---");
		
		System.out.println("   > Nome: " + produto.getNome()
			       + "\n   > Descrição: " + produto.getDescricao()
			       + "\n   > Preço: R$ " + produto.getPreco()
			       + "\n   > ID: " + produto.getIDPr()
			       + "\n   > ID Vendedor: " + produto.getVendedor().getIDV());
		
		System.out.println("Deseja pedir esse produto? ");
		opcao = leitor.nextLine();
		
		if(opcao.equals("sim")) {
			System.out.println("Informe a quantidade: ");
			opcao = leitor.nextLine();
			if(Integer.parseInt(opcao) > 0) {
				vcp.adicionarPedido(cliente, produto, Integer.parseInt(opcao));
				
				System.out.println("Pedido realizado!");
			}
			else {
				System.out.println("Quantidade inválida!");
			}
		}
		else if(opcao.equals("não")) {
		}
		else {
			System.out.println("Opção inválida!");
		}
	}
}
