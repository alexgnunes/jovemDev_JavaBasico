package br.com.trier.banco;

public class ContaEspecial extends ContaCorrente{

	private double limite;
	
	public ContaEspecial(int numero, int agencia, String nome, double saldo, double limite) {
		super(numero, agencia, nome, saldo);
		this.limite = limite;
	}
	
	@Override
	public boolean saque(double valor) {
		double limTotal = saldo + limite;
		if (limTotal - valor >= 0) {
			saldo -= valor;
			return true;				
		}
		return false;	
	}
}
