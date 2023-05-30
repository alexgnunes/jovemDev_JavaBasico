package br.com.trier.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
	
	private Integer idPessoa;
	private String nome;
	private String sintoma;
	
	List<String> alergiasPessoa = new ArrayList<>();
	
	public Pessoa(String nome, String sintoma, List<String> alergiasPessoa) {
		super();
		this.nome = nome;
		this.sintoma = sintoma;
		this.alergiasPessoa = alergiasPessoa;
	}
	
	
}
