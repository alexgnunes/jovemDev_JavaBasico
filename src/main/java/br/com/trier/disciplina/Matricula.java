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
	private double media;
	
	List<Double>notas = new ArrayList<>();
	
	public Matricula(Disciplina diciplina) {
		super();
		this.disciplina = diciplina;
	}
	
	public void addNota(double nota) {
		notas.add(nota);
	}

	

	
}
