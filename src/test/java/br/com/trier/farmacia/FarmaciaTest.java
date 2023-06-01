package br.com.trier.farmacia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FarmaciaTest {

	private Farmacia farmacia = new Farmacia();
	
	@BeforeEach 
	void init() {
		Cliente cSemDiv = new Cliente("cliente 1", 0);
		Cliente cComDiv = new Cliente("cliente 1", -300);
		
		farmacia.clientes.add(cSemDiv);
		farmacia.clientes.add(cComDiv);
		
		Produto perf = new Perfumaria("shampo", 10, 5.0);
		Produto med = new Medicamento("doril", 10, 5.0);
		Produto hosp = new Hospitalar("shampo", 10, 5.0);
		
		farmacia.produtos.add(perf);
		farmacia.produtos.add(med);
		farmacia.produtos.add(hosp);
		
	}
	@Test
	void cadastraProduto() {
		farmacia.cadastroProduto(farmacia.produtos.get(0));
		assertEquals(10, farmacia.produtos.get(0).getQuantidade());
	}
	
	@Test
	void vendeProdutoPerfOk() {
		assertTrue(farmacia.vendaProduto(farmacia.produtos.get(0), farmacia.clientes.get(0), 5));
		assertEquals(5, farmacia.produtos.get(0).getQuantidade());
		assertEquals(-25, farmacia.clientes.get(0).getSaldoDevedor());
	}
	
	@Test
	void vendeProdutoPerfComDivida() {
		assertFalse(farmacia.vendaProduto(farmacia.produtos.get(0), farmacia.clientes.get(1), 5));
		assertEquals(10, farmacia.produtos.get(0).getQuantidade());
	}
	
	@Test
	void pagarDivida() {
		farmacia.pagarDivida(farmacia.clientes.get(1), 300);
		assertEquals(0, farmacia.clientes.get(1).getSaldoDevedor());
	}
}
