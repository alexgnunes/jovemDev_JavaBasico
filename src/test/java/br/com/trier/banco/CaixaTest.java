package br.com.trier.banco;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaixaTest {
	private Caixa caixa = new Caixa();
	List<ContaCorrente> contas = new ArrayList<>();
	
	@BeforeEach
	void init() {
		ContaCorrente corrente = new ContaCorrente(10, 123, "nome 1", 100);
		ContaCorrente especial = new ContaEspecial(20, 456, "nome 2", 100, 100);
		ContaCorrente universitaria = new ContaUniversitaria(30, 789, "nome 3", 100);
		
		contas.add(corrente);
		contas.add(especial);
		contas.add(universitaria);
	}
	
	
	@Test
	void saqueCorrenteTrue() {
		assertTrue(contas.get(0).saque(100));
		assertEquals(0, contas.get(0).getSaldo());
	}

	@Test
	void saqueCorrenteFalse() {
		assertFalse(contas.get(0).saque(200));
	}
	
	@Test
	void saqueEspecialTrue() {
		assertTrue(contas.get(1).saque(150));
		assertEquals(-50, contas.get(1).getSaldo());
	}

	@Test
	void saqueEspecialFalse() {
		assertFalse(contas.get(1).saque(300));
	}
	
	@Test
	void saqueUniversitariaTrue() {
		assertTrue(contas.get(2).saque(100));
		assertEquals(0, contas.get(2).getSaldo());
	}

	@Test
	void saqueUniversitariaFalse() {
		assertFalse(contas.get(2).saque(300));
	}
	
	@Test
	void depositoUniversitariatrue() {
		assertTrue(contas.get(2).deposito(100));
		assertEquals(200, contas.get(2).getSaldo());
	}
	
	@Test
	void depositoUniversitariaFalse() {
		assertFalse(contas.get(2).deposito(10000));
	}
	
	@Test
	void depositoCorrenteTrue() {
		assertTrue(contas.get(0).deposito(100));
		assertEquals(200, contas.get(0).getSaldo());
	}
}
