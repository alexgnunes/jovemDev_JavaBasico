package br.com.trier.farmacia;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {

	List<Produto> produtos = new ArrayList<>();
	List<Cliente> clientes = new ArrayList<>();
	
	public void cadastroProduto(Produto produto) {
		produtos.add(produto);
	}

	public boolean VerificaVendaProduto(Produto produto, Cliente cliente,int qtdaPorduto) {
		if ( produto instanceof Perfumaria && cliente.isInadiplente(cliente, produto, qtdaPorduto)) {
			return false;
		}else if(produto.isSaldo(produto, qtdaPorduto)){
			return true;
		}
		return false;
	}
	
	public boolean vendaProduto(Produto produto, Cliente cliente, int qtdaPorduto) {
		if (VerificaVendaProduto(produto, cliente, qtdaPorduto)) {
			produto.diminueQuantidade(produto, qtdaPorduto);
			cliente.compraFarmacia(produto.custoVenda(produto, qtdaPorduto));
			return true;
		}
		return false;
	}
	
	public void pagarDivida(Cliente cliente, double valorPago) {
		cliente.pagarDivida(valorPago);
	}
}
