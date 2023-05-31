package br.com.trier.medicamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.medicamento.Pessoa;
import br.com.trier.medicamento.entidades.Medicamento;

class PessoaTest {

	private Pessoa pessoa;
	private Medicamento med1;
	private Medicamento med2;


	@BeforeEach
	public void init() {
	
		
		med1 = new Medicamento("Med 1");
		med1.addIndicacao("Dor");
		med1.addContraIndicacao("Pressão alta");

		med2 = new Medicamento("Med 2");
		med2.addIndicacao("febre");
		
		pessoa = new Pessoa("pessoa 1", "Dor");
		pessoa.addCondicaoSaude("Diabetes");
		

	}

	@Test
	public void addCondicaoSaude() {
		pessoa.addCondicaoSaude("Pressao alta");
		assertEquals(2, pessoa.getCondicaoSaude().size());
	}
	
	@Test
	public void addMedicamentoTrue() {
		assertTrue(pessoa.addMedicamento(med1));
		assertEquals(1, pessoa.getMedicamentos().size());		
	}

	@Test
	public void addMedicamentoFalse() {
		assertFalse(pessoa.addMedicamento(med2));
		assertEquals(0, pessoa.getMedicamentos().size());		
	}
}
