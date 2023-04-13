package main;

import java.util.Scanner;
import bean.*;
import fronteira.*;
import utilitarios.ValidadorCPF;

public class Principal {
	public static void main(String[] args) {
		
		// Declarando classes principais
		Scanner leitor = new Scanner(System.in);
			
		// Classes de Entidade
		Cliente clienteAtual = new Cliente();
		Vendedor vendedorAtual = new Vendedor();
		
		// Classes de Fronteira
		TelaCadastroCliente TcadastroCliente = new TelaCadastroCliente();
		TelaCadastroVendedor TcadastroVendedor = new TelaCadastroVendedor();
		TelaLoginVendedor TloginVendedor = new TelaLoginVendedor();
		TelaLoginCliente TloginCliente = new TelaLoginCliente();
		TelaLogoff TLogoff = new TelaLogoff();
		TelaCadastroProduto TcadastroProduto = new TelaCadastroProduto();
		TelaLoja Tloja = new TelaLoja();
		TelaPedidos Tpedidos = new TelaPedidos();
		TelaNotificacoes Tnotificacoes = new TelaNotificacoes();
		
		// Declarando utilitários
		ValidadorCPF validadorCPF = new ValidadorCPF();
		
		// Simulando 2 computadores diferentes
		System.out.println("Você é Cliente ou Vendedor?");
		String user = leitor.next();
		String opcao = "1";
		
		if(user.equals("cliente")) { // Se o usuário for Cliente
			while (!opcao.equals("3")) {
				System.out.println("--- MENU - Cliente ---"
						+ "\n1 - Login"
						+ "\n2 - Cadastrar"
						+ "\n3 - Sair");
				
				opcao = leitor.next();
				
				if(opcao.equals("1")) {
					// Login do Cliente
					clienteAtual = TloginCliente.login();
					if(clienteAtual != null) {
						// Menu principal do Cliente
						
						while(!opcao.equals("3")) {
							System.out.println("----- MENU PRINCIPAL - Cliente -----" 
									+ "\n1 - Loja de produtos"
									+ "\n2 - Meus pedidos"
									+ "\n3 - Sair");
							opcao = leitor.next();
							
							if(opcao.equals("1")) {
								// Loja de Produtos
								Tloja.listar(clienteAtual);
								
							}
							else if(opcao.equals("2")) {
								// Meus pedidos
								Tpedidos.mostrar(clienteAtual);
							}
							else if(opcao.equals("3")) {
								// Sair - Fazer logoff
								TLogoff.logoff();
							} 
							else {
								System.out.println("Opcao inválida!");
							}
						}
						opcao = "4";
					}			
				}
				else if(opcao.equals("2")) {
					// Cadastrar um novo Cliente
					TcadastroCliente.cadastrar();
				}
				else if(opcao.equals("3")){
					System.out.println("Sessão de cliente encerrada!");
				}
				else {
					System.out.println("Opção inválida!");
				}
			}
		}
		else if(user.equals("vendedor")) {
			while(!opcao.equals("3")) {
				System.out.println("--- MENU - Vendedor ---"
						+ "\n1 - Login"
						+ "\n2 - Cadastrar"
						+ "\n3 - Sair");
				
				opcao = leitor.next();
				
				if(opcao.equals("1")) {
					// Login do Vendedor
					vendedorAtual = TloginVendedor.login();
					if(vendedorAtual != null) {
						// Menu principal do Vendedor
						while(!opcao.equals("3")) {
							System.out.println("----- MENU PRINCIPAL - Vendedor -----" 
									+ "\n1 - Cadastrar Produto"
									+ "\n2 - Tela de Notificações"
									+ "\n3 - Sair");
						
							opcao = leitor.next();
							
							if(opcao.equals("1")) {
								TcadastroProduto.cadastrar(vendedorAtual);
							}
							else if(opcao.equals("2")) {
								Tnotificacoes.mostrar(vendedorAtual);
							}
							else if(opcao.equals("3")) {
								TLogoff.logoff();
							}
							else {
								System.out.println("Opção inválida!");
							}
						}
						opcao = "4";
					}
				}
				else if(opcao.equals("2")) {
					// Cadastro do Vendedor
					TcadastroVendedor.cadastro();
				}
				else if(opcao.equals("3")){
					System.out.println("Sessão do vendedor encerrada!");
				}
				else {
					System.out.println("Opção inválida!");
				}		
			}
		}
		
		// Fechando o leitor
		leitor.close();
	}

}
