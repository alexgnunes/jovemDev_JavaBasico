package br.com.trier.farmacia;

public class Hospitalar extends Produto{

	public Hospitalar(String nomeProd, int estoque, double valor) {
		super(nomeProd, estoque, valor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isSaldo( Produto produto, int qtdaPorduto) {
		return true;
	}
	
}
