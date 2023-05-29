package br.com.trier.disciplina;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Professor {
	private int id;
	private String nome;
	private EnumFormacao formacao;
	
	public Professor(String nome, EnumFormacao formacao) {
		super();
		this.nome = nome;
		this.formacao = formacao;
	}
	
}
