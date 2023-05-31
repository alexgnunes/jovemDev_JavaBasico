package br.com.trier.medicamentoTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.medicamento.Pessoa;
import br.com.trier.medicamento.entidades.Medicamento;
import br.com.trier.medicamento.repository.BancoDadosPrescricao;

public class BancoDadosPrescricaoTests {

	private BancoDadosPrescricao bd = new BancoDadosPrescricao();
	
	@BeforeEach
	public void init() { 
	
		bd.getMedicamentos().clear();
		bd.getPessoas().clear();
		
		Pessoa p1 = new Pessoa("Pessoa 1", "Gripe");
		p1.addCondicaoSaude("Dengue");
		p1.addCondicaoSaude("Diabetes");
		Pessoa p2 = new Pessoa("Pessoa 2", "Dor");
		bd.cadastraPessoa(p1);
		bd.cadastraPessoa(p2);
		
		Medicamento m1 = new Medicamento("Med 1");
		m1.addIndicacao("Dor");
		m1.addContraIndicacao("Pressão alta");
		
		Medicamento m2 = new Medicamento("Med 2");
		m2.addIndicacao("Gripe");
		m2.addIndicacao("Febre");
		m2.addContraIndicacao("Dengue");
		
		Medicamento m3 = new Medicamento("Med 3");
		m3.addIndicacao("Gripe");
		
		bd.cadastraMedicamento(m1);
		bd.cadastraMedicamento(m2);
		bd.cadastraMedicamento(m3);
		
	}
	
	@Test
	public void preescreveOK(){
		Pessoa p = bd.getPessoas().get(0);
		Medicamento m = bd.getMedicamentos().get(2);
		boolean prescrito = bd.prescreveMedicamento(p, m);
		assertEquals(true, prescrito);
		assertEquals(1, p.getMedicamentos().size());
		assertEquals("Med 3", p.getMedicamentos().get(0).getNomeMedicamento());
	}
	
	@Test
	public void preescreveFalhaIndicacao(){
		Pessoa p = bd.getPessoas().get(0);
		Medicamento m = bd.getMedicamentos().get(0);
		boolean prescrito = bd.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	public void preescreveFalhaContraIndicacao(){
		Pessoa p = bd.getPessoas().get(0);
		Medicamento m = bd.getMedicamentos().get(1);
		boolean prescrito = bd.prescreveMedicamento(p, m);
		assertEquals(false, prescrito);
		assertEquals(0, p.getMedicamentos().size());
	}
	
	@Test
	public void cadastraPessoaOK() {
		Pessoa p = bd.getPessoas().get(0);
		bd.cadastraPessoa(p);
		assertEquals(3,bd.getPessoas().size());
		assertEquals(true, bd.cadastraPessoa(p));
		
	}
	
	@Test
	public void cadastraPessoaNull() {
		Pessoa p = null;;
		bd.cadastraPessoa(p);
		assertEquals(2,bd.getPessoas().size());
		assertEquals(false, bd.cadastraPessoa(p));		
	}
	
	@Test
	public void cadastraMedicamento() {
		Medicamento m = bd.getMedicamentos().get(0);
		bd.cadastraMedicamento(m);
		assertEquals(4,bd.getMedicamentos().size());	
	}
	
	@Test
	public void existePessoaTrue() {
		assertTrue(bd.existePessoa(bd.getPessoas().get(0))); 
	}
	
	@Test
	public void existeMedicamentoTrue() {
		assertTrue(bd.existeMedicamento(bd.getMedicamentos().get(0))); 
	}
	
	@Test
	public void preescreveMedicamentoOk() {
		Pessoa p = bd.getPessoas().get(0);
		Medicamento m = bd.getMedicamentos().get(2);
		bd.prescreveMedicamento(p, m);
		assertTrue(p.addMedicamento(m));
	}
	
//	@Test
//	public void existePessoaFalse() {
//		assertEquals(null,bd.existePessoa(bd.getPessoas().get(2)));
//	}
}
