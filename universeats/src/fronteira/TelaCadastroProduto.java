package fronteira;

import java.util.Scanner;
import bean.Produto;
import bean.Vendedor;
import controle.FazerCadastroProduto;

public class TelaCadastroProduto {
	
	public void cadastrar (Vendedor vendedor) {
		Produto produto = new Produto();
		FazerCadastroProduto cadastroProduto = new FazerCadastroProduto();
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("--- CADASTRO PRODUTO ---");
		
		System.out.println("Nome do produto: ");
		produto.setNome(leitor.nextLine());
		
		System.out.println("Descrição do produto: ");
		produto.setDescricao(leitor.nextLine());
		
		System.out.println("Valor do produto: ");
		produto.setPreco(Double.parseDouble(leitor.nextLine()));
		System.out.println(produto.getPreco());
		
		produto.setVendedor(vendedor);
		
		if(cadastroProduto.cadastrar(produto)) {
			System.out.println("O produto " + produto.getNome() + " foi cadastrado!");	
		}
		else {
			System.out.println("Erro ao cadastrar o produto!");
		}
	}
}
