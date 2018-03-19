package prjConta2;

import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

	private static int MAX=10;
	private ArrayList <Conta> conta;
	private ArrayList <Cliente> cliente;
		
	public Banco(){
		conta = new ArrayList <Conta>(MAX);
		cliente = new ArrayList<Cliente>(MAX);
	}
	
	public static void main(String[] args) {
		int op=-1;
		int op2;
		int op3;
		Banco b = new Banco();
		Scanner in = new Scanner(System.in);
				
		
		while (op != 0)
		{
			System.out.println("----------MENU BANCO-----------------------------");
			System.out.println("----------1 - Menu cliente-----------------------");
			System.out.println("----------2 - Menu conta-------------------------");
			System.out.println("----------0 - Sair-------------------------------");
			op = in.nextInt();
			in.nextLine();
			op2=-1;
			op3=-1;
			
			switch (op){
						
			case 1:	while (op2 != 0)
					{
						System.out.println("----------MENU CLIENTE------------------------");
						System.out.println("----------1 - Novo cliente--------------------");
						System.out.println("----------2 - Deletar cliente-----------------");
						System.out.println("----------0 - Sair----------------------------");
						op2 = in.nextInt();
						in.nextLine();
						
						switch (op2)
						{	
						case 0:System.out.println("Fechando..."); 
							break;
						case 1: if (b.cliente.size() != MAX)
							{
								b.cliente.add(b.criaCliente());
								System.out.println("Cliente cadastrado com sucesso");
							}
							else
								System.out.println("Maximo de clientes atingidos");
							break;
							
						case 2://del cliente
							break;							
						}
					}
					break;
					
			case 2: while (op3 != 0)
			{
				System.out.println("----------MENU CONTA------------------------");
				System.out.println("----------1 - Nova conta--------------------");
				System.out.println("----------2 - Depositar na conta------------");
				System.out.println("----------3 - Retirar da conta--------------");
				System.out.println("----------4 - Alterar conta-----------------");
				System.out.println("----------5 - Excluir conta-----------------");
				System.out.println("----------6 - Ver conta---------------------");
				System.out.println("----------0 - Sair--------------------------");
				System.out.println("Selecione a opção.");
				op3 = in.nextInt();
				in.nextLine();
				
				switch(op3){
				
				case 0: 	System.out.println("Fechando..."); 
						break;
				case 1: if (b.conta.size() != MAX)
						{
							if (!b.cliente.isEmpty())
							{
								int QUAL;
								QUAL = b.pegaCliente();
								
								if (QUAL !=-1)
								{
									b.conta.add(b.criaConta(QUAL));
									System.out.println("Conta cadastrada com sucesso");
								}
								else
									System.out.println("Operação cancelada com sucesso.");
							}else
								System.out.println("Cadastre um cliente primeiro");
						}
						else
							System.out.println("Maximo de contas atingidas");
					break;
				case 2:  if (!b.conta.isEmpty())
						{
							System.out.println("Menu depositar.");
							int QUAL = b.pegaConta();
							if (QUAL != -1)
							{
								int quantidade = b.pegaQuantidade();
								b.conta.get(QUAL).deposito(quantidade);
								System.out.println("Depósito efetuado com sucesso, sua conta agora contém R$ "+ b.conta.get(QUAL).getSaldo());
							}
							else
								System.out.println("Operação cancelada");
						}
						else
							System.out.println("Cadastre uma conta primeiro");
					break;
				case 3:if (!b.conta.isEmpty()) 
						{
							System.out.println("Menu sacar.");
							int QUAL = b.pegaConta();
							if (QUAL != -1)
							{
								int quantidade = b.pegaQuantidade();
								if (quantidade <= b.conta.get(QUAL).getSaldo()+b.conta.get(QUAL).getLimite())
								{
									b.conta.get(QUAL).retirada(quantidade);
									System.out.println("Saque efetuada com sucesso, sua conta agora contém R$ "+ b.conta.get(QUAL).getSaldo());
								}
								else
									System.out.println("Quantidade insulficiente, voce só pode retirar "+ (b.conta.get(QUAL).getSaldo()+b.conta.get(QUAL).getLimite()) + " reais.");
							}
							else
								System.out.println("Operação cancelada");
						}
						else
							System.out.println("Cadastre uma conta primeiro");
					break;
				case 4: if (!b.conta.isEmpty())
						{
							System.out.println("Menu alterar conta.");
							int QUAL = b.pegaConta();
							if (QUAL != -1)
							{
								int limite;
								String cliente;
							
						//		System.out.println("Digite o nome do cliente");
						//		cliente = in.nextLine();
								
								System.out.println("Digite o limite da conta");
								limite = in.nextInt();
								in.nextLine();
														
							//	b.conta.get(QUAL).setCliente(cliente);
								b.conta.get(QUAL).setLimite(limite);
								
								System.out.println("Conta alterada com sucesso");
							}
							else
								System.out.println("Operação cancelada");
							
						}
						else
							System.out.println("Cadastre uma conta primeiro");
							break;
				case 5: if (!b.conta.isEmpty())
						{
							System.out.println("Menu Excluir conta.");
							int QUAL = b.pegaConta();
							if (QUAL != -1)
							{
								System.out.println("Conta "+ b.conta.get(QUAL).getCliente() +" excluida com sucesso.");
								b.conta.remove(QUAL);
							}
							else
								System.out.println("Operação cancelada");
						}
						else
							System.out.println("Cadastre uma conta primeiro");
						break;
				case 6: if (!b.conta.isEmpty()) 
						{
							//listaContas e infos
							for(Conta tmp: b.conta){
								System.out.println("Conta numero "+ tmp.getNumero());
								System.out.println("Nome do cliente: " + tmp.getCliente().getCpf());
								System.out.println("Tipo da conta: " +tmp.getTipoConta());
								System.out.println("Saldo: " + tmp.getSaldo());
								System.out.println("Limite: " + tmp.getLimite());
							}
						}
						else
							System.out.println("Cadastre uma conta primeiro");	 
					break;
				default :  System.out.println("Opção inválida");
							break;
				}
			}
		}
		}	
	}

	private int pegaQuantidade() {
		Scanner in = new Scanner(System.in);
		int quantidade = 0;
		
		System.out.println("Digite a quantidade");
		while (quantidade<1)
		{
			quantidade = in.nextInt();
			in.nextLine();	
		}
		return quantidade;
	}
	
	private Conta criaConta(int QUAL){
		int saldo, limite;
		String tipoConta;
		Cliente tmp;
		Scanner in = new Scanner(System.in);
		
			System.out.println("Criar conta");
			//Listar os clientes disponiveis e escolher 1
			tmp = cliente.get(QUAL);
			
			System.out.println("Digite o tipo da conta");
			tipoConta = in.nextLine();
			
			System.out.println("Digite o saldo da conta");
			saldo = in.nextInt();
			in.nextLine();
			
			System.out.println("Digite o limite da conta");
			limite = in.nextInt();
			in.nextLine();
			
			return new Conta(tmp,tipoConta,saldo,limite);	
	}
	
	private Cliente criaCliente(){
		String cpf, nome, endereco, email;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Criar cliente");
		
		System.out.println("Digite o cpf");
		cpf = in.nextLine();
		
		System.out.println("Digite o nome do cliente");
		nome = in.nextLine();
		
		System.out.println("Digite o endereco do cliente");
		endereco = in.nextLine();
		
		System.out.println("Digite o email do cliente");
		email = in.nextLine();
		
		return new Cliente(cpf,nome,endereco,email);
	}
	
	private int pegaConta() {
		//listaContas e nome cliente
		Scanner in = new Scanner(System.in);
		System.out.println("0 - Cancelar");
		for(Conta tmp: this.conta){
			System.out.println(tmp.getNumero() + " - " + tmp.getCliente().getNome());
		}
		//perguntaConta
		System.out.println("Digite qual conta deseja efetuar a operação1");
		boolean prossegue=false;
		int QUAL=0;

		while(!prossegue)
		{
			QUAL = in.nextInt();
			in.nextLine();
			if (QUAL == 0)
			{
				prossegue=true;
			}
			else
				for(Conta tmp: this.conta){
					if (QUAL == tmp.getNumero())
					{
						prossegue=true;
						break;
					}
				}
		}
		return QUAL-1;
	}
	
	private int pegaCliente() {
		//listaContas e nome cliente
		Scanner in = new Scanner(System.in);
		System.out.println("0 - Cancelar");
		int cont = 0;
		for(Cliente tmp: this.cliente){
			cont++;
			System.out.println(cont + " - " + tmp.getCpf());
		}
		//perguntaCliente
		System.out.println("Digite qual cliente da conta");
		boolean prossegue=false;
		int QUAL=0;

		while(!prossegue)
		{
			QUAL = in.nextInt();
			in.nextLine();
			if (QUAL == 0 || QUAL <= cont)
			{
				prossegue=true;
			}	
		}
		return QUAL-1;
	}
}
