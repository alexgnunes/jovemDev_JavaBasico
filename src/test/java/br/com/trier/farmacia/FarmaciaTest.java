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
		Cliente cComDiv = new Cliente("cliente 2", -300);
		
		farmacia.clientes.add(cSemDiv);
		farmacia.clientes.add(cComDiv);
		
		Medico medico = new Medico("medico");
		farmacia.medicos.add(medico);
		
		Produto perf = new Perfumaria("shampo", 10, 5.0);
		Produto med = new Medicamento("doril", 10, 10.0);
		Produto hosp = new Hospitalar("Sedativo", 10, 5.0);
		
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
	void vendeProdutoMedReceita() {
		assertTrue(farmacia.vendaProdutoReceita(farmacia.produtos.get(1),
				farmacia.clientes.get(0), 5, farmacia.medicos.get(0)));
		assertEquals(5, farmacia.produtos.get(1).getQuantidade());
		assertEquals(-50, farmacia.clientes.get(0).getSaldoDevedor());
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
	
	@Test
	void pagarDividaTotal() {
		farmacia.pagarDividaTotal(farmacia.clientes.get(1));
		assertEquals(0, farmacia.clientes.get(1).getSaldoDevedor());
	}
	
	@Test
	void listarTodosProdutos() {
		assertEquals(3,farmacia.listarProdutos().size());
	}
	@Test
	void listarProdutosPerfumaria() {
		assertEquals(1,farmacia.listarPerfumaria().size());
	}
	
	@Test
	void listarClientesDivida() {
		assertEquals(1,farmacia.clientesComDivida().size());
	}
	
	@Test
	void vendeProdutoHospitalarMaiorSaldo() {
		assertTrue(farmacia.vendaProduto(farmacia.produtos.get(2), farmacia.clientes.get(0), 15));
		assertEquals(-5, farmacia.produtos.get(2).getQuantidade());
		assertEquals(-75, farmacia.clientes.get(0).getSaldoDevedor());
	}
	
	@Test
	void vendeProdutoSemSaldoFalse() {
		assertFalse(farmacia.vendaProduto(farmacia.produtos.get(0), farmacia.clientes.get(0), 15));
		assertEquals(10, farmacia.produtos.get(0).getQuantidade());
		assertEquals(0, farmacia.clientes.get(0).getSaldoDevedor());
	}
}
