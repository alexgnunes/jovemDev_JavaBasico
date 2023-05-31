package br.com.trier.disciplina;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Disciplina {
	private int id;
	private String nomeDisciplina;
	private int cargaHoraria;
	private Professor professor;
	
	public Disciplina(String nomeDisciplina, int cargaHoraria, Professor professor) {
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
		this.professor = professor;
	}

	
}
