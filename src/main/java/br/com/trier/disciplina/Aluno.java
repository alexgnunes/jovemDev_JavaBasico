package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter

public class Aluno {
	@Setter private int idAluno;
	private String nome;	
	private Double media;
	
	List<Matricula> matriculas = new ArrayList<>();		

	public Aluno(String nome) {
		super();
		this.nome = nome;
	}
	

	
}
