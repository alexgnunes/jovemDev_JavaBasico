package br.com.trier.banco;

public class Caixa {

	public void saque(ContaCorrente conta, double valor) {
		conta.saque(valor);
	}
	
	public void deposito(ContaCorrente conta, double valor) {
		conta.deposito(valor);
	}
	
}
