package br.com.trier.medicamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicamentoTest {
	private Medicamento medicamento;
	
	@BeforeEach
	public void init() {
		List<String> condicaoSaude = new ArrayList();
		condicaoSaude.add("Diabetes");
		 
		medicamento = new Medicamento("Med 1");
		medicamento.addIndicacao("Dor");
		medicamento.addContraIndicacao("Pressão alta");
		medicamento.addContraIndicacao("Diabetes");
	}

	@Test
	void adicionaIndicacao() {
		medicamento.addIndicacao("Dor");
		assertEquals(2, medicamento.getIndicacoes().size());
	}

	@Test
	void adicionaContraIndicacao() {
		medicamento.addContraIndicacao("diabetes");
		assertEquals(3, medicamento.getContraIndicacoes().size());
	}
	
	@Test
	void verificaMedicamentoIndicadoOK() {
		assertTrue(medicamento.isIndicado("Dor"));
	}
	@Test
	void verificaMedicamentoIndicadoFalse() {
		assertFalse(medicamento.isIndicado("enjoo"));
	}
	
	@Test
	void verificaMedicamentoContraIndicadoTrue() {
		assertTrue(medicamento.contraIndicacoes.contains("Diabetes"));
	}
	
	@Test
	void verificaMedicamentoContraIndicadoFalse() {
		assertFalse(medicamento.contraIndicacoes.contains("gravidez"));
	}
}
