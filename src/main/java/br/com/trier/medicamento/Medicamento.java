package br.com.trier.medicamento;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.enuns.EnumAdministracao;
import lombok.Getter;

@Getter
public class Medicamento {
	
	private String nomeMedicamento;
	private EnumAdministracao administracao = null; 

	List<String> contraIndicacoes  = new ArrayList<>();
	List<String> indicacoes = new ArrayList<>();
	
	public Medicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	
	public void addIndicacao(String indicacao) {
		indicacoes.add(indicacao);
	}
	
	public void addContraIndicacao(String contraIndicacao) {
		contraIndicacoes.add(contraIndicacao);
	}
	
	public boolean isIndicado(String sintoma) {
		return indicacoes.contains(sintoma);
	}
	
	public boolean isContraIndicado(List<String> condicaoSaude) {
		return contraIndicacoes.stream().
				anyMatch(condicaoSaude :: contains);
	}
	

}
