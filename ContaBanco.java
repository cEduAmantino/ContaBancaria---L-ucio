import java.util.Scanner;

public class ContaBanco {
	Scanner ler = new Scanner(System.in);
	
	private int numConta;
	private String nomeAgencia;
	private int numAgencia;
	private String nomeBanco;
	private double saldo;
	private String tipo;
	private boolean status;

	public ContaBanco() {

	}
	
	public void menuPrincipal() {
		System.out.println("============================================");
		System.out.println("*****SEJA BEM-VINDO AO MENU PRINCIPAL*****");
		System.out.println("Escolha alguma das opções abaixo ↓↓");
		System.out.println("1 - Abrir Conta");
		System.out.println("2 - Fechar Conta");
		System.out.println("3 - Consultar Saldo");
		System.out.println("4 - Depositar Valor");
		System.out.println("5 - Sacar Valor");
		System.out.println("6 - Estado Atual");
		System.out.println("7 - Sair");
		System.out.println("============================================");
		int opDigitada = ler.nextInt();
		
		switch (opDigitada) {
		case 1:
			abrirConta();
			break;

		case 2:
			fecharConta();
			break;
			
		case 3:
			consultar();
			break;
		
		case 4:
			depositar();
			break;
					
		case 5:
			sacar();
			break;
			
		case 6:
			estadoAtual();
			break;
			
		case 7:
			System.out.println("Saindo...");
			System.exit(0);
			break;
		}
		
	}
	
	
//	ABRIR CONTA
	public void abrirConta() {

		this.setStatus(true);
		System.out.println("===Abertura de conta===");
		System.out.println(" 1 - Conta Corrente\n 2 - Conta Poupança\n 3 - Conta Conjunta");

		System.out.println("Escolha uma das opções a cima");
		int valorDigitado = ler.nextInt();

//ler CHAR char valorDigitado = ler.next().charAt(0);				

		switch (valorDigitado) {
		case 1:
			System.out.println("=====CONFIGURANDO A CONTA CORRENTE=====");
			System.out.println("Informe a Localidade da Agência");
			this.setNomeAgencia(ler.next());

			System.out.println("Informe o numero da Agência");
			this.setNumAgencia(ler.nextInt());
			ler.nextLine();

			System.out.println("Informe o nome do Banco");
			this.setNomeBanco(ler.next());

			System.out.println("Informe o numero da Conta");
			this.setNumConta(ler.nextInt());
			ler.nextLine();

			this.setSaldo(0);
			this.setTipo("Conta Corrente");
			System.out.println("Conta Corrente aberta com sucesso!!");
			
			System.out.println("===================================");
			optar();
			
			break;

		case 2:
			System.out.println("=====CONFIGURANDO A CONTA POUPANÇA=====");
			System.out.println("Informe a Localidade da Agência");
			this.setNomeAgencia(ler.next());

			System.out.println("Informe o numero da Agência");
			this.setNumAgencia(ler.nextInt());
			ler.nextLine();

			System.out.println("Informe o nome do Banco");
			this.setNomeBanco(ler.next());

			System.out.println("Informe o numero da Conta");
			this.setNumConta(ler.nextInt());
			ler.nextLine();

			this.setSaldo(0);
			this.setTipo("Conta Poupança");
			System.out.println("Conta Poupança aberta com sucesso!!");
			
			System.out.println("===================================");
			optar();
			
			break;

		case 3:
			System.out.println("=====CONFIGURANDO A CONTA CONJUNTA=====");
			System.out.println("Informe a Localidade da Agência");
			this.setNomeAgencia(ler.next());

			System.out.println("Informe o numero da Agência");
			this.setNumAgencia(ler.nextInt());
			ler.nextLine();

			System.out.println("Informe o nome do Banco");
			this.setNomeBanco(ler.next());

			System.out.println("Informe o numero da Conta");
			this.setNumConta(ler.nextInt());
			ler.nextLine();

			this.setSaldo(0);
			this.setTipo("Conta Cojunta");

			this.setSaldo(0);
			System.out.println("Conta Conjunta aberta com sucesso!!");
			
			System.out.println("===================================");
			optar();
			
			break;
		}
	}

//	FECHAR CONTA
	public void fecharConta() {
		System.out.println("=====FECHAMENTO DE CONTA=====");
		if (this.getSaldo() > 0) {
			System.out.println("Zere o saldo primeiro, para fechamento da conta!!");
			System.out.println("Deseja realizar o saque?");
			
			System.out.println("[S]im // [N]ão");
			char op = ler.next().toUpperCase().charAt(0);

			if (op == 'S') {
				sacar();
			} else {
				System.out.println("Saque cancelado!");
			}
			
		} else if (this.getSaldo() < 0) {
			System.out.println("Conta com saldo negativo, quite a dívida primeiro!!");
			
			System.out.println("===================================================");
			optar();
			
		} else {
			this.setStatus(false);
			this.setSaldo(0);
			System.out.println(this.getTipo() + "fechada com sucesso!!");
			
			System.out.println("======================================");
			optar();
		}
	}

//	CONSULTAR SALDO
	public void consultar() {
		System.out.println("=====CONSULTANDO SALDO=====");
		System.out.println("Saldo atual: " + this.getSaldo());
		
		System.out.println("===========================");
		
		optar();
	}

//	DEPOSITAR
	public void depositar() {
		System.out.println("=====DEPOSITANDO VALOR=====");
		if (this.isStatus() == true) {
			System.out.println("Digite o valor do deposito");
			double valorDeposito = ler.nextDouble();

			this.setSaldo(this.getSaldo() + valorDeposito);

			System.out.println("Deposito de: " + valorDeposito + " R$" + " realizado com sucesso!");
			
			optar();
		}else {
			System.out.println("Conta Inexistente para Depósito!!");
			
			System.out.println("===========================");
			
			optar();
		}
	}

//	SACAR
	public void sacar() {
		System.out.println("=====SACANDO VALOR=====");
		
		if (this.isStatus() == true && this.getSaldo() > 0) {
			System.out.println("Digite o valor que deseja sacar");
			double valorSaque = ler.nextDouble();
			
			if (valorSaque <= this.getSaldo()) {
				this.setSaldo(this.getSaldo() - valorSaque);
				System.out.println("Saque de: " + valorSaque + " R$" + " realizado com sucesso!");
				System.out.println("Saldo atual: " + this.getSaldo() + " R$");
				
				System.out.println("===================================");
				optar();
				
			} else {
				System.out.println("Não é possivel sacar um valor maior que seu saldo atual!");
				
				System.out.println("===================================");
				optar();
			}
		}else {
			System.out.println("Conta Inexistente para Saque!!");
			
			System.out.println("===================================");
			optar();
		}
	}
	
//	ESTADO ATUAL DA CONTA
	public void estadoAtual() {
		System.out.println("============================");
		System.out.println("=====ESTADO ATUAL DA CONTA=====");
		System.out.println("Conta: " + this.getNumConta());
		System.out.println("Localidade Agência: " + this.getNomeAgencia());
		System.out.println("Numero Agência: " + this.getNumAgencia());
		System.out.println("Nome Banco: " + this.getNomeBanco());
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println("Tipo: " + this.getTipo());		
		System.out.println("Status: " + this.isStatus());
		
		optar();
	}
	
//	OPÇÃO DE CONTINUAR OU NÃO
	public void optar() {
		System.out.println("Deseja realizar mais operações?");
		System.out.println("[S]im // [N]ão");
		char op = ler.next().toUpperCase().charAt(0);
		
		if (op == 'S') {
			menuPrincipal();
		} else {
			System.out.println("Saindo...");
			System.exit(0);
		}
	}
	
	

//	Getters e Setters
	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	public int getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
