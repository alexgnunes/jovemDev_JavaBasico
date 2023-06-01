package br.com.trier.farmacia;

public class Medicamento extends Produto{
	
	private boolean receita;	

	public Medicamento(String nomeProd, int estoque, double valor) {
		super(nomeProd, estoque, valor);
	}
}
