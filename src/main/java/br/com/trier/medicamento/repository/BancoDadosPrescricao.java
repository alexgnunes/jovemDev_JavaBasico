package br.com.trier.medicamento.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.medicamento.Pessoa;
import br.com.trier.medicamento.entidades.Medicamento;
import lombok.Getter;

@Getter
public class BancoDadosPrescricao {

	List<Pessoa> pessoas = new ArrayList<Pessoa>();
	List<Medicamento> medicamentos = new ArrayList<Medicamento>();
	
	public void cadastraMedicamento(Medicamento medicamento) {
		medicamentos.add(medicamento);	
	}
	
	public boolean cadastraPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			return false;
		}
		pessoas.add(pessoa);
		return true;
	}
	
	public boolean existePessoa(Pessoa pessoa) {
		return pessoas.contains(pessoa);
	}
	
	public boolean existeMedicamento(Medicamento medicamento) {
		return medicamentos.contains(medicamento);
	}
	
	public boolean prescreveMedicamento(Pessoa p, Medicamento medicamento) {
		if(existePessoa(p) && existeMedicamento(medicamento)) {
			return p.addMedicamento(medicamento);
		
		}
		return false;
	}

}
