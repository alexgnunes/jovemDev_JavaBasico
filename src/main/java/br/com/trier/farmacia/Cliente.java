package br.com.trier.farmacia;

import lombok.Getter;

@Getter
public class Cliente {

	private String nomeCliente;
	private double saldoDevedor;

	public Cliente(String nomeCliente, double saldoDevedor) {
		super();
		this.nomeCliente = nomeCliente;
		this.saldoDevedor = saldoDevedor;
	}

	public boolean isInadiplente(Cliente cliente, Produto produto, int qtdaPorduto) {
		if (cliente.saldoDevedor + -(produto.custoVenda(produto, qtdaPorduto)) < -300.0) {
			return true;
		}
		return false;
	}

	public void compraFarmacia(Double valorCompra) {
		saldoDevedor += -(valorCompra);
	}

	public void pagarDivida( Double valorPago) {
		saldoDevedor += valorPago;
	}

	public void pagarDividaTotal() {
		saldoDevedor = 0;
	}
}
