package br.com.trier.disciplina;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matricula {
	private int idMatricula; 
	private Disciplina disciplina;
	
	List<Double>notas = new ArrayList<>();
	
	public Matricula(Disciplina diciplina) {
		super();
		this.disciplina = diciplina;
	}

	public Matricula(Disciplina diciplina, List<Double> notas) {
		super();
		this.disciplina = diciplina;
		this.notas = notas;
	}
	
	
}
