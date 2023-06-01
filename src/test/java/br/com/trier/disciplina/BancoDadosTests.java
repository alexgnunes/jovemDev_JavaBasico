package br.com.trier.disciplina;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BancoDadosTests {
	private BancoDados bd = new BancoDados();

	@BeforeEach
	void init() {
		Professor prof1 = new Professor("prof 1",EnumFormacao.ESPECIALIZACAO);
		Professor prof2 = new Professor("prof 2",EnumFormacao.POSGRADUACAO);
		Professor prof3 = new Professor("prof 3",EnumFormacao.POSGRADUACAO);

		bd.cadastraProfessor(prof1);
		bd.cadastraProfessor(prof2);
		bd.cadastraProfessor(prof3); 
		
		Aluno aluno1 = new Aluno("aluno 1");
		Aluno aluno2 = new Aluno("aluno 2");
		Aluno aluno3 = new Aluno("aluno 3");
		
		bd.cadastraAluno(aluno1);		
		bd.cadastraAluno(aluno2);		
		bd.cadastraAluno(aluno3);
		
		Disciplina disc1 = new Disciplina("Java", 40, prof1);
		Disciplina disc2 = new Disciplina("Spring", 20, prof2);
		Disciplina disc3 = new Disciplina("HTML", 12, prof3);
				
		bd.cadastrarDisciplina(disc1);
		bd.cadastrarDisciplina(disc2);
		bd.cadastrarDisciplina(disc3);
		
		Matricula matricula1 = new Matricula(disc1);
		Matricula matricula2 = new Matricula(disc2);
		Matricula matricula3 = new Matricula(disc3);
	
		
		bd.cadastrarMatricula(matricula1);
		bd.cadastrarMatricula(matricula2);
		bd.cadastrarMatricula(matricula3);
		
		bd.matricularAluno(aluno1, matricula1);
		bd.matricularAluno(aluno1, matricula2);
		bd.matricularAluno(aluno1, matricula3);
		
		matricula1.addNota(9.5);
		matricula1.addNota(9.5);
		matricula1.addNota(9.5);

		matricula2.addNota(9.5);
		matricula2.addNota(3.5);
		matricula2.addNota(5.5);
		
		matricula3.addNota(9.5);
		matricula3.addNota(2.5);
		matricula3.addNota(9.5);
		

	}
	
	@Test
	@DisplayName("cadastro do professor")
	public void cadastraProfLista() {
		bd.cadastraProfessor(new Professor("prof 4",EnumFormacao.POSGRADUACAO));
				
		Assertions.assertEquals("prof 4", bd.buscaProfId(4).getNome());
	}
	
	@Test
	@DisplayName("cadastro do aluno")
	public void cadastraAluno() {
		bd.cadastraAluno(new Aluno("aluno 4"));
		Assertions.assertEquals("aluno 4", bd.buscaAlunoId(4).getNome());
	}
	
	@Test
	@DisplayName ("cadastra a disciplina")
	public void cadastraDisciplina() {
		bd.cadastrarDisciplina(new Disciplina("HTML", 15, bd.buscaProfId(1)));
		Assertions.assertEquals("HTML", bd.buscaDiscilinaId(4).getNomeDisciplina());
		Assertions.assertEquals("prof 1", bd.buscaDiscilinaId(4).getProfessor().getNome());
	}
	 
	@Test
	@DisplayName ("matricula aluno na disciplina")
	public void matriculaAlunoDiscipina() {
		bd.matricularAluno(bd.buscaAlunoId(1), bd.buscaMatriculaId(1));
		bd.matricularAluno(bd.buscaAlunoId(1), bd.buscaMatriculaId(2));
		Assertions.assertEquals("aluno 1", bd.buscaAlunoId(1).getNome());
		Assertions.assertEquals("Java", bd.buscaAlunoId(1).matriculas.get(0).getDisciplina().getNomeDisciplina());
		Assertions.assertEquals("Spring", bd.buscaAlunoId(1).matriculas.get(1).getDisciplina().getNomeDisciplina());
	}
	
	@Test
	@DisplayName("informa as notas em uma disciplina escolhida")
	public void informaNotaAlunoDisciplina() {
		Assertions.assertEquals(9.5, bd.buscaAlunoId(1).matriculas.get(1).notas.get(0));
	}
	
	@Test
	@DisplayName(" mostra as disciplina e media do aluno")
	public void retornaLiistaDisciplinaComMedia() {
		assertEquals(9.50, bd.listarDisciplinasComMedia(1).get(0).getMedia());
	}
	
	@Test
	@DisplayName("lista professores com pos")
	public void listaProfPos() {		
		assertEquals(2,bd.listaProfPos().size() );
	}
}
