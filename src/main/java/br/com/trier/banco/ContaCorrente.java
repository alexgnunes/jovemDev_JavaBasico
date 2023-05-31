package br.com.trier.banco;

import lombok.Getter;


public class ContaCorrente {
	
	private int numero;
	private int agencia;
	private String nome;
	@Getter protected double saldo;
	
	public ContaCorrente(int numero, int agencia, String nome, double saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public boolean saque (double valor) {
		if (saldo - valor >= 0) {
			saldo -= valor;
			return true;				
		}
		return false;				
	}
	
	public boolean deposito (double valor) {
		saldo += valor;
		return true;				
	}	
}
