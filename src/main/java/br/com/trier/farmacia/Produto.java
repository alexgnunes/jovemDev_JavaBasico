package br.com.trier.farmacia;

import lombok.Getter;

@Getter
public class Produto {

	private String nomeProd;
	private int quantidade;
	private double valor;
	
	public Produto() {		
	}
	
	public Produto(String nomeProd, int estoque, double valor) {
		super();
		this.nomeProd = nomeProd;
		this.quantidade = estoque;
		this.valor = valor;
	}
	
	public Produto(String string, int i, double d, boolean b, String string2) {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isSaldo( Produto produto, int qtdaPorduto) {
		if (produto.getQuantidade() >= qtdaPorduto) {
			return true;			
		}
		return false;
	}

	public double custoVenda(Produto produto, int qtdaPorduto) {
		return produto.getValor() * qtdaPorduto;
	}

	public void diminueQuantidade(Produto produto, int qtdaPorduto) {
		produto.quantidade -= qtdaPorduto;
		
	}
	
}
