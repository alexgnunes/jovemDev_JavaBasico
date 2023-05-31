package br.com.trier.medicamento.entidades;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Pessoa {
	
	private String nome;
	private String sintoma;
	
	List<String> condicaoSaude  = new ArrayList<>();
	List<Medicamento> medicamentos   = new ArrayList<>();
	
	public Pessoa(String nome, String sintoma) {
		super();
		this.nome = nome;
		this.sintoma = sintoma;
	}
	
	public void addCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude.add(condicaoSaude);
	}
	
	public boolean addMedicamento(Medicamento medicamento) {
		if(medicamento.isIndicado(sintoma) && !medicamento.isContraIndicado(condicaoSaude)) {
			medicamentos.add(medicamento);
			return true;
		}
		return false;
	}
	
}
