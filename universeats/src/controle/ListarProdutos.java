package controle;

import java.util.List;
import bean.Produto;
import dao.ProdutoDAO;

public class ListarProdutos {
	public List<Produto> listar(){
		ProdutoDAO produtoDAO = new ProdutoDAO ();
		
		return produtoDAO.getProdutos();
	}
}
