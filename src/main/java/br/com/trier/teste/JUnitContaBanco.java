package br.com.trier.teste;

import lombok.Getter;

@Getter
public class JUnitContaBanco {

	private int id;
	private double saldo;
	
	public JUnitContaBanco() {
		super();
	}
	
	public JUnitContaBanco(int id, double saldo) {
		super();
		this.id = id;
		this.saldo = saldo;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	public void saque(double quantia) {
		saldo -= quantia;
	}
	public double saqueTotal() {
		double aux = saldo;
		saldo = 0;
		return aux;
	}

	
}
