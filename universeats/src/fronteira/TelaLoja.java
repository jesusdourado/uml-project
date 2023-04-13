package fronteira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bean.Cliente;
import bean.Produto;
import controle.ListarProdutos;

public class TelaLoja {
	public void listar (Cliente cliente) {
		ListarProdutos listaProdutos = new ListarProdutos();
		List<Produto> produtos = new ArrayList<>();
		Scanner leitor = new Scanner(System.in);
		TelaPedido Tpedido = new TelaPedido();
		int id;
		
		produtos = listaProdutos.listar();
		
		System.out.println("--- LISTA DE PRODUTOS ---"
				+ "\n   ------------");
		
		for(int i = 0; i < produtos.size(); i ++) {
			System.out.println("   > Nome: " + produtos.get(i).getNome()
					       + "\n   > Preço: R$ " + produtos.get(i).getPreco()
					       + "\n   > ID: " + produtos.get(i).getIDPr()
					       + "\n   ------------");
		}
		
		System.out.println("Insira um ID para escolher: ");
		id = Integer.parseInt(leitor.nextLine());
		Tpedido.pedir(produtos.get(id - 1), cliente);
	}
}
