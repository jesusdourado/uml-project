package controle;

import bean.Vendedor;
import dao.VendedorDAO;;

public class CadastroVendedor {
	public boolean cadastrar(Vendedor vendedor) {
		VendedorDAO vendedorDAO = new VendedorDAO();
		try {
			vendedorDAO.cadastrarVendedor(vendedor);
			return true;
		}
		catch(Error e){
			return false;
		}
	}
}
