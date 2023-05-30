package br.com.trier.medicamentoTests;

import br.com.trier.medicamento.Pessoa;
import br.com.trier.medicamento.enuns.EnumAdministracao;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.medicamento.Medicamento;
import br.com.trier.medicamento.repository.BancoDadosPrescricao;

public class BancoDadosPrescricaoTests {

	private BancoDadosPrescricao bd = new BancoDadosPrescricao();

	@BeforeEach
	void init() {
		Pessoa p1 = new Pessoa("pessoa 1", "gripe", new ArrayList());
		Pessoa p2 = new Pessoa("pessoa 2", "febre", new ArrayList());
		Pessoa p3 = new Pessoa("pessoa 3", "dengue", new ArrayList());

		String alergia1 = "Alergia 1";
		String alergia2 = "Alergia 2";
		String alergia3 = "Alergia 3";

		p1.getAlergiasPessoa().add(alergia1);
		p1.getAlergiasPessoa().add(alergia2);
		p1.getAlergiasPessoa().add(alergia3);

		p2.getAlergiasPessoa().add(alergia3);
		p2.getAlergiasPessoa().add(alergia2);

		p3.getAlergiasPessoa().add(alergia1);

		Medicamento m1 = new Medicamento("doril", EnumAdministracao.ORAL, new ArrayList<String>(),
				new ArrayList<String>());
		Medicamento m2 = new Medicamento("benegripe", EnumAdministracao.ORAL, new ArrayList<String>(),
				new ArrayList<String>());

		m1.getIndicacoes().add("febre");
		m1.getIndicacoes().add("dengue");
		m2.getIndicacoes().add("gripe");

		m1.getAlergias().add(alergia1);
		m2.getAlergias().add(alergia2);
		m2.getAlergias().add(alergia3);
	}

	@Test
	@DisplayName("cadastra medicamento")
	public void cadastroMedicamento() {
		Medicamento m3 = new Medicamento("med 3", EnumAdministracao.INJETAVEL, new ArrayList<String>(),
				new ArrayList<String>());
		Medicamento m4 = new Medicamento("med 4", EnumAdministracao.INJETAVEL, new ArrayList<String>(),
				new ArrayList<String>());
		List<Medicamento> aux = bd.cadastraMedicamento(m3);
		aux = bd.cadastraMedicamento(m4);

		Assertions.assertEquals(2, aux.size());
	}

}
