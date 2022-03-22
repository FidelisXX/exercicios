package desafioBanco;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		
		//criação do usuario principal
		Cliente cli1 = new Cliente();
		System.out.println("Digite o seu nome: ");
		cli1.setNome(leitor.next());
		System.out.println("Digite o seu CPF: ");
		cli1.setCpf(leitor.next());	
		Conta cc = new ContaCorrente(cli1);
		Conta pp = new ContaPoupanca(cli1);
		
		//cliente criado para realização da transferencia
		Cliente cli2 = new Cliente();
		cli2.setNome("userTeste");
		cli2.setCpf("1111111111");
		
		//conta criada para realização da transferencia
		Conta cc1 = new ContaCorrente(cli2);
		Conta pp1 = new ContaCorrente(cli2);
		
		
		//menu de informações
		boolean menu = true;
		while(menu = true) {
			System.out.println("===============Bem vindo Sr(a) "+ cli1.getNome()+"=============");
			System.out.println("Digite 1 para ver o saldo");
			System.out.println("Digite 2 para sacar CC");
			System.out.println("Digite 3 para sacar PP");
			System.out.println("Digite 4 para transferir CC");
			System.out.println("Digite 5 para transferir PP");
			System.out.println("Digite 6 para depositar CC");
			System.out.println("Digite 7 para depositar PP");
			System.out.println("Digite 0 para finalizar");
			System.out.println("================================================================");
			int escolha = leitor.nextInt();
		switch(escolha) {		
		case 1:
			System.out.println("========== EXTRATO DA CONTA CORRENTE========");
			cc.imprimirExtrato();
			System.out.println("========== EXTRATO DA CONTA POUPANCA========");
			pp.imprimirExtrato();
			break;
		case 2:
			System.out.println("Digite o valor a ser sacado: ");
			cc.sacar(leitor.nextDouble());
			System.out.println("Saque realizado com sucesos! \n");
			break;
		case 3:
			System.out.println("Digite o valor a ser sacado: ");
			pp.sacar(leitor.nextDouble());
			System.out.println("Saque realizado com sucesos! \n");
			break;
		case 4:
			System.out.println("Digite o valor a ser transferido: ");
			cc.transferir(leitor.nextDouble(), cc1);
			break;
		case 5:
			System.out.println("Digite o valor a ser transferido: ");
			pp.transferir(leitor.nextDouble(), pp1);
			break;
		case 6:
			System.out.println("Digite o valor a ser depositado: ");
			cc.depositar(leitor.nextDouble());
			System.out.println("Deposito realizado com sucesos! \n");
			break;
		case 7: 
			System.out.println("Digite o valor a ser depositado: ");
			pp.depositar(leitor.nextDouble());
			System.out.println("Deposito realizado com sucesos! \n");
		case 0:
			System.out.println("Consulta finalizada!");
			return;
		}
		
		}
	
		leitor.close();
	}

}
