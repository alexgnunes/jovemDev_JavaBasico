package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

public class BancoDados {
	private List<Professor> professores = new ArrayList<Professor>();
	private List<Aluno> alunos = new ArrayList<Aluno>();
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private List<Matricula> matriculas = new ArrayList<Matricula>();

	public Professor cadastraProfessor(Professor prof) {
		prof.setId(professores.size() + 1); 
		professores.add(prof);
		return prof;
	}

	public Professor buscaProfId(final Integer id) {
		return professores.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
	}

	public Aluno cadastraAluno (Aluno aluno) {
		aluno.setIdAluno(alunos.size()+1);
		alunos.add(aluno);		
		return aluno;
	}
	
	public Aluno buscaAlunoId(final Integer id) {
		return alunos.stream().filter(p -> id.equals(p.getIdAluno())).findAny().orElse(null);
	}
	
	public Disciplina cadastrarDisciplina(Disciplina disciplina) {
		disciplina.setId(disciplinas.size()+1);
		disciplinas.add(disciplina);
		return disciplina;
	}
	public Disciplina buscaDiscilinaId(final Integer id) {
		return disciplinas.stream().filter(p -> id.equals(p.getId())).findAny().orElse(null);
	}
	
	public void matricularAluno(Aluno aluno, Matricula matricula) {
		Integer id = aluno.getIdAluno();
		Aluno alunoMatricula = alunos.stream().filter(p -> id.equals(p.getIdAluno())).findAny().orElse(null);
		alunoMatricula.matriculas.add(matricula);
	}
 
	public Matricula cadastrarMatricula(Matricula matricula) {
		matricula.setIdMatricula(matriculas.size() + 1);
		matriculas.add(matricula);
		return matricula;		
	}
	
	public Matricula buscaMatriculaId (final Integer id) {
		return matriculas.stream().filter(p -> id.equals(p.getIdMatricula())).findAny().orElse(null);
	}

	public Matricula cadastraNotaAlunoDisciplina(Aluno aluno, Matricula matricula, Double nota1, Double nota2,Double nota3) {
		Matricula matriculaEscolhida = aluno.matriculas.get(matricula.getIdMatricula());
		matriculaEscolhida.notas.add(nota1);
		matriculaEscolhida.notas.add(nota2);
		matriculaEscolhida.notas.add(nota3);
		return matriculaEscolhida;
	}
	
	public String listarDisciplinasComMedia(Integer idAluno) {
		StringBuilder sb = new StringBuilder();
		List<Matricula> matriculasAlunoEscolhido = buscaAlunoId(idAluno).getMatriculas();
		for (Matricula matricula : matriculasAlunoEscolhido) {
            sb.append( matricula.getDisciplina());
            List<Double> notas = matricula.getNotas();
            double media = calcularMedia(notas);
            sb.append(media);
	}
		return null;
	}

	private double calcularMedia(List<Double> notas) {
		double soma = 0.0;
		for (Double nota : notas) {
			soma += nota;
		}
		return soma / notas.size();
	}
}
