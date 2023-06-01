package br.com.trier.banco;

public class Caixa {

	public void saque(ContaCorrente conta, double valor) {
		conta.saque(valor);
	}
	
	public void deposito(ContaCorrente conta, double valor) {
		conta.deposito(valor);
	}
	
	public boolean transferencia(ContaCorrente contaOrigem, ContaCorrente contaDest, double valor) {
		if(contaOrigem.isSaque(valor) && contaDest.isDeposito(valor)) {
			contaOrigem.saque(valor);
			contaDest.deposito(valor);
			return true;
		}
		return false; 
	}
	
}
