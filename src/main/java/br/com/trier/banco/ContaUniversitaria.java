package br.com.trier.banco;

public class ContaUniversitaria extends ContaCorrente {

	public ContaUniversitaria(int numero, int agencia, String nome, double saldo) {
		super(numero, agencia, nome, saldo);
	}

	@Override
	public boolean deposito(double valor) {
		if (saldo + valor <= 2000.0) {
			saldo += valor;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isDeposito (double valor) {
		if (saldo + valor <= 2000) {
			return true;				
		}
		return false;				
	}
}
