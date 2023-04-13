package controle;

import java.sql.SQLException;

import bean.Produto;
import dao.ProdutoDAO;

public class FazerCadastroProduto {
	public boolean cadastrar (Produto produto) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		try {
			produtoDAO.cadastrarProduto(produto);
			return true;
		}
		catch(Error e) {
			return false;
		}
	}
}
