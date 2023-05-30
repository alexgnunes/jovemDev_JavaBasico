package br.com.trier.medicamento;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pessoa {
	
	private String nome;
	private String sintoma;
	
	List<String> condicaoSaude  = new ArrayList<>();
	List<Medicamento> medicamentos   = new ArrayList<>();
	
	
	
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

	public Pessoa(String nome, String sintoma) {
		super();
		this.nome = nome;
		this.sintoma = sintoma;
	}
	
}
