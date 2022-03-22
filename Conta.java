package desafioBanco;


public abstract class Conta implements IConta{
	
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	
	private static final int AGENCY_SEQUENCIAL = 1;
	private static int SEQUENCIAL = 1;
	
	
	public Conta(Cliente cliente) {
		this.agencia= Conta.AGENCY_SEQUENCIAL;
		this.numeroConta=Conta.SEQUENCIAL;
		this.cliente = cliente;
		this.saldo = 0.00;
	}

	@Override
	public void sacar(double valor) {
		if(valor > saldo || valor <= 0) {System.out.println("Digite um valor válido! \n \n");}
		else {
		this.saldo -= valor;
		System.out.println("Saque realizado com sucesos! \n");
		}
	}
	
	@Override
	public void depositar(double valor) {
		if(valor < 0) System.out.println("Valor a ser depositado é inválido! \n \n");
		else {
	     this.saldo+=valor;
	     
		}
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		
		if(valor > this.saldo || valor <= 0) System.out.println("Digite um valor válido!");
		else {
		this.sacar(valor);
		contaDestino.depositar(valor);
		System.out.println("Transferencia realizada com sucesos! \n");
		}
	}
		
	
	public int getAgencia() {
		return agencia;
	}

	public int getnumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void imprimirExtrato() {
		System.out.printf("Titular da conta: " + cliente.getNome() +"\n");
		System.out.printf("CPF: "+cliente.getCpf()+"\n");
		System.out.printf("Sua agência é: " + this.agencia+"\n");
		System.out.printf("O numéro da sua conta é: "+this.numeroConta+"\n");
		System.out.printf("Seu saldo é: " + getSaldo()+"\n\n\n");
	}



}
