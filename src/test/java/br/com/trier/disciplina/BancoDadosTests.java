package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BancoDadosTests {
	private BancoDados bd = new BancoDados();

	@BeforeEach
	void init() {
		Professor prof1 = new Professor("prof 1",EnumFormacao.ESPECIALIZACAO);
		Professor prof2 = new Professor("prof 2",EnumFormacao.GRADUACAO);
		Professor prof3 = new Professor("prof 3",EnumFormacao.POSGRADUACAO);

		bd.cadastraProfessor(prof1);
		bd.cadastraProfessor(prof2);
		bd.cadastraProfessor(prof3);
		
		
		
		Aluno aluno1 = new Aluno("aluno 1", new ArrayList<Matricula>());
	}
	
	@Test
	@DisplayName("cadastro do professor")
	public void cadastraProfLista() {
		bd.cadastraProfessor(new Professor("prof 4",EnumFormacao.POSGRADUACAO));
				
		Assertions.assertEquals("prof 4", bd.buscaProfId(4).getNome());
	}
}
