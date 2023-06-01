package br.com.trier.farmacia;

import lombok.Getter;

@Getter
public class Produto {

	private String nomeProd;
	private int quantidade;
	private double valor;
		
	public Produto(String nomeProd, int estoque, double valor) {
		super();
		this.nomeProd = nomeProd;
		this.quantidade = estoque;
		this.valor = valor;
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
