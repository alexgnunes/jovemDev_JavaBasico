package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Professor cadastraProfessor (Professor prof) {
		prof.setId(professores.size()+1);
		professores.add(prof);
		return prof;
	}
	
	public Professor buscaProfId (final Integer id) {
		return professores.stream()
				.filter(p -> id.equals(p.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Aluno cadastraAluno (Aluno aluno) {
		aluno.setId(alunos.size()+1);
		alunos.add(aluno);
		return aluno;
	}
}
